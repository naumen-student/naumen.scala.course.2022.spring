package homework_3

import utest._

object Test extends TestSuite {

    val tests: Tests = Tests {
        'prettyBooleanFormatter1_tests - {
            assert(Exercises.prettyBooleanFormatter1(true) == Exercises.trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == Exercises.falseStr)
            assert(Exercises.prettyBooleanFormatter1("1") == "1")
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
            assert(Exercises.prettyBooleanFormatter1(1.1) == "1.1")
        }

        'prettyBooleanFormatter2_tests - {
            assert(Exercises.prettyBooleanFormatter2(true) == Exercises.trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == Exercises.falseStr)
            assert(Exercises.prettyBooleanFormatter2("1") == "1")
            assert(Exercises.prettyBooleanFormatter2(1) == "1")
            assert(Exercises.prettyBooleanFormatter2(1.1) == "1.1")
        }

        'prettyBooleanFormatter2_tests - {
            assert(Exercises.prettyBooleanFormatter3(true) == Exercises.trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == Exercises.falseStr)
            assert(Exercises.prettyBooleanFormatter3("1") == "1")
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
            assert(Exercises.prettyBooleanFormatter3(1.1) == "1.1")
        }

        'sum1_tests - {
            assert(Exercises.sum1(1, 1) == 2)
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(-1, -5) == -6)
            assert(Exercises.sum1(-99, 1) == -98)
            assert(Exercises.sum1(99, -1) == 98)
        }

        'sum2_tests - {
            assert(Exercises.sum2(1, 1) == 2)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(-1, -5) == -6)
            assert(Exercises.sum2(-99, 1) == -98)
            assert(Exercises.sum2(99, -1) == 98)
        }

        'sum3_tests - {
            assert(Exercises.sum3(1, 1) == 2)
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(-1, -5) == -6)
            assert(Exercises.sum3(-99, 1) == -98)
            assert(Exercises.sum3(99, -1) == 98)
        }

        'max1_tests - {
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1(Seq(9)) == 9)
            assert(Exercises.max1(Seq(1, 5, 10)) == 10)
            assert(Exercises.max1(Seq(0, 0, 0)) == 0)
            assert(Exercises.max1(Seq(-1, -100, 1)) == 1)
        }

        'max2_tests - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(9)) == Seq(9))
            assert(Exercises.max2(Seq(1, 5, 10)) == Seq(10))
            assert(Exercises.max2(Seq(0, 0, 0)) == Seq(0))
            assert(Exercises.max2(Seq(-1, -100, 1)) == Seq(1))
        }

        'max3_tests - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq(1, 5, 10)).contains(10))
            assert(Exercises.max3(Seq(0, 0, 0)).contains(0))
            assert(Exercises.max3(Seq(-1, -100, 1)).contains(1))
        }
    }
}