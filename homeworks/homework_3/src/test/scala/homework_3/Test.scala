package homework_3

import utest._

object Test extends TestSuite{
    val trueStr = "правда"
    val falseStr = "ложь"


    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }

        'prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("test") == "test")
            assert(Exercises.prettyBooleanFormatter1(100) == "100")
        }

        'prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2("test") == "test")
            assert(Exercises.prettyBooleanFormatter2(100) == "100")
        }

        'prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3("test") == "test")
            assert(Exercises.prettyBooleanFormatter3(100) == "100")
        }

        'max1 - {
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq(4, 5, 5)) == 5)
        }

        'max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3)
            assert(Exercises.max2(Seq(4, 5, 5)) == Seq(5)
        }

        'max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1, 2, 3)).contains(3))
            assert(Exercises.max3(Seq(4, 5, 5)).contains(5))
        }

        'sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-1, 1) == 0)
            assert(Exercises.sum1(-3, -4) == -7)
        }

        'sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(-1, 1) == 0)
            assert(Exercises.sum2(-3, -4) == -7)
        }

        'sum3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(-1, 1) == 0)
            assert(Exercises.sum3(-3, -4) == -7)
        }
    }
}
