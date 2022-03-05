package homework_3

import utest._

object Test extends TestSuite{
    private final val trueString = "правда"
    private final val falseString = "ложь"

    private final val seqWithValues = Seq(1, 5, 3, 5, 6, 10)
    private final val emptySeq = Seq()

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assertPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1)
        }

        'test_prettyBooleanFormatter2 - {
            assertPrettyBooleanFormatter(Exercises.prettyBooleanFormatter2)
        }

        'test_prettyBooleanFormatter3 - {
            assertPrettyBooleanFormatter(Exercises.prettyBooleanFormatter3)
        }

        'test_max1 - {
            assert(Exercises.max1(seqWithValues) == 10)
            intercept[UnsupportedOperationException] { Exercises.max1(Seq())}
        }

        'test_max2 - {
            assert(Exercises.max2(seqWithValues) == Seq[Int](10))
            assert(Exercises.max2(emptySeq) == Seq[Int]())
        }

        'test_max3 - {
            assert(Exercises.max3(seqWithValues).get == 10)
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

    private def assertPrettyBooleanFormatter(formatter: Any => String) : Unit = {
        assert(formatter(None) == "None")
        assert(formatter(42) == "42")
        assert(formatter("hello") == "hello")
        assert(formatter(true) == trueString)
        assert(formatter(false) == falseString)
    }

    private def assertSum(func: (Int, Int) => Int) : Unit = {
        assert(func(1, 2) == 3)
        assert(func(-1, 1) == 0)
        assert(func(-1, -1) == -2)
        assert(func(Int.MaxValue, Int.MinValue) == -1)
    }
}
