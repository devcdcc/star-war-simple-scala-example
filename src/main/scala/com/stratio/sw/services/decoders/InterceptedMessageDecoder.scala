package com.stratio.sw.services.decoders

import com.stratio.sw.domain.{InterceptedMessage, InterceptedStarSystem}

import scala.util.Try

class InterceptedMessageDecoder extends Decoder[InterceptedMessage]{
  override def decode(input: String): Option[InterceptedMessage] = Try {
        val splitData = input.split("-")
        InterceptedMessage(
          splitData(0),
          splitData(1),
          InterceptedStarSystem(splitData(2), splitData(3)),
          splitData(4)
        )
      }.toOption
}
object InterceptedMessageDecoder extends InterceptedMessageDecoder