package edu.umass.cs.lass.edge_modeling.scenarios

import java.io.File
import java.nio.file.Files
import io.gatling.core.Predef.scenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import edu.umass.cs.lass.edge_modeling.config.Config.url

import scala.util.Random

object KerasRestApiScenario {
  private val imagesFolder = new File(getClass.getResource("/images").getPath)
  private val images = imagesFolder.listFiles().map(f => Files.readAllBytes(f.toPath))
  private val randomImages = Iterator.continually(
    Map(
      "randomImage" -> images(Random.nextInt(images.length))
    )
  )

  val kerasRestApiScenario = scenario("Keras rest api")
    .feed(randomImages)
    .exec(
      http("post image")
        .post(url)
        .bodyPart(
          ByteArrayBodyPart("image", "${randomImage}")
            .fileName("image.jpg")
            .contentType("image/jpeg")).asMultipartForm
        .check(status is 200)
        .check(jsonPath("$.success") is "true")
    )
}
