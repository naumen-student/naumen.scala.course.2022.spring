import Exercises.{Vector2D, balls}
import utest._

object Test extends TestSuite {

    val tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_primFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(8) == Seq(2))
            assert(Exercises.primeFactor(102) == Seq(2, 3, 17))
        }
        'test_sumByFunc - {
            assert(Exercises.sumScalars(Vector2D(0, 1), Vector2D(0, 1), Vector2D(0, 1), Vector2D(0, 1)) == 2)
            assert(Exercises.sumScalars(Vector2D(1, 2), Vector2D(1, 2), Vector2D(2, 2), Vector2D(2, 2)) == 13)
            assert(Exercises.sumCosines(Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1), Vector2D(1, 1)) ==
              4 / java.lang.Math.sqrt(2) / java.lang.Math.sqrt(2))
            assert(Exercises.sumCosines(Vector2D(2, 1), Vector2D(2, 1), Vector2D(1, 1), Vector2D(1, 1)) ==
              5 / java.lang.Math.sqrt(5) / java.lang.Math.sqrt(5) + 2 / java.lang.Math.sqrt(2) / java.lang.Math.sqrt(2))
        }
        'test_sortByHeavyweight - {
            val testBalls1 = Map("Tin" -> (1, 7.29), "Gold" -> (2, 19.32), "Platinum" -> (1, 21.45))
            assert(Exercises.sortByHeavyweight(testBalls1) == Seq("Tin", "Platinum", "Gold"))
            val testBalls2 = Map("Lithium" -> (12, 0.534), "Graphite" -> (12, 2.1), "Lead" -> (2, 11.336))
            assert(Exercises.sortByHeavyweight(testBalls2) == Seq("Lead", "Lithium", "Graphite"))
            val testBalls3 = Map("Iron" -> (3, 7.874), "Copper" -> (3, 8.96), "Chrome" -> (3, 7.18))
            assert(Exercises.sortByHeavyweight(testBalls3) == Seq("Chrome", "Iron", "Copper"))
        }
    }
}
