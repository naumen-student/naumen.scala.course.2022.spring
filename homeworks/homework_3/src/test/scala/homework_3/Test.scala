package homework_3

import homework_3.Exercises._
import utest._

object Test extends TestSuite{

    val convertedTrue = "правда"
    val convertedFalse = "ложь"

    val tests = Tests {
        'test_prettyBooleanFormatter1 - {
            assert(prettyBooleanFormatter1(true) == convertedTrue)
            assert(prettyBooleanFormatter1(false) == convertedFalse)
            assert(prettyBooleanFormatter1(1111) == "1111")
        }
        'test_prettyBooleanFormatter2 - {
            assert(prettyBooleanFormatter2(true) == convertedTrue)
            assert(prettyBooleanFormatter2(false) == convertedFalse)
            assert(prettyBooleanFormatter2(1111) == "1111")
        }
        'test_prettyBooleanFormatter3 - {
            assert(prettyBooleanFormatter3(true) == convertedTrue)
            assert(prettyBooleanFormatter3(false) == convertedFalse)
            assert(prettyBooleanFormatter3(1111) == "1111")
        }
        'test_max1 - {
            assert(max1(List()) == -1)
            assert(max1(List(42)) == 42)
            assert(max1(List(2, 2, 8)) == 8)
        }
        'test_max2 - {
            assert(max2(List()).isEmpty)
            assert(max2(List(42)) == List(42))
            assert(max2(List(2, 2, 8)) == List(8))
        }
        'test_max3 - {
            assert(max3(List()).isEmpty)
            assert(max3(List(42)) == Option(42))
            assert(max3(List(2, 2, 8)) == Option(8))
        }
        'test_sum1 - {
            assert(sum1(42, 42) == 84)
            assert(sum1(42, 0) == 42)
            assert(sum1(0, 42) == 42)
        }
        'test_sum2 - {
            assert(sum2(42, 42) == 84)
            assert(sum2(42, 0) == 42)
            assert(sum2(0, 42) == 42)
        }
        'test_sum3 - {
            assert(sum3(42, 42) == 84)
            assert(sum3(42, 0) == 42)
            assert(sum3(0, 42) == 42)
        }
    }
}
