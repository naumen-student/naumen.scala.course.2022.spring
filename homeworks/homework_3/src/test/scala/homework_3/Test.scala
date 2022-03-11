package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(0) == "0")
            assert(Exercises.prettyBooleanFormatter1(1.0) == "1.0")
            assert(Exercises.prettyBooleanFormatter1(-1) == "-1")
            assert(Exercises.prettyBooleanFormatter1("Example") == "Example")
            assert(Exercises.prettyBooleanFormatter1(List()) == "List()")
            assert(Exercises.prettyBooleanFormatter1(List(1,2,3,4,5)) == "List(1, 2, 3, 4, 5)")
        }

        'prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(0) == "0")
            assert(Exercises.prettyBooleanFormatter2(1.0) == "1.0")
            assert(Exercises.prettyBooleanFormatter2(-1) == "-1")
            assert(Exercises.prettyBooleanFormatter2("Example") == "Example")
            assert(Exercises.prettyBooleanFormatter2(List()) == "List()")
            assert(Exercises.prettyBooleanFormatter2(List(1,2,3,4,5)) == "List(1, 2, 3, 4, 5)")
        }

        'prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(0) == "0")
            assert(Exercises.prettyBooleanFormatter3(1.0) == "1.0")
            assert(Exercises.prettyBooleanFormatter3(-1) == "-1")
            assert(Exercises.prettyBooleanFormatter3("Example") == "Example")
            assert(Exercises.prettyBooleanFormatter3(List()) == "List()")
            assert(Exercises.prettyBooleanFormatter3(List(1,2,3,4,5)) == "List(1, 2, 3, 4, 5)")
        }

        'max1 - {
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(1, 2, 3, 4, 5)) == 5)
            assert(Exercises.max1(Seq(5, 4, 3, 2, 1)) == 5)
            assert(Exercises.max1(Seq(-1, 0)) == 0)
            assert(Exercises.max1(Seq(-5, -2, 3, 0, 2)) == 3)
        }

        'max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(1, 2, 3, 4, 5)) == Seq(5))
            assert(Exercises.max2(Seq(5, 4, 3, 2, 1)) == Seq(5))
            assert(Exercises.max2(Seq(-1, 0)) == Seq(0))
            assert(Exercises.max2(Seq(-5, -2, 3, 0, 2)) == Seq(3))
        }

        'max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq(1, 2, 3, 4, 5)).contains(5))
            assert(Exercises.max3(Seq(5, 4, 3, 2, 1)).contains(5))
            assert(Exercises.max3(Seq(-1, 0)).contains(0))
            assert(Exercises.max3(Seq(-5, -2, 3, 0, 2)).contains(3))
        }

        'sum1 - {
            assert(Exercises.sum1(0,0) == 0)
            assert(Exercises.sum1(2,0) == 2)
            assert(Exercises.sum1(0,2) == 2)
            assert(Exercises.sum1(-1,1) == 0)
            assert(Exercises.sum1(1, -1) == 0)
            assert(Exercises.sum1(2,2) == 4)
            assert(Exercises.sum1(-2,-2) == -4)
        }

        'sum2 - {
            assert(Exercises.sum2(0,0) == 0)
            assert(Exercises.sum2(2,0) == 2)
            assert(Exercises.sum2(0,2) == 2)
            assert(Exercises.sum2(-1,1) == 0)
            assert(Exercises.sum2(1, -1) == 0)
            assert(Exercises.sum2(2,2) == 4)
            assert(Exercises.sum2(-2,-2) == -4)
        }

        'sum3 - {
            assert(Exercises.sum3(0,0) == 0)
            assert(Exercises.sum3(2,0) == 2)
            assert(Exercises.sum3(0,2) == 2)
            assert(Exercises.sum3(-1,1) == 0)
            assert(Exercises.sum3(1, -1) == 0)
            assert(Exercises.sum3(2,2) == 4)
            assert(Exercises.sum3(-2,-2) == -4)
        }
    }
}
