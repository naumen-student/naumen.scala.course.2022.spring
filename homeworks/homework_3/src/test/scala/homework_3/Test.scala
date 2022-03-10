package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            val trueStr = "правда"
            val falseStr = "ложь"
            val emptyString = ""
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)

            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)

            assert(Exercises.prettyBooleanFormatter1(0) == emptyString)
            assert(Exercises.prettyBooleanFormatter2(0) == emptyString)
            assert(Exercises.prettyBooleanFormatter3(0) == emptyString)
        }
        'test_max - {
            val seq = Seq(1, 4, 5, 2, 0, 10)
            val emptySeq = Seq()

            assert(Exercises.max1(seq) == 10)
            assert(Exercises.max2(seq) == Seq(10))
            assert(Exercises.max3(seq) == Some(10))

            assert(Exercises.max1(emptySeq) == -1)
            assert(Exercises.max2(emptySeq) == Seq())
            assert(Exercises.max3(emptySeq) == None)
        }
        'test_sum - {
            assert(Exercises.sum1(2, 5) == 7)
            assert(Exercises.sum2(2, 5) == 7)
            assert(Exercises.sum3(2, 5) == 7)

            assert(Exercises.sum1(-2, 5) == 3)
            assert(Exercises.sum2(-2, 5) == 3)
            assert(Exercises.sum3(-2, 5) == 3)

            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum3(0, 0) == 0)
        }
    }
}
