import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(5, 6) == 11)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(102) == Seq(2, 3, 17))
            assert(Exercises.primeFactor(20) == Seq(2, 5))
            assert(Exercises.primeFactor(39) == Seq(3, 13))
            assert(Exercises.primeFactor(24) == Seq(2, 3))
            assert(Exercises.primeFactor(7) == Seq(7))
            assert(Exercises.primeFactor(1) == Seq.empty)
        }
        'test_sumScalars - {
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 2), Exercises.Vector2D(3, 4), Exercises.Vector2D(5, 6), Exercises.Vector2D(7, 8)) == 94)
        }
        'test_sumCosines - {
            assert(Math.abs(Exercises.sumCosines(Exercises.Vector2D(1, 2), Exercises.Vector2D(3, 4), Exercises.Vector2D(5, 6), Exercises.Vector2D(7, 8)) - 1.98357971857) < 1e-10)
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
