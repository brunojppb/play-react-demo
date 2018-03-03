
val commonSettings = Seq(
  name := "react",
  version := "1.0",
  organization := "pm.pb.gov.br",
  version := "1.0-0",
  scalaVersion := "2.12.4",
  sources in (Compile, doc) := List(), // skip api generation
  routesGenerator := InjectedRoutesGenerator)

lazy val main = (project in file("."))
  .enablePlugins(play.sbt.PlayScala, SbtWeb)
    .settings(
      commonSettings,
      libraryDependencies ++= Seq(
        guice,
        ehcache, // play cache external module
        "org.joda" % "joda-convert" % "1.8.2",
        "joda-time" % "joda-time" % "2.9.9",
        "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0", // map db timestamp to jodatime
        "com.typesafe.slick" %% "slick" % "3.2.1", // db mapper
        "com.typesafe.play" %% "play-slick" % "3.0.0", // db mapper play integration
        "com.typesafe.play" %% "play-slick-evolutions" % "3.0.0", // db migrations
        "org.postgresql" % "postgresql" % "9.4.1208.jre7", // postgres db driver
        "com.typesafe.play" %% "play-json" % "2.6.7",
        "com.typesafe.play" %% "play-json-joda" % "2.6.7",
        ws)
    )

