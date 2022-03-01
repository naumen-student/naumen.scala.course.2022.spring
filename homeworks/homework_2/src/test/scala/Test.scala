import Exercises.{Vector2D, sortByHeavyweight}
import utest._

import scala.util.Random

object Test extends TestSuite {

    val tests: Tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5_shouldBe - {
            assert(Exercises.sumOfDivBy3Or5(1, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 5) == 3 + 5)
            assert(Exercises.sumOfDivBy3Or5(1, 20) == 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 + 20)
        }

        'primeFactor_shouldBe - {
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(5) == Seq(5))
            assert(Exercises.primeFactor(15) == Seq(3, 5))
            assert(Exercises.primeFactor(24) == Seq(2, 3))
        }

        'sumScalars_shouldBe - {
            val rnd = new Random()
            val (a, b, c, d) = (
              Vector2D(rnd.nextInt(), rnd.nextInt()),
              Vector2D(rnd.nextInt(), rnd.nextInt()),
              Vector2D(rnd.nextInt(), rnd.nextInt()),
              Vector2D(rnd.nextInt(), rnd.nextInt()))
            assert(Exercises.sumScalars(a, b, c, d) == Exercises.scalar(a, b) + Exercises.scalar(c, d))
        }

        'sumCosines_shouldBe - {
            val rnd = new Random()
            val (a, b, c, d) = (
              Vector2D(rnd.nextInt(), rnd.nextInt()),
              Vector2D(rnd.nextInt(), rnd.nextInt()),
              Vector2D(rnd.nextInt(), rnd.nextInt()),
              Vector2D(rnd.nextInt(), rnd.nextInt()))
            assert(Math.abs(Exercises.sumCosines(a, b, c, d) - (Exercises.cosBetween(a, b) + Exercises.cosBetween(c, d))) < 1e-6)
        }

        'sortByHeavyweight - {
           assert(sortByHeavyweight(Map(
               "A" -> (2, 1d),
               "B" -> (1, 1d),
           )) == Seq("B", "A"))

            assert(sortByHeavyweight(Map(
                "A" -> (1, 1d),
                "B" -> (1, 2d),
            )) == Seq("A", "B"))

            assert(sortByHeavyweight(Map(
                "A" -> (1, 3d),
                "B" -> (1, 2d),
                "C" -> (3, 2d),
            )) == Seq("B", "A", "C"))
        }
    }
}
