package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker4Simulation {
  val worker4Exec = KerasRestApiScenario.buildScenario("worker 4")
    .inject(
      constantUsersPerSec(4.47) during (1 minute) randomized,
      constantUsersPerSec(3.60) during (1 minute) randomized,
      constantUsersPerSec(4.32) during (1 minute) randomized,
      constantUsersPerSec(4.13) during (1 minute) randomized,
      constantUsersPerSec(4.72) during (1 minute) randomized,
      constantUsersPerSec(4.33) during (1 minute) randomized,
      constantUsersPerSec(4.63) during (1 minute) randomized,
      constantUsersPerSec(3.40) during (1 minute) randomized,
      constantUsersPerSec(4.52) during (1 minute) randomized,
      constantUsersPerSec(3.70) during (1 minute) randomized,
      constantUsersPerSec(3.70) during (1 minute) randomized,
      constantUsersPerSec(3.47) during (1 minute) randomized,
      constantUsersPerSec(3.72) during (1 minute) randomized,
      constantUsersPerSec(3.45) during (1 minute) randomized,
      constantUsersPerSec(4.17) during (1 minute) randomized,
      constantUsersPerSec(4.17) during (1 minute) randomized,
      constantUsersPerSec(3.97) during (1 minute) randomized,
      constantUsersPerSec(3.63) during (1 minute) randomized,
      constantUsersPerSec(4.33) during (1 minute) randomized,
      constantUsersPerSec(3.87) during (1 minute) randomized)
}

class AzureWorker4Simulation extends Simulation {
  setUp(AzureWorker4Simulation.worker4Exec)
}
