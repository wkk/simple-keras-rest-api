package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureClusterSimulation {
  val clusterExec = KerasRestApiScenario.kerasRestApiScenario
    .inject(
      constantUsersPerSec(40.48) during (1 minute) randomized,
      constantUsersPerSec(41.22) during (1 minute) randomized,
      constantUsersPerSec(37.12) during (1 minute) randomized,
      constantUsersPerSec(41.92) during (1 minute) randomized,
      constantUsersPerSec(44.18) during (1 minute) randomized,
      constantUsersPerSec(43.37) during (1 minute) randomized,
      constantUsersPerSec(44.28) during (1 minute) randomized,
      constantUsersPerSec(43.32) during (1 minute) randomized,
      constantUsersPerSec(37.32) during (1 minute) randomized,
      constantUsersPerSec(38.45) during (1 minute) randomized,
      constantUsersPerSec(37.92) during (1 minute) randomized,
      constantUsersPerSec(40.77) during (1 minute) randomized,
      constantUsersPerSec(42.12) during (1 minute) randomized,
      constantUsersPerSec(40.93) during (1 minute) randomized,
      constantUsersPerSec(39.35) during (1 minute) randomized,
      constantUsersPerSec(39.22) during (1 minute) randomized,
      constantUsersPerSec(37.38) during (1 minute) randomized,
      constantUsersPerSec(41.38) during (1 minute) randomized,
      constantUsersPerSec(44.35) during (1 minute) randomized,
      constantUsersPerSec(40.70) during (1 minute) randomized)
}

class AzureClusterSimulation extends Simulation {
  setUp(AzureClusterSimulation.clusterExec)
}
