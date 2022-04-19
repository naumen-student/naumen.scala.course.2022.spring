import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(10) == "10")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(10) == "10")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(10) == "10")
        }

        'test_max1 - {
            assert(Exercises.max1(List()) == -1)
            assert(Exercises.max1(List(1)) == 1)
            assert(Exercises.max1(List(1, 2)) == 2)
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Vector(1, 3, 2)) == 3)
        }

        'test_max2 - {
            assert(Exercises.max2(List()) == List())
            assert(Exercises.max2(List(1)) == List(1))
            assert(Exercises.max2(List(1, 2)) == List(2))
            assert(Exercises.max2(Seq(1, 2, 3)) == List(3))
            assert(Exercises.max2(Vector(1, 3, 2)) == List(3))
        }

        'test_max3 - {
            assert(Exercises.max3(List()).isEmpty)
            assert(Exercises.max3(List(1)).contains(1))
            assert(Exercises.max3(List(1, 2)).contains(2))
            assert(Exercises.max3(Seq(1, 2, 3)).contains(3))
            assert(Exercises.max3(Vector(1, 3, 2)).contains(3))
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(3, 5) == 8)
        }

        'test_sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(3, 5) == 8)
        }

        'test_sum3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(3, 5) == 8)
        }
    }
}
