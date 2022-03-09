package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(2.5) == "2.5")
        }
        'test_prettyBooleanFormatter2 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(2.5) == "2.5")
        }
        'test_prettyBooleanFormatter3 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(2.5) == "2.5")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq(1, 8, 99, 2022, -512, 14)) == 2022)
            assert(Exercises.max1(Seq(0, 0, 0, 0)) == 0 )
        }
        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1, 8, 99, 2022, -512, 14)) == Seq(2022))
            assert(Exercises.max2(Seq(0, 0, 0, 0)) == Seq(0))
        }
        'test_max3 - {
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(1, 8, 99, 2022, -512, 14)) == Some(2022))
            assert(Exercises.max3(Seq(0, 0, 0, 0)) == Some(0))
        }

        'test_sum1 - {
            assert(Exercises.sum1(2022, -2020) == 2)
            assert(Exercises.sum1(333, 4444) == 4777)
            assert(Exercises.sum1(100001, 0) == 100001)
        }
        'test_sum2 - {
            assert(Exercises.sum2(2022, -2020) == 2)
            assert(Exercises.sum2(333, 4444) == 4777 )
            assert(Exercises.sum2(100001, 0) == 100001)
        }
        'test_sum3 - {
            assert(Exercises.sum3(2022, -2020) == 2 )
            assert(Exercises.sum3(333, 4444) == 4777)
            assert(Exercises.sum3(100001, 0) == 100001)
        }
    }
}
