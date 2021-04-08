package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker5Simulation {
    val worker5Exec = KerasRestApiScenario.kerasRestApiScenario
      .inject(
          rampUsers(563) during(1 minute),
          rampUsers(555) during(1 minute),
          rampUsers(627) during(1 minute),
          rampUsers(584) during(1 minute),
          rampUsers(594) during(1 minute),
          rampUsers(570) during(1 minute),
          rampUsers(611) during(1 minute),
          rampUsers(697) during(1 minute),
          rampUsers(603) during(1 minute),
          rampUsers(574) during(1 minute),
          rampUsers(599) during(1 minute),
          rampUsers(638) during(1 minute),
          rampUsers(729) during(1 minute),
          rampUsers(630) during(1 minute),
          rampUsers(597) during(1 minute),
          rampUsers(486) during(1 minute),
          rampUsers(582) during(1 minute),
          rampUsers(618) during(1 minute),
          rampUsers(719) during(1 minute),
          rampUsers(541) during(1 minute))
}

class AzureWorker5Simulation extends Simulation {
  setUp(AzureWorker5Simulation.worker5Exec)
}
