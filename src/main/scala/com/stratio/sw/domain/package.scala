package com.stratio.sw

package object domain {
  case class InterceptedStarSystem(
                                     startSystemOne: String,
                                     startSystemTwo: String
                                   )
  case class InterceptedMessage(
                                 galaxy: String,
                                 quadrant: String,
                                 startSystem: InterceptedStarSystem,
                                 planet: String
                          )
  case class DecryptedMessage(
                               galaxy: String,
                               quadrant: String,
                               startSystem: String,
                               planet: String
                             )
}
