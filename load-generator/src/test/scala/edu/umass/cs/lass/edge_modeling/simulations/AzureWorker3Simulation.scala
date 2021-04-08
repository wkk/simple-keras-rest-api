package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker3Simulation {
  val worker3Exec = KerasRestApiScenario.buildScenario("worker 3")
    .inject(
      constantUsersPerSec(9.08) during (1 minute) randomized,
      constantUsersPerSec(10.45) during (1 minute) randomized,
      constantUsersPerSec(9.53) during (1 minute) randomized,
      constantUsersPerSec(10.20) during (1 minute) randomized,
      constantUsersPerSec(9.52) during (1 minute) randomized,
      constantUsersPerSec(10.30) during (1 minute) randomized,
      constantUsersPerSec(10.03) during (1 minute) randomized,
      constantUsersPerSec(10.62) during (1 minute) randomized,
      constantUsersPerSec(8.17) during (1 minute) randomized,
      constantUsersPerSec(9.30) during (1 minute) randomized,
      constantUsersPerSec(10.62) during (1 minute) randomized,
      constantUsersPerSec(9.38) during (1 minute) randomized,
      constantUsersPerSec(10.93) during (1 minute) randomized,
      constantUsersPerSec(10.70) during (1 minute) randomized,
      constantUsersPerSec(9.65) during (1 minute) randomized,
      constantUsersPerSec(9.75) during (1 minute) randomized,
      constantUsersPerSec(10.63) during (1 minute) randomized,
      constantUsersPerSec(8.87) during (1 minute) randomized,
      constantUsersPerSec(9.72) during (1 minute) randomized,
      constantUsersPerSec(10.10) during (1 minute) randomized)
}

class AzureWorker3Simulation extends Simulation {
  setUp(AzureWorker3Simulation.worker3Exec)
}
