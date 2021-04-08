package edu.umass.cs.lass.edge_modeling.simulations

import io.gatling.core.Predef._

class AzureClusterSimulation extends Simulation {
  setUp(
      AzureWorker1Simulation.worker1Exec,
      AzureWorker2Simulation.worker2Exec,
      AzureWorker3Simulation.worker3Exec,
      AzureWorker4Simulation.worker4Exec,
      AzureWorker5Simulation.worker5Exec
  )
}
