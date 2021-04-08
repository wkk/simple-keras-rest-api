package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker1Simulation {
    val worker1Exec = KerasRestApiScenario.kerasRestApiScenario
      .inject(
          rampUsers(523) during(1 minute),
          rampUsers(601) during(1 minute),
          rampUsers(328) during(1 minute),
          rampUsers(529) during(1 minute),
          rampUsers(522) during(1 minute),
          rampUsers(535) during(1 minute),
          rampUsers(488) during(1 minute),
          rampUsers(495) during(1 minute),
          rampUsers(501) during(1 minute),
          rampUsers(544) during(1 minute),
          rampUsers(270) during(1 minute),
          rampUsers(475) during(1 minute),
          rampUsers(523) during(1 minute),
          rampUsers(509) during(1 minute),
          rampUsers(487) during(1 minute),
          rampUsers(579) during(1 minute),
          rampUsers(265) during(1 minute),
          rampUsers(539) during(1 minute),
          rampUsers(479) during(1 minute),
          rampUsers(522) during(1 minute))
}

class AzureWorker1Simulation extends Simulation {
  setUp(AzureWorker1Simulation.worker1Exec)
}
