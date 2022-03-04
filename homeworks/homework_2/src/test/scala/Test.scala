import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5' - {
            assert(sumOfDivBy3Or5(0, 100) == 2418)
            assert(sumOfDivBy3Or5(1, 20) == 98)
            assert(sumOfDivBy3Or5(0, 2) == 0)
        }

        'test_primeFactor' - {
            assert(primeFactor(80) == Seq(2,5))
            assert(primeFactor(51) == Seq(3,17))
            assert(primeFactor(67) == Seq(67))
            assert(primeFactor(0) == Seq())
            assert(primeFactor(8) == Seq(2))
        }

        'test_sumScalars' - {
            assert(sumScalars(Vector2D(0, 1), Vector2D(2, 3), Vector2D(4, 5), Vector2D(6, 7)) == 62)
            assert(sumScalars(Vector2D(-1, 4), Vector2D(3, 5), Vector2D(-3, 3), Vector2D(5, 1)) == 5)
        }

        'test_sumCosines' - {
            assert(sumCosines(Vector2D(0, 5), Vector2D(3, 4), Vector2D(0, 8), Vector2D(0, 2))) == 1.8)
            assert(sumCosines(Vector2D(0, -1), Vector2D(3, -4), Vector2D(-6, -8), Vector2D(0, 5)) == 0)
        }

        'test_sortByHeavyweight' - {
            assert(sortByHeavyweight(balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten",
                "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium", "Lithium",
                "Magnesium", "Potassium", "Graphite"))
        }
    }
}
