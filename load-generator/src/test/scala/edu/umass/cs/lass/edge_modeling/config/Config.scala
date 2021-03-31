package edu.umass.cs.lass.edge_modeling.config

import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.{DurationDouble, FiniteDuration}

object Config {
  private val config = ConfigFactory.load()


  val debug: Boolean = config.hasPath("debug")

  private val addr = config.getString("server_address")
  val url = s"http://$addr/predict"

  val number_of_requests: Int = config.getInt("number_of_requests")
  val request_rate: Double = config.getDouble("request_rate")
  val duration: FiniteDuration = math.ceil(number_of_requests / request_rate) seconds
}
