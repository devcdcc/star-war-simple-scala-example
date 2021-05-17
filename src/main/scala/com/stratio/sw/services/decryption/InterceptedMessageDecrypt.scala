package com.stratio.sw.services.decryption

import com.stratio.sw.domain.{DecryptedMessage, InterceptedMessage, InterceptedStarSystem}

class InterceptedMessageDecrypt(
                                 galaxyDecrypt: Decryption[String, String] = GalaxyDecrypt,
                                 quadrantDecrypt: Decryption[String, String] = QuadrantDecrypt,
                                 starSystemDecrypt: Decryption[InterceptedStarSystem, String] = StarSystemDecrypt,
                                 planetDecrypt: Decryption[String, String] = PlanetDecrypt
                               ) extends Decryption[InterceptedMessage, DecryptedMessage]{
  override def decrypt(input: InterceptedMessage): Option[DecryptedMessage] = {
    for {
      decryptedGalaxy <- galaxyDecrypt.decrypt(input.galaxy)
      decryptedQuadrant <- quadrantDecrypt.decrypt(input.quadrant)
      decryptedStartSystem <- starSystemDecrypt.decrypt(input.startSystem)
      decryptedPlanet <- planetDecrypt.decrypt(input.planet)
      result <- Option(DecryptedMessage(decryptedGalaxy, decryptedQuadrant, decryptedStartSystem, decryptedPlanet))
    } yield result
  }
}
object InterceptedMessageDecrypt extends InterceptedMessageDecrypt(GalaxyDecrypt, QuadrantDecrypt, StarSystemDecrypt, PlanetDecrypt)