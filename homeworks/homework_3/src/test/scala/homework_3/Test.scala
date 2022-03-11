package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        val trueStr = "правда"
        val falseStr = "ложь"

        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
            assert(Exercises.prettyBooleanFormatter1(Seq(1, 2)) == "List(1, 2)")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
            assert(Exercises.prettyBooleanFormatter1(Seq(1, 2)) == "List(1, 2)")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
            assert(Exercises.prettyBooleanFormatter1(Seq(1, 2)) == "List(1, 2)")
        }

        'test_maxInt1 - {
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(1, 2)) == 2)
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq.empty[Int]) == 0)
        }

        'test_maxInt2 - {
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(1, 2)) == Seq(2))
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq.empty[Int]) == Seq())
        }

        'test_maxInt3 - {
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq(1, 2)).contains(2))
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq.empty[Int]).isEmpty)
        }

        'test_sum - {
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(1, 1) == 2)
            assert(Exercises.sum1(-1, -1) == -2)

            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(1, 1) == 2)
            assert(Exercises.sum2(-1, -1) == -2)

            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(1, 1) == 2)
            assert(Exercises.sum3(-1, -1) == -2)
        }
    }
}
