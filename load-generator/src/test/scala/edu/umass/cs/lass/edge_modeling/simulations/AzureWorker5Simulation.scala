package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker5Simulation {
  val worker5Exec = KerasRestApiScenario.buildScenario("worker 5")
    .inject(
      constantUsersPerSec(9.38) during (1 minute) randomized,
      constantUsersPerSec(9.25) during (1 minute) randomized,
      constantUsersPerSec(10.45) during (1 minute) randomized,
      constantUsersPerSec(9.73) during (1 minute) randomized,
      constantUsersPerSec(9.90) during (1 minute) randomized,
      constantUsersPerSec(9.50) during (1 minute) randomized,
      constantUsersPerSec(10.18) during (1 minute) randomized,
      constantUsersPerSec(11.62) during (1 minute) randomized,
      constantUsersPerSec(10.05) during (1 minute) randomized,
      constantUsersPerSec(9.57) during (1 minute) randomized,
      constantUsersPerSec(9.98) during (1 minute) randomized,
      constantUsersPerSec(10.63) during (1 minute) randomized,
      constantUsersPerSec(12.15) during (1 minute) randomized,
      constantUsersPerSec(10.50) during (1 minute) randomized,
      constantUsersPerSec(9.95) during (1 minute) randomized,
      constantUsersPerSec(8.10) during (1 minute) randomized,
      constantUsersPerSec(9.70) during (1 minute) randomized,
      constantUsersPerSec(10.30) during (1 minute) randomized,
      constantUsersPerSec(11.98) during (1 minute) randomized,
      constantUsersPerSec(9.02) during (1 minute) randomized)
}

class AzureWorker5Simulation extends Simulation {
  setUp(AzureWorker5Simulation.worker5Exec)
}
