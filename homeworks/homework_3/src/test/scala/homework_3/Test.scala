package homework_3

import utest._

object Test extends TestSuite{
    val prettyBooleanFormattersTestCases = Seq(
        (true, "правда"),
        (false, "ложь"),
        ("true", "true"),
        ("false", "false"),
        (42, "42"),
        (None, "None"),
        (List(), "List()"),
        ("STRING", "STRING"),
    )

    val maxTestCases = Seq(
        (Seq(3, 2, 5, 10, 12, 120), 120),
        (Seq(1, 1, 2, 2, 2, 3), 3),
        (Seq(2, 3), 3),
        (Seq(-100, 99), 99),
        (Seq(0, 0, 0), 0),
    )

    val sumTestCases = Seq(
        ((1, 1), 2),
        ((1, 0), 1),
        ((0, 0), 0),
        ((-1, 1), 0),
    )

    private def assertPrettyBooleanFormatter(formatter: Any => String): Unit = {
        for ((value, expected) <- prettyBooleanFormattersTestCases)
            assert(formatter(value) == expected)
    }

    val tests = Tests {
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
            for ((param, expected) <- maxTestCases)
                assert(Exercises.max1(param) == expected)
        }

        'test_max2 - {
            for ((param, expected) <- maxTestCases)
                assert(Exercises.max2(param) == Seq(expected))
        }

        'test_max3 - {
            for ((param, expected) <- maxTestCases)
                assert(Exercises.max3(param) == Option(expected))
        }

        'test_max_with_empty_sequence - {
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max3(Seq()).isEmpty)
        }

        'test_sum1 - {
            for ((pair, expected) <- sumTestCases)
                assert(Exercises.sum1(pair._1, pair._2) == expected)
        }

        'test_sum1 - {
            for ((pair, expected) <- sumTestCases)
                assert(Exercises.sum2(pair._1, pair._2) == expected)
        }

        'test_sum1 - {
            for ((pair, expected) <- sumTestCases)
                assert(Exercises.sum3(pair._1, pair._2) == expected)
        }
    }
}
