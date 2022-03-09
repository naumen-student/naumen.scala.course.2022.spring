package homework_3

import utest._

object Test extends TestSuite {

  val tests = Tests {
    val trueStr = "правда"
    val falseStr = "ложь"

    'test_prettyBooleanFormatter1 - {
      assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter1(7) == "7")
      assert(Exercises.prettyBooleanFormatter1("test") == "test")
    }
    'test_prettyBooleanFormatter2 - {
      assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter2(7) == "7")
      assert(Exercises.prettyBooleanFormatter2("test") == "test")
    }
    'test_prettyBooleanFormatter3 - {
      assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter3(7) == "7")
      assert(Exercises.prettyBooleanFormatter3("test") == "test")
    }
    'test_max1 - {
      assert(Exercises.max1(Seq(1, 2, 3)) == 3)
      assert(Exercises.max1(Seq(7)) == 7)
      intercept[UnsupportedOperationException] {
        Exercises.max1(Seq())
      }
    }
    'test_max2 - {
      assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
      assert(Exercises.max2(Seq(7)) == Seq(7))
      assert(Exercises.max2(Seq()) == Nil)
    }
    'test_max3 - {
      assert(Exercises.max3(Seq(1, 2, 3)).get == 3)
      assert(Exercises.max3(Seq(7)).get == 7)
      assert(Exercises.max3(Seq()).isEmpty)
    }
    'test_sum1 - {
      assert(Exercises.sum1(2, 3) == 5)
    }
    'test_sum2 - {
      assert(Exercises.sum2(2, 3) == 5)
    }
    'test_sum3 - {
      assert(Exercises.sum3(2, 3) == 5)
    }
  }
}
