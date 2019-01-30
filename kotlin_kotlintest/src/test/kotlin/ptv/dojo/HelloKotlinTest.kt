package ptv.dojo

import io.kotlintest.shouldBe
import io.kotlintest.specs.FeatureSpec


class HelloKotlinTest : FeatureSpec({
    feature("should greet correctly") {
        val objectUnderTest = HelloKotlin()
        val names = arrayOf("Kata", "World")

        names.forEach {
            scenario("should say 'Hello $it!'") {
                objectUnderTest.greet(it) shouldBe "Hello $it!"
            }
        }

        scenario("should say 'Hello Kotlin!'") {
            objectUnderTest.greet shouldBe "Hello Kotlin!"
        }
    }
})
