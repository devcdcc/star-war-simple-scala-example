package com.stratio.sw.services.decoders

trait Decoder[T] {
  def decode(input: String) : Option[T]
}
