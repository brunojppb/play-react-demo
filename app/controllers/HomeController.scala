package controllers

import javax.inject._

import model.DB
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents,
                               DB: DB) extends AbstractController(cc) {

  def getApp: Action[AnyContent] = Action {
    Ok(views.html.index())
  }

  def getIndex: Action[AnyContent] = Action {
    Redirect("/app")
  }

  def getAppAny(any: String): Action[AnyContent] = getApp

}
