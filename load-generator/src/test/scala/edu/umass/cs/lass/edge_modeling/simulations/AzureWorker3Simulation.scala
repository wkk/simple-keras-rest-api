package edu.umass.cs.lass.edge_modeling.simulations

import scala.concurrent.duration.DurationInt
import io.gatling.core.Predef._
import edu.umass.cs.lass.edge_modeling.scenarios.KerasRestApiScenario

object AzureWorker3Simulation {
    val worker3Exec = KerasRestApiScenario.kerasRestApiScenario
      .inject(
          rampUsers(545) during(1 minute),
          rampUsers(627) during(1 minute),
          rampUsers(572) during(1 minute),
          rampUsers(612) during(1 minute),
          rampUsers(571) during(1 minute),
          rampUsers(618) during(1 minute),
          rampUsers(602) during(1 minute),
          rampUsers(637) during(1 minute),
          rampUsers(490) during(1 minute),
          rampUsers(558) during(1 minute),
          rampUsers(637) during(1 minute),
          rampUsers(563) during(1 minute),
          rampUsers(656) during(1 minute),
          rampUsers(642) during(1 minute),
          rampUsers(579) during(1 minute),
          rampUsers(585) during(1 minute),
          rampUsers(638) during(1 minute),
          rampUsers(532) during(1 minute),
          rampUsers(583) during(1 minute),
          rampUsers(606) during(1 minute))
}

class AzureWorker3Simulation extends Simulation {
  setUp(AzureWorker3Simulation.worker3Exec)
}
