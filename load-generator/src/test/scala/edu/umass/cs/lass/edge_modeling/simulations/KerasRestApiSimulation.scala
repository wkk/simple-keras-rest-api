package edu.umass.cs.lass.edge_modeling.simulations

import java.io.{BufferedWriter, FileWriter}
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import akka.actor._
import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef._

import edu.umass.cs.lass.edge_modeling.config.Config._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario


object ResponseTimeLogger {
  def props(bufferedWriter: BufferedWriter) = Props(new ResponseTimeLogger(bufferedWriter))

  case class Write(str: String)

  object Terminate

}

class ResponseTimeLogger(bufferedWriter: BufferedWriter) extends Actor {
  override def receive: Receive = {
    case ResponseTimeLogger.Write(str) =>
      bufferedWriter.write(str)
      bufferedWriter.newLine()
    case ResponseTimeLogger.Terminate =>
      bufferedWriter.flush()
      bufferedWriter.close()
      context.system.terminate()
  }
}

class KerasRestApiSimulation extends Simulation {
  if (debug) {
    // Log all HTTP requests
    import ch.qos.logback.classic.{Level, LoggerContext}
    import org.slf4j.LoggerFactory
    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
  }

  private val currentTime = LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))
  private val bufferedWriter = new BufferedWriter(new FileWriter(s"output/$currentTime-$numberOfRequests-$requestRate.log"))
  private val system = ActorSystem("mySystem")
  private val responseTimeLogger = system.actorOf(ResponseTimeLogger.props(bufferedWriter))

  private val kerasRestApiExec = KerasRestApiScenario.kerasRestApiScenario.exec { session =>
    responseTimeLogger ! ResponseTimeLogger.Write(session("serviceTime").as[String])
    session
  }.inject(constantUsersPerSec(requestRate).during(duration).randomized)

  setUp(kerasRestApiExec)

  after {
    responseTimeLogger ! ResponseTimeLogger.Terminate
    Await.result(system.whenTerminated, Duration.Inf)
  }
}
