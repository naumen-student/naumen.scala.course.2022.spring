import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exerсises.divBy3Or7(1, 3) == Seq(3))
            assert(Exerсises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exerсises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exerсises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exerсises.sumOfDivBy3Or5(5, 9) == 20)
            assert(Exerсises.sumOfDivBy3Or5(0, 100) == 2418)
        }

        'test_primeFactor - {
            assert(Exerсises.primeFactor(3) == Seq(3))
            assert(Exerсises.primeFactor(4) == Seq(2))
            assert(Exerсises.primeFactor(80) == Seq(2, 5))
            assert(Exerсises.primeFactor(98) == Seq(2, 7))
        }

        'test_sumScalars - {
            assert(Exerсises.sumScalars(
                Exerсises.Vector2D(1, 2),
                Exerсises.Vector2D(1, 2),
                Exerсises.Vector2D(1, 2),
                Exerсises.Vector2D(1, 2)
            ) == 10.0)
        }


        'test_sumCosines - {
            assert(Exerсises.sumCosines(
                Exerсises.Vector2D(1, 2),
                Exerсises.Vector2D(1, 2),
                Exerсises.Vector2D(1, 2),
                Exerсises.Vector2D(1, 2)
            ) == 2.0)
        }

        'test_sortByHeavyweight - {
            assert(Exerсises.sortByHeavyweight(
                Map("Aluminum" -> (3, 2.6889), "Tungsten" -> (2, 19.35))) == Seq("Aluminum", "Tungsten")
            )
        }
    }
}
