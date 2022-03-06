import utest._
import Exercises.{Vector2D}


object Test extends TestSuite {

    val tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 2) == Seq())
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(3, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(1, 15) == 60)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(3) == Seq(3))
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
        }

        'test_sumScalars1 - {
            val (vec1From, vec1To, vec2From, vec2To) = (Vector2D(1, 1),
              Vector2D(1, 2),
              Vector2D(1, 1),
              Vector2D(2, 1))
            assert(Exercises.sumScalars(vec1From, vec1To, vec2From, vec2To) == Exercises.scalar(vec1From, vec1To) + Exercises.scalar(vec2From, vec2To))
            assert(Exercises.sumScalars(vec1From, vec2To, vec1From, vec2To) == Exercises.scalar(vec1From, vec2To) + Exercises.scalar(vec1From, vec2To))
        }

        'test_sumScalars2 - {
            val (vec1From, vec1To, vec2From, vec2To) = (Vector2D(21, 21),
              Vector2D(32, 13),
              Vector2D(12, 23),
              Vector2D(42, 12))
            assert(Exercises.sumScalars(vec1From, vec1To, vec2From, vec2To) == Exercises.scalar(vec1From, vec1To) + Exercises.scalar(vec2From, vec2To))
            assert(Exercises.sumScalars(vec1From, vec2To, vec1From, vec2To) == Exercises.scalar(vec1From, vec2To) + Exercises.scalar(vec1From, vec2To))
        }

        'test_sumCosines1 - {
            val (vec1From, vec1To, vec2From, vec2To) = (Vector2D(1, 1),
              Vector2D(1, 2),
              Vector2D(1, 1),
              Vector2D(2, 1))
            assert(Exercises.sumCosines(vec1From, vec1To, vec2From, vec2To) == Exercises.cosBetween(vec1From, vec1To) + Exercises.cosBetween(vec2From, vec2To))
            assert(Exercises.sumCosines(vec1From, vec2To, vec1From, vec2To) == Exercises.cosBetween(vec1From, vec2To) + Exercises.cosBetween(vec1From, vec2To))
        }

        'test_sumCosines2 - {
            val (vec1From, vec1To, vec2From, vec2To) = (Vector2D(21, 21),
              Vector2D(32, 13),
              Vector2D(12, 23),
              Vector2D(42, 12))
            assert(Exercises.sumCosines(vec1From, vec1To, vec2From, vec2To) == Exercises.cosBetween(vec1From, vec1To) + Exercises.cosBetween(vec2From, vec2To))
            assert(Exercises.sumCosines(vec1From, vec2To, vec1From, vec2To) == Exercises.cosBetween(vec1From, vec2To) + Exercises.cosBetween(vec1From, vec2To))
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map()) == Seq())
            assert(Exercises.sortByHeavyweight(Map("Aluminum" -> (3,   2.6889))) == Seq("Aluminum"))
            assert(Exercises.sortByHeavyweight(Map("Aluminum" -> (3,   2.6889), "Tungsten" ->  (2,   19.35), "Graphite" ->  (12,  2.1))) == Seq("Aluminum", "Tungsten", "Graphite"))
        }
    }
}