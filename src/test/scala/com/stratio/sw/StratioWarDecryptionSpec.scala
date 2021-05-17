package com.stratio.sw
import org.scalatest._
import featurespec._
import matchers.must.Matchers._
class StratioWarDecryptionSpec extends AnyFeatureSpec with GivenWhenThen {
  var subject: StratioWarDecryption = new StratioWarDecryption
  info("Stratio has a list of encrypted coordinates from the death star")
  info("in order to reestablish the peace in the interplanetary system")
  info("Stratio needs you to find out the targets positions.")
  Feature("Decrypt targets Position") {
    Scenario("For a set of target positions we must decrypt that correctly"){
      Given("a set of target positions")
      val input = List(
        "2952410b-0a94-446b-8bcb-448dc6e30b08",
        "6f9c15fa-ef51-4415-afab-36218d76c2d9",
        "2ab81c9b-1719-400c-a676-bdba976150eb"
      )
      And("expected value")
      val expected = List(
        "34-10-42-edcb86430",
        "73-15-46-dc9876321",
        "64-9-29-edba976510"
      )
      When("i call to decrypt raw messages")
      val results = subject.decryptRawMessage(input)
      Then("results must be expected input")
      results mustBe expected
    }
  }
}
