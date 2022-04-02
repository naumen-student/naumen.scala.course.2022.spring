package homework_3

import utest._

object Test extends TestSuite {

  val tests = Tests {
    'test_example - {
      val trueStr = "правда"
      assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
    }
    'test_prettyBooleanFormatter1 - {
      val trueStr = "правда"
      val intStr = "1"
      val listStr = "List(1)"
      assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter1(1) == intStr)
      assert(Exercises.prettyBooleanFormatter1(List(1)) == listStr)
    }

    'test_prettyBooleanFormatter2 - {
      val trueStr = "правда"
      val intStr = "1"
      val listStr = "List(1)"
      assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter2(1) == intStr)
      assert(Exercises.prettyBooleanFormatter2(List(1)) == listStr)
    }

    'test_prettyBooleanFormatter3 - {
      val trueStr = "правда"
      val intStr = "1"
      val listStr = "List(1)"
      assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter3(1) == intStr)
      assert(Exercises.prettyBooleanFormatter3(List(1)) == listStr)
    }

    'test_max1 - {
      intercept[UnsupportedOperationException](Exercises.max1(Seq()))
      assert(Exercises.max1(Seq(1)) == 1)
      assert(Exercises.max1(Seq(1, 2)) == 2)
    }
    'test_max2 - {
      assert(Exercises.max2(Seq()) == Seq())
      assert(Exercises.max2(Seq(1)) == Seq(1))
      assert(Exercises.max2(Seq(1, 2)) == Seq(2))
    }
    'test_max3 - {
      assert(Exercises.max3(Seq()) == None)
      assert(Exercises.max3(Seq(1)) == Some(1))
      assert(Exercises.max3(Seq(1, 2)) == Some(2))
    }

    'test_sum1 - {
      assert(Exercises.sum1(1,2) == 3)
      assert(Exercises.sum1(2,-2) == 0)
      assert(Exercises.sum1(-3,-4) == -7)
    }

    'test_sum2 - {
      assert(Exercises.sum2(1,2) == 3)
      assert(Exercises.sum2(2,-2) == 0)
      assert(Exercises.sum2(-3,-4) == -7)
    }

    'test_sum1 - {
      assert(Exercises.sum3(1,2) == 3)
      assert(Exercises.sum3(2,-2) == 0)
      assert(Exercises.sum3(-3,-4) == -7)
    }

  }
}
