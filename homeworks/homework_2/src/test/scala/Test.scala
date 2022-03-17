import utest._

object Test extends TestSuite {

  val tests = Tests {
    'test_divBy3Or7 - {
      assert(Exercises.divBy3Or7(1, 3) == Seq(3))
      assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }

    'test_sumOfDivBy3Or5 - {
      assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
      assert(Exercises.sumOfDivBy3Or5(10, 11) == 10)
      assert(Exercises.sumOfDivBy3Or5(0, 25) == 168)
    }

    'primeFactor - {
      assert(Exercises.primeFactor(78) == Seq(2, 3, 13))
      assert(Exercises.primeFactor(54) == Seq(2, 3))
      assert(Exercises.primeFactor(135) == Seq(3, 5))
      assert(Exercises.primeFactor(380) == Seq(2, 5, 19))
      assert(Exercises.primeFactor(1) == Seq.empty)
    }

    'test_sumScalar - {
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0)) == 0)
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 1)) == 0)
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1)) == 2)
      assert(Exercises.sumScalars(Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1), Exercises.Vector2D(2, 2), Exercises.Vector2D(2, 2)) == 10)
    }

    'test_sumCosines - {
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 1), Exercises.Vector2D(1, 0), Exercises.Vector2D(0, 1), Exercises.Vector2D(1, 0)) == 0)
      assert(Exercises.sumScalars(Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 1)) == 2)
      assert(Exercises.sumScalars(Exercises.Vector2D(0, -1), Exercises.Vector2D(0, 1), Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0)) == -1)
    }

    'test_sortByHeavyweight - {
      assert(Exercises.sortByHeavyweight(Map()) == Seq())

      val balls1 = Map("Graphite" -> (12, 2.1))
      assert(Exercises.sortByHeavyweight(balls1) == Seq("Graphite"))

      val balls2 = Map("Tungsten" -> (2, 19.35), "Graphite" -> (12, 2.1), "Aluminum" -> (3, 2.6889))
      assert(Exercises.sortByHeavyweight(balls2) == Seq("Aluminum", "Tungsten", "Graphite"))

      val balls3 = Map("Nickel" -> (2, 8.91), "Tin" -> (1, 7.29), "Platinum" -> (1, 21.45), "Plutonium" -> (3, 19.25))
      assert(Exercises.sortByHeavyweight(balls3) == Seq("Tin", "Platinum", "Nickel", "Plutonium"))
    }
  }
}
