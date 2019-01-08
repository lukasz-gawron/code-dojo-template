package ptv.dojo

import spock.lang.Specification

class HelloKotlinTest extends Specification {

  def objectUnderTest = new HelloKotlin()

  def "should return 'Hello Kotlin!'"() {
    expect:
    objectUnderTest.hello == 'Hello Kotlin!'
  }
}
