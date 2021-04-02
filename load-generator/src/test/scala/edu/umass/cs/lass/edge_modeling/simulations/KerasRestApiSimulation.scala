package edu.umass.cs.lass.edge_modeling.simulations

import io.gatling.core.Predef.Simulation
import io.gatling.core.Predef._

import edu.umass.cs.lass.edge_modeling.config.Config.{debug, duration, requestRate}
import edu.umass.cs.lass.edge_modeling.scenarios.HealthCheckScenario

class KerasRestApiSimulation extends Simulation {
  if (debug) {
    // Log all HTTP requests
    import ch.qos.logback.classic.{Level, LoggerContext}
    import org.slf4j.LoggerFactory
    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
  }

  private val kerasRestApiExec = KerasRestApiScenario.kerasRestApiScenario
    .inject(constantUsersPerSec(requestRate).during(duration).randomized)

  setUp(kerasRestApiExec)
}
