package homework_3

import utest._

object Test extends TestSuite {

  val trueStr = "правда"
  val falseStr = "ложь"

  val tests = Tests {
    'prettyBooleanFormatter1_tests - {
      assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter1("123") == "123")
      assert(Exercises.prettyBooleanFormatter1(123) == "123")
    }

    'prettyBooleanFormatter2_tests - {
      assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter2("123") == "123")
      assert(Exercises.prettyBooleanFormatter2(123) == "123")
    }

    'prettyBooleanFormatter2_tests - {
      assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter3("123") == "123")
      assert(Exercises.prettyBooleanFormatter3(123) == "123")
    }

    'max1_tests - {
      assert(Exercises.max1(Seq()) == Int.MinValue)
      assert(Exercises.max1(Seq(1)) == 1)
      assert(Exercises.max1(Seq(1, 3, 3)) == 3)
    }

    'max2_tests - {
      assert(Exercises.max2(Seq()) == Seq())
      assert(Exercises.max2(Seq(1)) == Seq(1))
      assert(Exercises.max2(Seq(1, 3, 3)) == Seq(3))
    }

    'max3_tests - {
      assert(Exercises.max3(Seq()).isEmpty)
      assert(Exercises.max3(Seq(1)).contains(1))
      assert(Exercises.max3(Seq(1, 3, 3)).contains(3))
    }

    'sum1_tests - {
      assert(Exercises.sum1(1, 2) == 3)
      assert(Exercises.sum1(0, 0) == 0)
      assert(Exercises.sum1(-1, -5) == -6)
    }

    'sum2_tests - {
      assert(Exercises.sum2(1, 2) == 3)
      assert(Exercises.sum2(0, 0) == 0)
      assert(Exercises.sum2(-1, -5) == -6)
    }

    'sum3_tests - {
      assert(Exercises.sum3(1, 2) == 3)
      assert(Exercises.sum3(0, 0) == 0)
      assert(Exercises.sum3(-1, -5) == -6)
    }
  }
}
