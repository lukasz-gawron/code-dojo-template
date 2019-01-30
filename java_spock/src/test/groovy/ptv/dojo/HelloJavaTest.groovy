package ptv.dojo

import spock.lang.Specification
import spock.lang.Unroll

class HelloJavaTest extends Specification {

  def objectUnderTest = new HelloJava()

  def "should say 'Hello Java!'"() {
    expect:
    objectUnderTest.greet() == "Hello Java!"
  }

  @Unroll
  def "should say 'Hello #name!'"() {
    expect:
    objectUnderTest.greet(name) == "Hello $name!"

    where:
    name << ['Java', 'World']
  }
}
