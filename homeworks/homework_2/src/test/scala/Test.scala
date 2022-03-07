

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
            assert(Exercises.sumOfDivBy3Or5(1,5) == 8)
            assert(Exercises.sumOfDivBy3Or5(15, 30) == 180)
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars(Vector2D(3,5), Vector2D(5,3), Vector2D(2,2), Vector2D(3,3)) == 42)
            assert(Exercises.sumScalars(Vector2D(0,0), Vector2D(3,3), Vector2D(1,6), Vector2D(10,10)) == 70)
        }

        'test_sumCosines - {
            assert(Math.abs(Exercises.sumCosines(Vector2D(4,2), Vector2D(3,1), Vector2D(5,1), Vector2D(2,6)) - 1.48608843201) < 1e-10)
        }

        'primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2,5))
            assert(Exercises.primeFactor(98) == Seq(2,7))
        }
        'sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map("a" -> (1, 1), "b" -> (2, 2), "c" -> (3, 3))) == Seq("a", "b", "c"))
            assert(Exercises.sortByHeavyweight(Map("a" -> (3, 3), "b" -> (2, 2), "c" -> (1, 1))) == Seq("c", "b", "a"))
        }
    }
}
