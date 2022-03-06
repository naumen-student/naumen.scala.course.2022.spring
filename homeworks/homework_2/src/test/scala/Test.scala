import Exercises.{Vector2D, cosBetween, divBy3Or7, primeFactor, scalar, sortByHeavyweight, sumCosines, sumOfDivBy3Or5, sumScalars}
import utest._

object Test extends TestSuite {

  val tests = Tests {
    'test_divBy3Or7 - {
      assert(divBy3Or7(1, 2) == Seq())
      assert(divBy3Or7(1, 3) == Seq(3))
      assert(divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }

    'test_sumOfDivBy3Or5 - {
      assert(sumOfDivBy3Or5(1, 2) == 0)
      assert(sumOfDivBy3Or5(1, 3) == 3)
      assert(sumOfDivBy3Or5(3, 5) == 8)
      assert(sumOfDivBy3Or5(1, 15) == 60)
    }

    'test_primeFactor - {
      assert(primeFactor(3) == Seq(3))
      assert(primeFactor(80) == Seq(2, 5))
      assert(primeFactor(98) == Seq(2, 7))
    }

    'test_sumScalars - {
      val (vec1From, vec1To, vec2From, vec2To) = _getFourTestVectors()
      assert(sumScalars(vec1From, vec1To, vec2From, vec2To) == scalar(vec1From, vec1To) + scalar(vec2From, vec2To))
      assert(sumScalars(vec1From, vec2To, vec1From, vec2To) == scalar(vec1From, vec2To) + scalar(vec1From, vec2To))
    }

    'test_sumCosines - {
      val (vec1From, vec1To, vec2From, vec2To) = _getFourTestVectors()
      assert(sumCosines(vec1From, vec1To, vec2From, vec2To) == cosBetween(vec1From, vec1To) + cosBetween(vec2From, vec2To))
      assert(sumCosines(vec1From, vec2To, vec1From, vec2To) == cosBetween(vec1From, vec2To) + cosBetween(vec1From, vec2To))
    }

    'test_sortByHeavyweight - {
      assert(sortByHeavyweight(Map()) == Seq())
      assert(sortByHeavyweight(Map("A" -> (3, 2.6889))) == Seq("A"))
      assert(sortByHeavyweight(Map("A" -> (3, 2.6889), "T" -> (2, 19.35))) == Seq("A", "T"))
    }
  }

  private def _getFourTestVectors(): (Vector2D, Vector2D, Vector2D, Vector2D) = (
    Vector2D(1, 1),
    Vector2D(1, 2),
    Vector2D(10, 1),
    Vector2D(10, 2)
  )
}
