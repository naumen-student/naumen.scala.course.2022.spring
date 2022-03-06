package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{

        val trueStr = "правда"
        val falseStr = "ложь"

        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
            assert(Exercises.prettyBooleanFormatter1('a') == "a")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(5.2) == "5.2")
            assert(Exercises.prettyBooleanFormatter2(List(1, 2, 3)) == "List(1, 2, 3)")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(Set("a", "a")) == "Set(a)")
            assert(Exercises.prettyBooleanFormatter3(Tuple2(1, 2)) == "(1,2)")
        }

        'test_max1 - {
            val e = intercept[UnsupportedOperationException] {Exercises.max1(Seq())}
            println(e)
            assert(e.toString == "java.lang.UnsupportedOperationException: empty.max")
            assert(Exercises.max1(Seq(1, 2)) == 2)
            assert(Exercises.max1(Seq(1, 3, 3)) == 3)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1, 2)) == Seq(2))
            assert(Exercises.max2(Seq(1, 3, 3)) == Seq(3))
        }

        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1, 2)).contains(2))
            assert(Exercises.max3(Seq(1, 3, 3)).contains(3))
        }

        'test_sum1 - {
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(1, 5) == 6)
            assert(Exercises.sum1(-2, 4) == 2)
        }

        'test_sum2 - {
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(1, 5) == 6)
            assert(Exercises.sum2(-2, 4) == 2)
        }

        'test_sum3 - {
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(1, 5) == 6)
            assert(Exercises.sum3(-2, 4) == 2)
        }
    }
}
