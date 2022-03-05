import Exercises.{Vector2D, sumCosines, sumScalars}
import utest._
object Test extends TestSuite {

    val tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(
                Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45,
                    48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99)
            )
        }

        'test_divBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(16, 17) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 3) == Seq(3).sum)
            assert(Exercises.sumOfDivBy3Or5(4, 5) == Seq(5).sum)
            assert(Exercises.sumOfDivBy3Or5(44, 46) == Seq(45).sum)
            assert(Exercises.sumOfDivBy3Or5(1, 5) == Seq(3, 5).sum)
            assert(Exercises.sumOfDivBy3Or5(9, 16) == Seq(9, 10, 12, 15).sum)
        }
        'test_divBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(16, 17) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 3) == Seq(3).sum)
            assert(Exercises.sumOfDivBy3Or5(4, 5) == Seq(5).sum)
            assert(Exercises.sumOfDivBy3Or5(44, 46) == Seq(45).sum)
            assert(Exercises.sumOfDivBy3Or5(1, 5) == Seq(3, 5).sum)
            assert(Exercises.sumOfDivBy3Or5(9, 16) == Seq(9, 10, 12, 15).sum)
        }

        'test_primeFactor - {
            assert(List(4, 8, 32, 128, 1024, 512).map(Exercises.primeFactor).forall(_ == Seq(2)))
            assert(Exercises.primeFactor(6) == Seq(2, 3))
            assert(Exercises.primeFactor(210) == Seq(2, 3, 5, 7))
            assert(Exercises.primeFactor(7) == Seq())
        }

        'test_sumScalars - {
            assert(doubleEquals(sumScalars(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1)), 4))
            assert(doubleEquals(sumScalars(Vector2D(0, 1), Vector2D(1, 0), Vector2D(0, 0), Vector2D(1, 1)), 0))
            assert(doubleEquals(sumScalars(Vector2D(5, -2), Vector2D(2, 3), Vector2D(1, 1), Vector2D(2, 3)), 9))
        }
        'test_sumCosines - {
            assert(doubleEquals(sumCosines(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1)), 2))
            assert(doubleEquals(sumCosines(Vector2D(-1, -1), Vector2D(1, 1), Vector2D(-1, 0), Vector2D(1, 0)), -2))
            assert(doubleEquals(sumCosines(Vector2D(1, 1), Vector2D(1, -1), Vector2D(-1, 1), Vector2D(1, 1)), 0))
            assert(
                doubleEquals(
                    sumCosines(Vector2D(10, 0), Vector2D(9, 9), Vector2D(1, -1), Vector2D(0, -1)),
                    math.sqrt(2)
                )
            )
            assert(
                doubleEquals(
                    sumCosines(Vector2D(1, 0), Vector2D(1, 1), Vector2D(1, 0), Vector2D(3, 1)),
                    math.sqrt(2) / 2 + 0.9486832
                )
            )
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map()) == Seq())
            assert(Exercises.sortByHeavyweight(Map("a" -> (1, 1))) == Seq("a"))
            assert(Exercises.sortByHeavyweight(Map("a" -> (1, 1), "b" -> (2, 2))) == Seq("a", "b"))
            assert(Exercises.sortByHeavyweight(Map("a" -> (2, 1), "b" -> (1, 2), "c" -> (1, 1))) == Seq("c", "b", "a"))
        }
    }
    private def doubleEquals(a: Double, b: Double) = math.abs(a - b) < 10e-6
}
