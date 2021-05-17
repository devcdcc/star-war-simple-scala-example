package com.stratio.sw.services.decryption

import com.stratio.sw.domain.InterceptedStarSystem

import scala.util.Try

class StarSystemDecrypt extends Decryption[InterceptedStarSystem, String] {
  def selectGreater(input: InterceptedStarSystem) = {
    val (starSystemOne, starSystemTwo) = (Integer.parseInt(input.startSystemOne, 16),Integer.parseInt(input.startSystemTwo, 16))
    if(starSystemOne > starSystemTwo) input.startSystemOne else input.startSystemTwo
  }
  override def decrypt(input: InterceptedStarSystem): Option[String] = {
    Try(selectGreater(input))
      .map(_.split(""))
      .map(_.map(Integer.parseInt(_, 16)))
      .map(_.sum)
      .map(_.toString)
      .toOption
  }
}
object StarSystemDecrypt extends StarSystemDecrypt