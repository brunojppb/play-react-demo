package model

import java.sql.{BatchUpdateException, SQLException}
import java.util.concurrent.TimeUnit
import javax.inject._

import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.duration.FiniteDuration
import scala.concurrent.{Await, ExecutionContext, Future}
import slick.dbio.{DBIOAction, NoStream}
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._


@Singleton
class DB @Inject()(databaseConfigProvider: DatabaseConfigProvider) {
  DB.database = databaseConfigProvider.get[JdbcProfile].db
}

/**
  * Represents the default database used for this app
  */
object DB {

  private var database: Database = _
  private val logger = Logger(getClass)

  private val dbPool = ExecutionContext.fromExecutorService(java.util.concurrent.Executors.newFixedThreadPool(1))

  def close(): Unit = {
    database.close()
  }

  /**
    * Run the supplied function with a new session and automatically close the session at the end.
    */
  def apply[R](a: DBIOAction[R, NoStream, Nothing]): R = {
    await(traced(a, (new Throwable).getStackTrace, logErrors = true))
  }

  def await[A](future: Future[A]): A = {
    try {
      Await.result(future, FiniteDuration(10, TimeUnit.MINUTES))
    } catch {
      case ex: Exception => throw new SQLException(ex.getMessage, ex)
    }
  }

  def traced[R](a: DBIOAction[R, NoStream, Nothing], trace: Array[StackTraceElement], logErrors: Boolean): Future[R] = {

    database.run(a).map(result => result)(dbPool).recover {
      case ex: Exception =>
        if (logErrors) {
          logger.error("DB Exception in " + ex)
        }
        ex match {
          case ex: BatchUpdateException =>
            val firstBatchEx = Option(ex.getNextException).getOrElse(ex)
            throw firstBatchEx
          case ex: Exception =>
            throw ex
        }
    }(dbPool)
  }

}

