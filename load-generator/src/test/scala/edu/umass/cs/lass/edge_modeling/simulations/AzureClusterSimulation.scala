package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureClusterSimulation {
  val clusterExec = KerasRestApiScenario.kerasRestApiScenario
    .inject(
      rampUsers(2429) during(1 minute),
      rampUsers(2473) during(1 minute),
      rampUsers(2227) during(1 minute),
      rampUsers(2515) during(1 minute),
      rampUsers(2651) during(1 minute),
      rampUsers(2602) during(1 minute),
      rampUsers(2657) during(1 minute),
      rampUsers(2599) during(1 minute),
      rampUsers(2239) during(1 minute),
      rampUsers(2307) during(1 minute),
      rampUsers(2275) during(1 minute),
      rampUsers(2446) during(1 minute),
      rampUsers(2527) during(1 minute),
      rampUsers(2456) during(1 minute),
      rampUsers(2361) during(1 minute),
      rampUsers(2353) during(1 minute),
      rampUsers(2243) during(1 minute),
      rampUsers(2483) during(1 minute),
      rampUsers(2661) during(1 minute),
      rampUsers(2442) during(1 minute))
}

class AzureClusterSimulation extends Simulation {
  setUp(AzureClusterSimulation.clusterExec)
}
