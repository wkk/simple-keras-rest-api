package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker2Simulation {
  val worker2Exec = KerasRestApiScenario.kerasRestApiScenario
    .inject(
      constantUsersPerSec(8.83) during (1 minute) randomized,
      constantUsersPerSec(7.90) during (1 minute) randomized,
      constantUsersPerSec(7.35) during (1 minute) randomized,
      constantUsersPerSec(9.03) during (1 minute) randomized,
      constantUsersPerSec(11.35) during (1 minute) randomized,
      constantUsersPerSec(10.32) during (1 minute) randomized,
      constantUsersPerSec(11.30) during (1 minute) randomized,
      constantUsersPerSec(9.43) during (1 minute) randomized,
      constantUsersPerSec(6.23) during (1 minute) randomized,
      constantUsersPerSec(6.82) during (1 minute) randomized,
      constantUsersPerSec(9.12) during (1 minute) randomized,
      constantUsersPerSec(9.37) during (1 minute) randomized,
      constantUsersPerSec(6.60) during (1 minute) randomized,
      constantUsersPerSec(7.80) during (1 minute) randomized,
      constantUsersPerSec(7.47) during (1 minute) randomized,
      constantUsersPerSec(7.55) during (1 minute) randomized,
      constantUsersPerSec(8.67) during (1 minute) randomized,
      constantUsersPerSec(9.60) during (1 minute) randomized,
      constantUsersPerSec(10.33) during (1 minute) randomized,
      constantUsersPerSec(9.02) during (1 minute) randomized)
}

class AzureWorker2Simulation extends Simulation {
  setUp(AzureWorker2Simulation.worker2Exec)
}
