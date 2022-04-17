import Exercises.Vector2D
import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(1, 100) == 2418)
            assert(Exercises.sumOfDivBy3Or5(1, 1000000000) == 233333334166666668L)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(123) == Seq(3, 41))
            assert(Exercises.primeFactor(2147000000) == Seq(2, 5, 19, 113))
            assert(Exercises.primeFactor(2) == Seq(2))
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars(Vector2D(1, 1), Vector2D(2, 2), Vector2D(3, 3), Vector2D(4, 4)) == 28)
            assert(Exercises.sumScalars(Vector2D(1e5, 1), Vector2D(1e5, 1), Vector2D(2, 3), Vector2D(4, 5)) == 1e10+24)
        }

        'test_sumCosines - {
            assert(Math.abs(Exercises.sumCosines(Vector2D(1, 2), Vector2D(2.3, 4), Vector2D(2.1, 23),
                Vector2D(2, 31)) - 1.99795) < 1e9)
            assert(Math.abs(Exercises.sumCosines(Vector2D(1000000, 10000), Vector2D(1231232, 123321),
                Vector2D(14959, 21392), Vector2D(231, 123.123)) - 1.88715) < 1e9)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(
                Map(
                    ("two", (3, 3)), ("three", (4, 4)), ("one", (1, 1))
                )) == Seq("one", "two", "three"))
        }
    }


}
