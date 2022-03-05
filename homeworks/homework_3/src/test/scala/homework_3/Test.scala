package homework_3

import utest._

object Test extends TestSuite{

    private final val maxIntTestCases : List[(Seq[Int], Int)] = List(
        (List(1, 2, 3, 4), 4),
        (List(4, 3, 1, 2), 4),
        (List(1, 1, 1, 1), 1),
        (List.range(1, 101), 100),
    )
    private final val sumTestCases : List[((Int, Int), Int)] = List(
        ((1, 2), 3),
        ((3, 0), 3),
        ((-10, 23), 13),
        ((5, -23), -18),
        ((-5, -5), -10),
    )
    private final def assertPrettyBooleanFormatter(formatter: Any => String) : Unit = {
        assert(formatter(true) == "правда")
        assert(formatter(false) == "ложь")
        assert(formatter(1) == "1")
        assert(formatter("string") == "string")
    }



    private final def assertMaxInt[T](max: Seq[Int] => T, map: Int => T) : Unit = maxIntTestCases.foreach {
        case (numbers, expected) =>
            assert(max(numbers) == map(expected))
    }

    private final def assertSum(sumFunction: (Int, Int) => Int) : Unit = sumTestCases.foreach {
        case (xy, expected) =>
            xy match {
                case (x, y) => assert(sumFunction(x, y) == expected)
            }
    }

    val tests: Tests = Tests{
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
            assertMaxInt(Exercises.max1, x => x)
            var exceptionFlag = false
            try {
                Exercises.max1(List.empty)
            } catch {
                case _: UnsupportedOperationException => exceptionFlag = true
            }
            assert(exceptionFlag)
        }

        'test_max2 - {
            assertMaxInt(Exercises.max2, List(_))
            assert(Exercises.max2(List.empty) == List.empty)
        }

        'test_max3 - {
            assertMaxInt(Exercises.max3, Some(_))
            assert(Exercises.max3(List.empty).isEmpty)
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


}
