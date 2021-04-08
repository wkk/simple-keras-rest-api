package edu.umass.cs.lass.edge_modeling.scenarios

import java.io.File
import java.nio.file.Files
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import edu.umass.cs.lass.edge_modeling.config.Config.predictUrl

import scala.util.Random

object KerasRestApiScenario {
  private val imagesFolder = new File(getClass.getResource("/images").getPath)
  private val images = imagesFolder.listFiles().map(f => Files.readAllBytes(f.toPath))
  private val randomImages = Iterator.continually(
    Map(
      "randomImage" -> images(Random.nextInt(images.length))
    )
  )

  def buildScenario(scenarioName: String) = {
    scenario(scenarioName)
      .feed(randomImages)
      .exec(
        http("post image")
          .post(predictUrl)
          .bodyPart(
            ByteArrayBodyPart("image", "${randomImage}")
              .fileName("image.jpg")
              .contentType("image/jpeg")).asMultipartForm
          .check(status is 200)
          .check(jsonPath("$.success") is "true")
          .check(jsonPath("$.service_time") saveAs "serviceTime")
      )
  }

  val kerasRestApiScenario = buildScenario("Keras REST API")
}
