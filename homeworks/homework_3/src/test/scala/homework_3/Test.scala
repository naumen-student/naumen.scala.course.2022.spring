package homework_3

import utest._

object Test extends TestSuite{

    val trueStr = "правда"
    val falseStr = "ложь"

    val tests = Tests{
        'test_example - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }

        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("abc") == "abc")
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2("abc") == "abc")
            assert(Exercises.prettyBooleanFormatter2(123) == "123")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3("abc") == "abc")
            assert(Exercises.prettyBooleanFormatter3(123) == "123")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq(10)) == 10)
            assert(Exercises.max1(Seq(10,20)) == 20)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max1(Seq(10)) == 10)
            assert(Exercises.max1(Seq(10,20)) == 20)
        }

        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(10)).contains(10))
            assert(Exercises.max3(Seq(10,20)).contains(20))
        }

        'test_sum1 - {
            assert(Exercises.sum1(0,0) == 0)
            assert(Exercises.sum1(1,2) == 3)
            assert(Exercises.sum1(-1,3) == 2)
        }

        'test_sum2 - {
            assert(Exercises.sum2(0,0) == 0)
            assert(Exercises.sum2(1,2) == 3)
            assert(Exercises.sum2(-1,3) == 2)
        }

        'test_sum3 - {
            assert(Exercises.sum3(0,0) == 0)
            assert(Exercises.sum3(1,2) == 3)
            assert(Exercises.sum3(-1,3) == 2)
        }
    }
}
