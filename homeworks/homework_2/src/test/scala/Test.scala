import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_divBy3Or5 - {
            assert(Exercises.divBy3Or5(1, 6) == 14)
            assert(Exercises.divBy3Or5(5, 10) == 30)
            assert(Exercises.divBy3Or5(4,5) == 5)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(7) == Seq(7))
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(2) == Seq(2))
        }

        'test_sumScalars' - {
            assert(Exercises.SumScalars(Vector2D(2, 4), Vector2D(4, 2), Vector2D(6, 4), Vector2D(4, 6)) == 64)
            assert(Exercises.SumScalars(Vector2D(3, 5), Vector2D(5, 3), Vector2D(7, 5), Vector2D(5, 7)) == 100)
            assert(Exercises.SumScalars(Vector2D(-10, 1), Vector2D(1, -10), Vector2D(0, 1), Vector2D(2, 7)) == -13)
        }

        'test_sumCosines' - {
            assert(Exercises.sumCosines(Vector2D(8, 8), Vector2D(8, 8), Vector2D(2, 4), Vector2D(2, 4)) == 2)
            assert(Exercises.sumCosines(Vector2D(0, 8), Vector2D(8, 0), Vector2D(2, 4), Vector2D(2, 4)) == 1)
            assert(Exercises.sumCosines(Vector2D(0,2), Vector2D(0, 1), Vector2D(0, 2), Vector2D(3, 4)) == 1.8)
        }

        'test_sortByHeavyweight' - {

        }
    }
}
