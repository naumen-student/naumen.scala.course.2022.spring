package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(4) == "4")
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2("3qwe") == "3qwe")
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(2.2) == "2.2")
        }
        'test_max - {
            intercept[UnsupportedOperationException](Exercises.max1(Seq()))
            assert(Exercises.max2(Seq()).isEmpty)
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max1(Seq(6)) == 6)
            assert(Exercises.max2(Seq(6)) == Seq(6))
            assert(Exercises.max3(Seq(6)) == Some(6))
            assert(Exercises.max1(Seq(5, 10)) == 10)
            assert(Exercises.max2(Seq(5, 10)) == Seq(10))
            assert(Exercises.max3(Seq(5, 10)) == Some(10))
        }
        'test_sum - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum1(-4, 2) == -2)
            assert(Exercises.sum2(-4, 2) == -2)
            assert(Exercises.sum3(-4, 2) == -2)
            assert(Exercises.sum1(Int.MaxValue, 0) == Int.MaxValue)
            assert(Exercises.sum2(Int.MaxValue, 0) == Int.MaxValue)
            assert(Exercises.sum3(Int.MaxValue, 0) == Int.MaxValue)
        }
    }
}
