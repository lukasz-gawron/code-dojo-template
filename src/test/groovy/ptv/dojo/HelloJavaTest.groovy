package ptv.dojo

import spock.lang.Specification

class HelloJavaTest extends Specification {

  def objectUnderTest = new HelloJava()

  def "should return 'Hello Java!'"() {
    expect:
    objectUnderTest.hello == 'Hello Java!'
  }
}
