import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(0,0) == Seq(0))
            assert(Exercises.divBy3Or7(1,2) == Seq())
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30,
                33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91,
                93, 96, 98, 99))
            assert(Exercises.divBy3Or7(-9, 8) == Seq(-9, -7, -6, -3, 0, 3, 6, 7))
            assert(Exercises.divBy3Or7(-2, 2) == Seq(0))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(0, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(3, 9) == 23)
            assert(Exercises.sumOfDivBy3Or5(7,8) == 0)
            assert(Exercises.sumOfDivBy3Or5(-6, 0) == -14)
            assert(Exercises.sumOfDivBy3Or5(-10, 10) == 0)
            assert(Exercises.sumOfDivBy3Or5(-6, 3) == -11)
            assert(Exercises.sumOfDivBy3Or5(-3, 9) == 20)
            assert(Exercises.sumOfDivBy3Or5(0, 100) == 2418)
            assert(Exercises.sumOfDivBy3Or5(-100, 0) == -2418)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2,5))
            assert(Exercises.primeFactor(98) == Seq(2,7))
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(30) == Seq(2, 3, 5))
            assert(Exercises.primeFactor(7) == Seq(7))
            assert(Exercises.primeFactor(66) == Seq(2, 3, 11))
            assert(Exercises.primeFactor(9765625)== Seq(5))
            assert(Exercises.primeFactor(1073741824) == Seq(2))
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars(Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0),
                Exercises.Vector2D(0, 0), Exercises.Vector2D(0, 0)) == 0)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1),
                Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1)) == 4)
            assert(Exercises.sumScalars(Exercises.Vector2D(-1, 1), Exercises.Vector2D(1, -1),
                Exercises.Vector2D(-1, 1), Exercises.Vector2D(-1, 1)) == 0)
            assert(Exercises.sumScalars(Exercises.Vector2D(4, 2), Exercises.Vector2D(5,3),
                Exercises.Vector2D(2, 1), Exercises.Vector2D(3, 5)) == 37)
            assert(Exercises.sumScalars(Exercises.Vector2D(-2, 4), Exercises.Vector2D(5, 7),
                Exercises.Vector2D(3, -5), Exercises.Vector2D(1, 1)) == 16)
            assert(Exercises.sumScalars(Exercises.Vector2D(-5, -5), Exercises.Vector2D(-7, -2),
                Exercises.Vector2D(-2, -6), Exercises.Vector2D(-3, -3)) == 69)
            assert(Exercises.sumScalars(Exercises.Vector2D(7, 0), Exercises.Vector2D(0, -5),
                Exercises.Vector2D(0, 2), Exercises.Vector2D(-3, 0)) == 0)
        }

        'test_sumCosines - {
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 1), Exercises.Vector2D(0, 0),
                Exercises.Vector2D(0, 0), Exercises.Vector2D(1, 1)).isNaN)
            assert(Exercises.sumCosines(Exercises.Vector2D(1, 2), Exercises.Vector2D(1, 2),
                Exercises.Vector2D(2, 1), Exercises.Vector2D(2, 1)) == 2)
            assert(Exercises.sumCosines(Exercises.Vector2D(3, 6), Exercises.Vector2D(12, 24),
                Exercises.Vector2D(2, 4), Exercises.Vector2D(4, 8)) == 2)
            assert(Exercises.sumCosines(Exercises.Vector2D(2, 4), Exercises.Vector2D(1, 2),
                Exercises.Vector2D(6, 8), Exercises.Vector2D(3, 4)) == 2)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map()) == Seq())
            assert(Exercises.sortByHeavyweight(Map("Aluminum" -> (3,   2.6889))) == Seq("Aluminum"))
            assert(Exercises.sortByHeavyweight(Map("Nickel" ->   (2,   8.91), "Titanium" ->  (2,   10.50),
                "Uranium" ->   (2,   19.04))) == Seq("Nickel", "Titanium", "Uranium"))
            assert(Exercises.sortByHeavyweight(Exercises.balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum",
                "Titanium", "Lead", "Sodium",  "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper",
                "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
        }
    }
}