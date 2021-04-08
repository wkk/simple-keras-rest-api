package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker2Simulation {
    val worker2Exec = KerasRestApiScenario.kerasRestApiScenario
      .inject(
          rampUsers(530) during(1 minute),
          rampUsers(474) during(1 minute),
          rampUsers(441) during(1 minute),
          rampUsers(542) during(1 minute),
          rampUsers(681) during(1 minute),
          rampUsers(619) during(1 minute),
          rampUsers(678) during(1 minute),
          rampUsers(566) during(1 minute),
          rampUsers(374) during(1 minute),
          rampUsers(409) during(1 minute),
          rampUsers(547) during(1 minute),
          rampUsers(562) during(1 minute),
          rampUsers(396) during(1 minute),
          rampUsers(468) during(1 minute),
          rampUsers(448) during(1 minute),
          rampUsers(453) during(1 minute),
          rampUsers(520) during(1 minute),
          rampUsers(576) during(1 minute),
          rampUsers(620) during(1 minute),
          rampUsers(541) during(1 minute))
}

class AzureWorker2Simulation extends Simulation {
  setUp(AzureWorker2Simulation.worker2Exec)
}
