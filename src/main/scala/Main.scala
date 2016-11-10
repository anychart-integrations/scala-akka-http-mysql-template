import java.sql.{Connection, DriverManager}

import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.Source
import scala.io.StdIn
import de.zalando.beard.renderer._
import org.json4s.DefaultFormats
import org.json4s.native.Json

import scala.collection.mutable.ListBuffer


object Main {

   def chartData():String  = {
      // connect to the database named "mysql" on the localhost
      val driver = "com.mysql.jdbc.Driver"
      val url = "jdbc:mysql://localhost/anychart_db"
      val username = "anychart_user"
      val password = "anychart_pass"

      var connection:Connection = null
      var fruits = new ListBuffer[Map[String, Any]]()
      try {
         // make the connection
         Class.forName(driver)
         connection = DriverManager.getConnection(url, username, password)
         // create the statement, and run the select query
         val statement = connection.createStatement()
         val resultSet = statement.executeQuery("SELECT name, value FROM fruits ORDER BY value DESC LIMIT 5")
         while ( resultSet.next() ) {
            val name = resultSet.getString("name")
            val value = resultSet.getInt("value")
            fruits += Map("name" -> name, "value" -> value)
         }
      } catch {
         case e: Throwable => e.printStackTrace
      }
      connection.close()
      Json(DefaultFormats).write(fruits.toList)
   }


   def setTemplate(): String ={
      val loader = new ClasspathTemplateLoader(
         templatePrefix = "/templates/",
         templateSuffix = ".beard"
      )
      val templateCompiler = new CustomizableTemplateCompiler(templateLoader = loader)
      val template = templateCompiler.compile(TemplateName("index")).get

      val context: Map[String, Object] = Map("title" -> "Scala Akka Http template",
         "chartTitle" -> "Top 5 fruits",
         "chartData" -> chartData())

      val renderer = new BeardTemplateRenderer(templateCompiler)
      val result = renderer.render(template,
         StringWriterRenderResult(),
         context)
      result.toString
   }


   def main(args: Array[String]) {
      implicit val system = ActorSystem("my-system")
      implicit val materializer = ActorMaterializer()

      // needed for the future flatMap/onComplete in the end
      implicit val executionContext = system.dispatcher

      val route =
         pathSingleSlash {
            get {
               complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, setTemplate()))
            }
         } ~ pathPrefix("static") {
            // optionally compresses the response with Gzip or Deflate
            // if the client accepts compressed responses
            encodeResponse {
               // serve up static content from a JAR resource
               getFromResourceDirectory("static")
            }
         }

      val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

      println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
      StdIn.readLine() // let it run until user presses return
      bindingFuture
         .flatMap(_.unbind()) // trigger unbinding from the port
         .onComplete(_ => system.terminate()) // and shutdown when done
   }

}

