package edu.umass.cs.lass.edge_modeling.config

import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.{DurationDouble, FiniteDuration}

object Config {
  private val config = ConfigFactory.load()


  val debug: Boolean = config.hasPath("debug")

  private val addr = config.getString("server_address")
  val predictUrl = s"http://$addr/predict"

  val numberOfRequests: Int =
    if (config.hasPath("number_of_requests"))
      config.getInt("number_of_requests")
    else
      2000

  val requestRate: Double = {
    if (config.hasPath("request_rate"))
      config.getDouble("request_rate")
    else
      10.0
  }
  val duration: FiniteDuration = math.ceil(numberOfRequests / requestRate) seconds
}
