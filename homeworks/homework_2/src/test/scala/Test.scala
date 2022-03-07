import Exercises.Vector2D
import org.scalatest._

import scala.collection.mutable.ListBuffer
import scala.util.Random

class CubeCalculatorTest extends FunSuite {
    test("divBy30r7Test") {
        assert(Exercises.divBy3Or7(1, 3) == Seq(3))
        assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
        assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }

    test("sumOfDivBy3Or5Test") {
        assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)
        assert(Exercises.sumOfDivBy3Or5(-5, 5) == 0)
        assert(Exercises.sumOfDivBy3Or5(1, 20) == 98)
    }

    test("primeFactorTest") {
        assert(Exercises.primeFactor(5) == Seq(5))
        assert(Exercises.primeFactor(-10) == Seq(2, 5))
        assert(Exercises.primeFactor(100) == Seq(2, 5))
        assert(Exercises.primeFactor(2310) == Seq(2, 3, 5, 7, 11))
        assert(Exercises.primeFactor(0) == Seq())
    }

    private val getRandomNumber = () => Random.nextInt(1000) / 10.0 - 50

    private val getRandomVector = () => Vector2D(getRandomNumber(), getRandomNumber())

    private val getFourRandomVectors = () => {
        val vectors: ListBuffer[Vector2D] = ListBuffer()
        for (i <- 1 to 4) {
            vectors += getRandomVector()
        }
        vectors.toSeq
    }

    private val testRandomScalar = (vectors: Seq[Vector2D]) => {
        assert(Exercises.sumScalars(vectors(0), vectors(1), vectors(2), vectors(3)) ==
          Exercises.scalar(vectors(0), vectors(1)) + Exercises.scalar(vectors(2), vectors(3)))
    }

    private val testRandomCosines = (vectors: Seq[Vector2D]) => {
        assert(Exercises.sumCosines(vectors(0), vectors(1), vectors(2), vectors(3)) ==
          Exercises.cosBetween(vectors(0), vectors(1)) + Exercises.cosBetween(vectors(2), vectors(3)))
    }

    private val randomTest = (function: Seq[Vector2D] => Assertion) => {
        for (i <- 1 to 3) {
            function(getFourRandomVectors())
        }
    }

    private val e = 0.01

    test("sumScalarsTest") {
        randomTest(testRandomScalar)
        assert(Exercises.sumScalars(Vector2D(0, 1), Vector2D(3, 4), Vector2D(5, 6), Vector2D(7, 8)) == 87)
        val result = Exercises.sumScalars(Vector2D(0, 0.5), Vector2D(1.5, -2.1), Vector2D(3.1, -2), Vector2D(4, 2))
        assert(7.35 - e < result && result < 7.35 + e)
    }

    test("sumCosinesTest") {
        randomTest(testRandomCosines)
        val result0 = Exercises.sumCosines(Vector2D(0, 1), Vector2D(3, 4), Vector2D(5, 6), Vector2D(7, 8))
        assert(1.8 - e < result0 && result0 < 1.8 + e)
        val result1 = Exercises.sumCosines(Vector2D(0, 0.5), Vector2D(1.5, -2.1), Vector2D(3.1, -2), Vector2D(4, 2))
        println(-0.3 - e < result1 && result1 < -0.3 + e)
    }

    test("sortByHeavyweightTest") {
        assert(Exercises.sortByHeavyweight(Exercises.balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium",
            "Lead", "Sodium", "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium",
            "Cobalt", "Cesium", "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
        assert(Exercises.sortByHeavyweight(Map("Iron" -> Exercises.balls("Iron"),
            "Silver" -> Exercises.balls("Silver"), "Gold" -> Exercises.balls("Gold"))) == Seq("Gold", "Iron", "Silver"))
    }
}
