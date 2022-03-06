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
      assert(Exercises.sumOfDivBy3Or5(3, 3) == 3)
      assert(Exercises.sumOfDivBy3Or5(5, 9) == 20)
      assert(Exercises.sumOfDivBy3Or5(0, 10) == 33)
      assert(Exercises.sumOfDivBy3Or5(7, 8) == 0)
    }
    'test_primeFactor - {
      assert(Exercises.primeFactor(10) == Seq(2, 5))
      assert(Exercises.primeFactor(98) == Seq(2, 7))
      assert(Exercises.primeFactor(80) == Seq(2, 5))
      assert(Exercises.primeFactor(7) == Seq(7))
      assert(Exercises.primeFactor(1) == Seq())
      assert(Exercises.primeFactor(-80) == Seq(2, 5))
    }
    'test_sumScalars - {
      val v1 = Exercises.Vector2D(1, 1)
      val v2 = Exercises.Vector2D(1, 0)
      val v3 = Exercises.Vector2D(1, 1)
      val v4 = Exercises.Vector2D(1, 0)
      assert((Exercises.sumScalars(v1, v2, v3, v4) - 2).abs < 0.0001)
      val v5 = Exercises.Vector2D(-5.5, 3)
      assert((Exercises.sumScalars(v1, v2, v3, v5) + 1.5).abs < 0.0001)
    }
    'test_sumCosines - {
      val v1 = Exercises.Vector2D(1, 1)
      val v2 = Exercises.Vector2D(1, 0)
      val v3 = Exercises.Vector2D(1, 1)
      val v4 = Exercises.Vector2D(1, 0)
      assert((Exercises.sumCosines(v1, v2, v3, v4) - 1.414213).abs < 0.0001)
      val v5 = Exercises.Vector2D(-5.5, 3)
      assert((Exercises.sumCosines(v1, v2, v3, v5) - 0.42494).abs < 0.0001)
    }
    'test_sortByHeavyweight - {
      val balls1: Map[String, (Int, Double)] =
        Map(
          "Aluminum" -> (3, 2.6889), "Graphite" -> (12, 2.1), "Tungsten" -> (2, 19.35)
        )
      val balls2: Map[String, (Int, Double)] =
        Map(
          "Graphite" -> (12, 2.1), "Aluminum" -> (3, 2.6889), "Tungsten" -> (2, 19.35)
        )
      val balls3: Map[String, (Int, Double)] =
        Map(
          "Gold" -> (2, 19.32), "Potassium" -> (14, 0.862), "Calcium" -> (8, 1.55), "Cobalt" -> (4, 8.90)
        )
      assert(Exercises.sortByHeavyweight(balls1) == Seq("Aluminum", "Tungsten", "Graphite"))
      assert(Exercises.sortByHeavyweight(balls2) == Seq("Aluminum", "Tungsten", "Graphite"))
      assert(Exercises.sortByHeavyweight(balls3) == Seq("Gold", "Cobalt", "Calcium", "Potassium"))
    }
  }
}
