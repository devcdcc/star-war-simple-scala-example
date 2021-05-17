package com.stratio.sw

import com.stratio.sw.domain.InterceptedStarSystem
import com.stratio.sw.services.decryption.{GalaxyDecrypt, PlanetDecrypt, StarSystemDecrypt}

object Main extends App {
  val x = new PlanetDecrypt()
  println(x.decrypt("448dc6e30b08"))
}
