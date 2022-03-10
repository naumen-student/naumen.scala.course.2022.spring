package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{

        val trueStr = "правда"
        val falseStr = "ложь"
        case class A()

        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
            assert(Exercises.prettyBooleanFormatter1(A()) == "A()")
        }
        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(1) == "1")
            assert(Exercises.prettyBooleanFormatter2(A()) == "A()")
        }
        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
            assert(Exercises.prettyBooleanFormatter3(A()) == "A()")
        }

        val testSeq1 = Seq(1, 2, 3)
        val testSeq2 = Seq(3, 4, 3)
        val testEmptySeq = Seq.empty[Int]

        'test_max1 - {
            assert(Exercises.max1(testSeq1) == 3)
            assert(Exercises.max1(testSeq2) == 4)
            assert(Exercises.max1(testEmptySeq) == 0)
        }
        'test_max2 - {
            assert(Exercises.max2(testSeq1) == Seq(3))
            assert(Exercises.max2(testSeq2) == Seq(4))
            assert(Exercises.max2(testEmptySeq) == Seq())
        }
        'test_max3 - {
            assert(Exercises.max3(testSeq1).contains(3))
            assert(Exercises.max3(testSeq2).contains(4))
            assert(Exercises.max3(testEmptySeq).isEmpty)
        }

        val testX1 = 1
        val testY1 = 2
        val testX2 = 0
        val testY2 = 0
        val testX3 = 12
        val testY3 = 31
        'test_sum1 - {
            assert(Exercises.sum1(testX1, testY1) == 3)
            assert(Exercises.sum1(testX2, testY2) == 0)
            assert(Exercises.sum1(testX3, testY3) == 43)
        }
        'test_sum2 - {
            assert(Exercises.sum2(testX1, testY1) == 3)
            assert(Exercises.sum2(testX2, testY2) == 0)
            assert(Exercises.sum2(testX3, testY3) == 43)
        }
        'test_sum3 - {
            assert(Exercises.sum3(testX1, testY1) == 3)
            assert(Exercises.sum3(testX2, testY2) == 0)
            assert(Exercises.sum3(testX3, testY3) == 43)
        }
    }
}
