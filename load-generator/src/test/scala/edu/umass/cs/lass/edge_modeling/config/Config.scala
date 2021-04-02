package edu.umass.cs.lass.edge_modeling.config

import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.{DurationDouble, FiniteDuration}

object Config {
  private val config = ConfigFactory.load()


  val debug: Boolean = config.hasPath("debug")

  private val addr = config.getString("server_address")
  val predictUrl = s"http://$addr/predict"

  val numberOfRequests: Int = config.getInt("number_of_requests")
  val requestRate: Double = config.getDouble("request_rate")
  val duration: FiniteDuration = math.ceil(numberOfRequests / requestRate) seconds
}
