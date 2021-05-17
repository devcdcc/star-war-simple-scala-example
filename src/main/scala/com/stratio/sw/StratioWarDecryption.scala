package com.stratio.sw

import com.stratio.sw.domain.{DecryptedMessage, InterceptedMessage}
import com.stratio.sw.services.decoders.{Decoder, InterceptedMessageDecoder}
import com.stratio.sw.services.decryption.{Decryption, InterceptedMessageDecrypt}
import com.stratio.sw.services.encoders.{DecryptedMessageEncoder, Encoder}

class StratioWarDecryption(
                            decoder: Decoder[InterceptedMessage] = InterceptedMessageDecoder,
                            encoder: Encoder[DecryptedMessage] = DecryptedMessageEncoder,
                            decryptionService: Decryption[InterceptedMessage, DecryptedMessage] = InterceptedMessageDecrypt
                          ) {
  def decryptRawMessage(targets: Array[String]): Array[String] = {
    targets
      .flatMap(decoder.decode)
      .flatMap(decryptionService.decrypt)
      .map(encoder.encode)
  }
}
