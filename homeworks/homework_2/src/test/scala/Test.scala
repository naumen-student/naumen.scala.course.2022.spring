import Exercises.Vector2D
import utest._

object Test extends TestSuite {
    private val EPSILON: Double = 10e-5

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(3, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(4, 5) == 5)
            assert(Exercises.sumOfDivBy3Or5(3, 5) == Seq(3, 5).sum)
            assert(Exercises.sumOfDivBy3Or5(0, 10) == Seq(3, 5, 6, 9, 10).sum)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(10) == Seq(2, 5))
            assert(Exercises.primeFactor(27) == Seq(3))
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
        }

        'test_sumScalars - {
            val sumScalarsTestCaseData = List(
                (Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), 4.0),
                (Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), Vector2D(0, 0), 0.0),
                (Vector2D(5, -2), Vector2D(2, 3), Vector2D(1, 1), Vector2D(2, 3), 9.0),
            )
            assertTestCaseData(sumScalarsTestCaseData, Exercises.sumScalars)
        }

        'test_sumCosines - {
            val sumCosinesTestCaseData = List(
                (Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), 2.0),
                (Vector2D(5, -2), Vector2D(2, 3), Vector2D(1, 1), Vector2D(2, 3), 1.1865),
            )
            assertTestCaseData(sumCosinesTestCaseData, Exercises.sumCosines)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map()) == Seq())
            assert(Exercises.sortByHeavyweight(Map("q" -> (1, 2))) == Seq("q"))
            assert(Exercises.sortByHeavyweight(Map("q" -> (1, 1), "w" -> (2, 2))) == Seq("q", "w"))
            assert(Exercises.sortByHeavyweight(Map("q" -> (2, 1), "w" -> (1, 2), "e" -> (1, 1))) == Seq("e", "w", "q"))
        }
    }

    private def assertTestCaseData(testCaseData: List[(Vector2D, Vector2D, Vector2D, Vector2D, Double)],
                                   testedFunc: (Vector2D, Vector2D, Vector2D, Vector2D) => Double): Unit = {
        for ((leftVec0, leftVec1, rightVec0, rightVec1, expected) <- testCaseData) {
            val actual = testedFunc(leftVec0, leftVec1, rightVec0, rightVec1)
            assert(doubleEquals(actual,  expected))
        }
    }

    private def doubleEquals(x: Double, y: Double): Boolean = (x - y).abs < EPSILON
}
