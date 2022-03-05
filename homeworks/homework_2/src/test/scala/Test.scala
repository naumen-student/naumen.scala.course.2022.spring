import Exercises.Vector2D
import utest._

import scala.math.abs

object Test extends TestSuite{
    private val EPSILON: Double = 10e-5

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_divBy3Or7 - {
            assert(Exercises.sumOfDivBy3Or5(0, 0) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(3, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(0, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(0, 20) == 98)
        }

        'primeFactor_shouldBe - {
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(4) == Seq(2))
            assert(Exercises.primeFactor(16) == Seq(2))
            assert(Exercises.primeFactor(35) == Seq(5, 7))
            assert(Exercises.primeFactor(99) == Seq(3, 11))
            assert(Exercises.primeFactor(1) == Seq())
        }

        'test_sumScalars - {
            test_case_sumScalars(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), 4)
            test_case_sumScalars(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), 0)
            test_case_sumScalars(Vector2D(2, 1), Vector2D(1, 3), Vector2D(1, 1), Vector2D(1, 1), 7)
            test_case_sumScalars(Vector2D(1, 1), Vector2D(1, 1), Vector2D(2, 1), Vector2D(1, 3), 7)

        }
        'test_sumCosines - {
            test_case_sumCosines(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), 2)
            test_case_sumCosines(Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Double.NaN)
            test_case_sumCosines(Vector2D(2, 1), Vector2D(1, 3), Vector2D(1, 1), Vector2D(1, 1), 1.7071)
            test_case_sumCosines(Vector2D(1, 1), Vector2D(1, 1), Vector2D(2, 1), Vector2D(1, 3), 1.7071)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map("A" -> (1, 2))) == Seq("A"))
            assert(Exercises.sortByHeavyweight(Map("A" -> (1, 1), "B" -> (2, 2))) == Seq("A", "B"))
            assert(Exercises.sortByHeavyweight(Map()) == Seq())
            assert(Exercises.sortByHeavyweight(Map("A" -> (2, 1),"B" -> (1, 2))) == Seq("B", "A"))
        }
    }

    private def test_case_sumScalars(leftVec0: Vector2D, leftVec1: Vector2D,
                                     rightVec0: Vector2D, rightVec1: Vector2D, result: Double): Unit = {
        val actualResult = Exercises.sumScalars(leftVec0, leftVec1, rightVec0, rightVec1)
        assert(doublesEqual(actualResult, result))
    }

    private def test_case_sumCosines(leftVec0: Vector2D, leftVec1: Vector2D,
                                     rightVec0: Vector2D, rightVec1: Vector2D, result: Double): Unit = {
        val actualResult = Exercises.sumCosines(leftVec0, leftVec1, rightVec0, rightVec1)
        assert(actualResult.isNaN && result.isNaN || doublesEqual(actualResult, result))
    }

    private def doublesEqual(x: Double, y: Double) : Boolean
        = (x - y).abs < EPSILON
}
