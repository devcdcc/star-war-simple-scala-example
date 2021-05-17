package com.stratio.sw.services.decryption

import scala.util.Try

class PlanetDecrypt extends Decryption [String, String]{
  override def decrypt(input: String): Option[String] = Try{
    input.split("").distinct.sortWith(_ > _).mkString
  }
    .toOption
}
object PlanetDecrypt extends PlanetDecrypt
