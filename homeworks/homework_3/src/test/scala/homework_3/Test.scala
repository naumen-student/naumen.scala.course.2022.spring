package homework_3

import utest._

object Test extends TestSuite{
    private val seq = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
    private val oneElementSeq = Seq(1)
    private val emptySeq = Seq()

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assertPrettyBoolean(Exercises.prettyBooleanFormatter1)
        }

        'test_prettyBooleanFormatter2 - {
            assertPrettyBoolean(Exercises.prettyBooleanFormatter2)
        }

        'test_prettyBooleanFormatter3 - {
            assertPrettyBoolean(Exercises.prettyBooleanFormatter3)
        }

        'test_max1 - {
            assert(Exercises.max1(seq) == 9)
            assert(Exercises.max1(oneElementSeq) == 1)
            intercept[UnsupportedOperationException] { Exercises.max1(emptySeq) }
        }

        'test_max2 - {
            assert(Exercises.max2(seq) == Seq[Int](9))
            assert(Exercises.max2(oneElementSeq) == Seq[Int](1))
            assert(Exercises.max2(emptySeq) == Seq[Int]())
        }

        'test_max3 - {
            assert(Exercises.max3(seq).get == 9)
            assert(Exercises.max3(oneElementSeq).get == 1)
            assert(Exercises.max3(emptySeq).isEmpty)
        }

        'test_sum1 - {
            assertSum(Exercises.sum1)
        }

        'test_sum2 - {
            assertSum(Exercises.sum2)
        }

        'test_sum3 - {
            assertSum(Exercises.sum3)
        }
    }

    private def assertPrettyBoolean(formatter: Any => String): Unit = {
        assert(formatter(true) == "правда")
        assert(formatter(false) == "ложь")
        assert(formatter(12) == "12")
        assert(formatter("string") == "string")
        assert(formatter(None) == "None")
    }

    private def assertSum(sumFunc: (Int, Int) => Int): Unit = {
        assert(sumFunc(1, 2) == 3)
        assert(sumFunc(-10, 10) == 0)
        assert(sumFunc(0, 0) == 0)
        assert(sumFunc(Int.MaxValue, 1) == Int.MinValue)
    }
}
