name := "scala-akka-http-mysql-template"

version := "1.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
   "com.typesafe.akka" %% "akka-http-core" % "2.4.6",
   "com.typesafe.akka" %% "akka-http-experimental" % "2.4.6",
   "de.zalando" %% "beard" % "0.1.2",
   "mysql" % "mysql-connector-java" % "5.1.24",
   "org.json4s" %% "json4s-native" % "3.5.0"
)

resolvers ++= Seq(
   "zalando-maven" at "https://dl.bintray.com/zalando/maven"
)