package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Excercises.prettyBooleanFormatter1(314) == "314")
            assert(Excercises.prettyBooleanFormatter1(false) == "ложь")
        }

        'test_prettyBooleanFormatter2' - {
            assert(Excercises.prettyBooleanFormatter2(200) == "200")
            assert(Excercises.prettyBooleanFormatter2("nevermind") == "nevermind")
            assert(Excercises.prettyBooleanFormatter2(true) == "правда")

        }

        'test_prettyBooleanFormatter3' - {
            assert(Excercises.prettyBooleanFormatter3(404) == "404")
            assert(Excercises.prettyBooleanFormatter3("nevermind") == "nevermind")
            assert(Excercises.prettyBooleanFormatter3(true) == "правда")
        }

        'test_max1' - {
            assert(Excercises.max1(Seq()) == 0)
            assert(Excercises.max1(Seq(1,2)) == 2)
            assert(Excercises.max1(Seq(1,5,4)) == 5)
        }

        'test_max2' - {
            assert(Excercises.max2(Seq()) == Seq[Int]())
            assert(Excercises.max2(Seq(1,10)) == Seq[Int](10))
            assert(Excercises.max2(Seq(1,5,4)) == Seq[Int](5))
        }

        'test_max3' - {
            assert(Excercises.max3(Seq()).isEmpty)
            assert(Excercises.max3(Seq(1,10)) == 10)
            assert(Excercises.max3(Seq(1,5,4)) == 5)
        }

        'test_sum1 - {
            assert(sum1(5, 5) == 10)
            assert(sum1(5, -5) == 0)
            assert(sum1(54, 6) == 60)
        }

        'test_sum2 - {
            assert(sum2(10, 5) == 15)
            assert(sum2(0, 0) == 0)
            assert(sum2(10, 6) == 16)
        }

        'test_sum3 - {
            assert(sum3(0, 7) == 7)
            assert(sum3(200, 800) == 1000)
            assert(sum3(1, 6) == 7)
        }
    }
}
