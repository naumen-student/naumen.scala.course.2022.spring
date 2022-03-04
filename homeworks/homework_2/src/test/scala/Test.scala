import Exercises.{Vector2D, sortByHeavyweight}
import utest._

object Test extends TestSuite {

    val tests: Tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5_shouldBe - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 1) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 7) == 3 + 5 + 6)
            assert(Exercises.sumOfDivBy3Or5(1, 14) == 3 + 5 + 6 + 9 + 10 + 12)
        }

        'primeFactor_shouldBe - {
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(4) == Seq(2))
            assert(Exercises.primeFactor(16) == Seq(2))
            assert(Exercises.primeFactor(35) == Seq(5, 7))
            assert(Exercises.primeFactor(99) == Seq(3, 11))
            assert(Exercises.primeFactor(1) == Seq())
        }

        'sumScalars_shouldBe - {
            val (v1_from, v1_to, v2_from, v2_to) = (
              Vector2D(1, 1),
              Vector2D(2, 2),
              Vector2D(3, 3),
              Vector2D(5, 5))
            assert(Exercises.sumScalars(v1_from, v1_to, v2_from, v2_to) == Exercises.scalar(v1_from, v1_to) + Exercises.scalar(v2_from, v2_to))
            assert(Exercises.sumScalars(v1_from, v2_to, v1_from, v2_to) == Exercises.scalar(v1_from, v2_to) + Exercises.scalar(v1_from, v2_to));
        }

        'sumCosines_shouldBe - {
            val (v1_from, v1_to, v2_from, v2_to) = (
              Vector2D(1, 1),
              Vector2D(2, 2),
              Vector2D(3, 3),
              Vector2D(5, 5))
            assert(Exercises.sumCosines(v1_from, v1_to, v2_from, v2_to) == (Exercises.cosBetween(v1_from, v1_to) + Exercises.cosBetween(v2_from, v2_to)))
            assert(Exercises.sumCosines(v1_from, v2_to, v1_from, v2_to) == Exercises.cosBetween(v1_from, v2_to) + Exercises.cosBetween(v1_from, v2_to));
        }


        'sortByHeavyweight - {
            assert(sortByHeavyweight(Map(
                "Heavy ball" -> (20, 100),
                "Light ball" -> (1, 1),
            )) == Seq("Light ball", "Heavy ball"))

            assert(sortByHeavyweight(Map(
                "Light" -> (1, 3d),
                "Heavy" -> (10, 2d),
                "Normal" -> (3, 2d),
                "SuperHeavy" -> (10, 4)
            )) == Seq("Light", "Normal", "Heavy", "SuperHeavy"))

            assert(sortByHeavyweight(Map()) == Seq())
            assert(sortByHeavyweight(Map("ball" -> (1, 1))) == Seq("ball"))
        }
    }
}