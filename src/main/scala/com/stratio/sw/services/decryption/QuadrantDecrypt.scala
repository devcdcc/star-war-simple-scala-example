package com.stratio.sw.services.decryption

import scala.util.Try

class QuadrantDecrypt extends Decryption[String, String] {
  override def decrypt(input: String): Option[String] =
    Try(input.split("").map(Integer.parseInt(_, 16)).max)
      .map(_.toString)
      .toOption
}
object QuadrantDecrypt extends QuadrantDecrypt