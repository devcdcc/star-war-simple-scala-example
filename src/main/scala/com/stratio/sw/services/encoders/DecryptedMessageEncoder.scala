package com.stratio.sw.services.encoders

import com.stratio.sw.domain.DecryptedMessage

class DecryptedMessageEncoder extends Encoder[DecryptedMessage]{
  override def encode(input: DecryptedMessage): String =
    s"${input.galaxy}-${input.quadrant}-${input.startSystem}-${input.planet}"
}
object DecryptedMessageEncoder extends DecryptedMessageEncoder