package com.stratio.sw.services.decryption

import scala.util.Try

class GalaxyDecrypt extends Decryption[String, String] {
  override def decrypt(input: String): Option[String] =
    Try(input.split("").map(Integer.parseInt(_, 16)).sum)
      .map(_.toString)
      .toOption
}
object GalaxyDecrypt extends GalaxyDecrypt