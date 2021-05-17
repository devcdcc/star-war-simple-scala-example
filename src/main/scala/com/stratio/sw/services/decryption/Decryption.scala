package com.stratio.sw.services.decryption

trait Decryption[I,O]{
  def decrypt(input: I): Option[O]
}
