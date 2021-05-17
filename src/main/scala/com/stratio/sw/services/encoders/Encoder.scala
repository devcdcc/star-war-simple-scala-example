package com.stratio.sw.services.encoders

trait Encoder[T] {
  def encode(input: T): String
}
