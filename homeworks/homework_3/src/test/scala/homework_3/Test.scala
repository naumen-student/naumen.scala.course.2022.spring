package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'formatter1_test - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
        }
        'formatter2_test - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(1) == "1")
        }
        'formatter3_test - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
        }
        'max1_test - {
            assert(Exercises.max1(Seq()) == -1)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(1,2,3)) == 3)
        }
        'max2_test - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(1,2,3)) == Seq(3))
        }
        'max3_test - {
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq(1,2,3))contains(3))
        }
        'sum1_test - {
            assert(Exercises.sum1(1,1) == 2)
            assert(Exercises.sum1(0,0) == 0)
            assert(Exercises.sum1(500,1000) == 1500)
        }
        'sum2_test - {
            assert(Exercises.sum2(1,1) == 2)
            assert(Exercises.sum2(0,0) == 0)
            assert(Exercises.sum2(500,1000) == 1500)
        }
        'sum3_test - {
            assert(Exercises.sum3(1,1) == 2)
            assert(Exercises.sum3(0,0) == 0)
            assert(Exercises.sum3(500,1000) == 1500)
        }
    }
}
