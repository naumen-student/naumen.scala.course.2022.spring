import utest._
import Exercises.Vector2D

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(-5, 10) == 25)
            assert(Exercises.sumOfDivBy3Or5(0, 2) == 0 )
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(3) == Seq(3))
            assert(Exercises.primeFactor(2023) == Seq(7, 17))
        }

        'test_sumByFunc - {
            assert(Exercises.sumByFunc(new Vector2D(3, 2), new Vector2D(2, 3),
                                       Exercises.scalar,
                                       new Vector2D(1, 2), new Vector2D(2, 1)
                                       ) == 16)
            assert(Exercises.sumByFunc(new Vector2D(1, 0), new Vector2D(1, 0),
                                       Exercises.cosBetween,
                                       new Vector2D(0, 1), new Vector2D(0, 1)
                                       ) == 2)
            assert(Exercises.sumByFunc(new Vector2D(1, 1), new Vector2D(1, 1),
                                       Exercises.scalar,
                                       new Vector2D(0, 1), new Vector2D(0, 1)
                                       ) == 3)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map("Aluminum" -> (3, 2.6889),
                                                   "Potassium" -> (14, 0.862),
                                                   "Tin" -> (1, 7.29))
                                              ) == Seq("Tin", "Aluminum", "Potassium"))
        }
    }
}
