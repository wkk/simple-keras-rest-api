package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker4Simulation {
    val worker4Exec = KerasRestApiScenario.kerasRestApiScenario
      .inject(
          rampUsers(268) during(1 minute),
          rampUsers(216) during(1 minute),
          rampUsers(259) during(1 minute),
          rampUsers(248) during(1 minute),
          rampUsers(283) during(1 minute),
          rampUsers(260) during(1 minute),
          rampUsers(278) during(1 minute),
          rampUsers(204) during(1 minute),
          rampUsers(271) during(1 minute),
          rampUsers(222) during(1 minute),
          rampUsers(222) during(1 minute),
          rampUsers(208) during(1 minute),
          rampUsers(223) during(1 minute),
          rampUsers(207) during(1 minute),
          rampUsers(250) during(1 minute),
          rampUsers(250) during(1 minute),
          rampUsers(238) during(1 minute),
          rampUsers(218) during(1 minute),
          rampUsers(260) during(1 minute),
          rampUsers(232) during(1 minute))
}

class AzureWorker4Simulation extends Simulation {
  setUp(AzureWorker4Simulation.worker4Exec)
}
