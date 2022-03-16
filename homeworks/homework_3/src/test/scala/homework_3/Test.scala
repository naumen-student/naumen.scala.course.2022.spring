package homework_3

import utest._

import scala.util.Try
import Exercises.OptionSomeOps

object Test extends TestSuite {
    val seq: Seq[Int] = Range(0, 11)
    val pairSeq: Seq[Int] = Range(1, 3)
    val singleSeq: Seq[Int] = Seq(1)
    val emptySeq: Seq[Int] = Seq()

    def assertPrettyBooleanFormatter(formatter: Any => String) = {
        assert(formatter(true) == "правда")
        assert(formatter(false) == "ложь")
        assert(formatter(12) == 12.toString)
        assert(formatter("true") == "true")
        assert(formatter(None) == None.toString)
        assert(formatter(List(0, 1)) == List(0, 1).toString)
        assert(formatter(Some(true)) == Some(true).toString)
    }

    def assertSum(sum: (Int, Int) => Int) = {
        assert(sum(1, 2) == 3)
        assert(sum(1, -1) == 0)
        assert(sum(0, 0) == 0)
        assert(sum(3, 5) == 8)
        assert(sum(-20, -1) == -21)
    }

    val tests = Tests { //Ужасная тест либа
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
            assert(Exercises.max1(seq) == 10)
            assert(Exercises.max1(pairSeq) == 2)
            assert(Exercises.max1(singleSeq) == 1)
            assert(Try(Exercises.max1(emptySeq)).isFailure)
        }

        'test_max2 - {
            assert(Exercises.max2(seq) == Seq(10))
            assert(Exercises.max2(pairSeq) == Seq(2))
            assert(Exercises.max2(singleSeq) == Seq(1))
            assert(Exercises.max2(emptySeq) == emptySeq)
        }

        'test_max3 - {
            assert(Exercises.max3(seq) == 10.some)
            assert(Exercises.max3(pairSeq) == 2.some)
            assert(Exercises.max3(singleSeq) == 1.some)
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
}
