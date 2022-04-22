package homework_3

import utest._

object Test extends TestSuite{

    val trueStr = "правда"
    val falseStr = "ложь"

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("str") == "str".toString)
            assert(Exercises.prettyBooleanFormatter1(1) == 1.toString)
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2("str") == "str".toString)
            assert(Exercises.prettyBooleanFormatter2(1) == 1.toString)

        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3("str") == "str".toString)
            assert(Exercises.prettyBooleanFormatter3(1) == 1.toString)
        }

        'test_max1 - {
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq(1, -2)) == 1)
            assert(Exercises.max1(Seq()) == 0)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
            assert(Exercises.max2(Seq(1, -2)) == Seq(1))
            assert(Exercises.max2(Seq()) == Seq())
        }

        'test_max3 - {
            assert(Exercises.max3(Seq(1, 2, 3)) == Option(3))
            assert(Exercises.max3(Seq(1, -2)) == Option(1))
            assert(Exercises.max3(Seq()).isEmpty)
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
        }

        'test_sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
        }

        'test_sum3 - {
            assert(Exercises.sum3(1, 2) == 3)
        }

    }
}
