package com.stratio.sw
import zhttp.http._
import zhttp.service._
import zio._
import zio.json._

object StratioWarServer {

  // Set a port
  val PORT: Int = 8090

  private val healthChek: HttpApp[Any, Nothing] = HttpApp.collect {
    case Method.GET -> Root / "healthCheck" => Response.text("ok")
  }

//  def eitherToResponse(input: Either[String, List[String]]): UResponse = input match {
//    case Left(_) => Response.status(Status.BAD_REQUEST)
//    case Right(value) => Response.jsonString(value.toJson)
//  }

  val decryptionService: StratioWarDecryption = new StratioWarDecryption()
  def eitherToResponse(input: Either[String, List[String]]): UResponse = input match {
    case Left(_) => Response.status(Status.BAD_REQUEST)
    case Right(value) => Response.jsonString(decryptionService.decryptRawMessage(value).toJson)
  }
  private val app: HttpApp[Any, Nothing] = HttpApp.collectM {
    case request @ Method.GET -> Root / "decryption" =>
      val body = request.getBodyAsString.map(_.fromJson[List[String]]).map(eitherToResponse)
      val response = body.fold(Response.status(Status.BAD_REQUEST))(b => b)
      ZIO.succeed(response)
  }

  val server: Server[Any, Nothing] =
    Server.port(PORT) ++              // Setup port
      Server.paranoidLeakDetection ++ // Paranoid leak detection (affects performance)
      Server.app(healthChek +++ app)      // Setup the Http app

}
