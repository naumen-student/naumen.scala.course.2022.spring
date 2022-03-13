package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'prettyFormatterFunctionstsTests - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(10) == "10")
            assert(Exercises.prettyBooleanFormatter3("test") == "test")
        }

        'maxFunctionstsNotEmptyTest - {
            val numbers = List(1, 2, 3, 4, 5)
            assert(Exercises.max1(numbers) == 5)
            assert(Exercises.max2(numbers) == Seq(5))
            assert(Exercises.max3(numbers).contains(5))
        }

        'maxFunctionstsEmptyTest - {
            val numbers = List()
            assert(Exercises.max1(numbers) == Int.MinValue)
            assert(Exercises.max2(numbers) == Seq())
            assert(Exercises.max3(numbers).isEmpty)
        }

        'sumFunctionstsTest - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum3(1, 2) == 3)
        }
    }
}
