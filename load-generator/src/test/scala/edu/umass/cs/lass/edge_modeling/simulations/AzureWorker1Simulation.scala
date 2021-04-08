package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker1Simulation {
  val worker1Exec = KerasRestApiScenario.buildScenario("Worker 1")
    .inject(
      constantUsersPerSec(8.72) during (1 minute) randomized,
      constantUsersPerSec(10.02) during (1 minute) randomized,
      constantUsersPerSec(5.47) during (1 minute) randomized,
      constantUsersPerSec(8.82) during (1 minute) randomized,
      constantUsersPerSec(8.70) during (1 minute) randomized,
      constantUsersPerSec(8.92) during (1 minute) randomized,
      constantUsersPerSec(8.13) during (1 minute) randomized,
      constantUsersPerSec(8.25) during (1 minute) randomized,
      constantUsersPerSec(8.35) during (1 minute) randomized,
      constantUsersPerSec(9.07) during (1 minute) randomized,
      constantUsersPerSec(4.50) during (1 minute) randomized,
      constantUsersPerSec(7.92) during (1 minute) randomized,
      constantUsersPerSec(8.72) during (1 minute) randomized,
      constantUsersPerSec(8.48) during (1 minute) randomized,
      constantUsersPerSec(8.12) during (1 minute) randomized,
      constantUsersPerSec(9.65) during (1 minute) randomized,
      constantUsersPerSec(4.42) during (1 minute) randomized,
      constantUsersPerSec(8.98) during (1 minute) randomized,
      constantUsersPerSec(7.98) during (1 minute) randomized,
      constantUsersPerSec(8.70) during (1 minute) randomized)
}

class AzureWorker1Simulation extends Simulation {
  setUp(AzureWorker1Simulation.worker1Exec)
}
