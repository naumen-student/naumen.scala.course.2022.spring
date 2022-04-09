import Exercises._
import org.scalatest._

class CubeCalculatorTest extends FunSuite {
    private val prettyBooleanFormatterTest = (prettyBooleanFormatter: (Any) => String) => {
        assert(prettyBooleanFormatter(true) == "правда")
        assert(prettyBooleanFormatter(false) == "ложь")
        assert(prettyBooleanFormatter("test") == "test")
        assert(prettyBooleanFormatter(1) == "1")
        assert(prettyBooleanFormatter(Seq(1, 2, 3)) == "List(1, 2, 3)")
    }

    test("prettyBooleanFormatterTest") {
        prettyBooleanFormatterTest(prettyBooleanFormatter1)
        prettyBooleanFormatterTest(prettyBooleanFormatter2)
        prettyBooleanFormatterTest(prettyBooleanFormatter3)
    }

    test("max1Test") {
        assertThrows[UnsupportedOperationException] {
            max1(Seq())
        }
        assert(max1(Seq(1, 2, 3)) == 3)
        assert(max1(Seq(8, 10, 3)) == 10)
    }

    test("max2Test") {
        assert(max2(Seq()) == Seq())
        assert(max2(Seq(1, 2, 3)) == Seq(3))
        assert(max2(Seq(8, 10, 3)) == Seq(10))
    }

    test("max3Test") {
        assert(max3(Seq()).isEmpty)
        assert(max3(Seq(1, 2, 3)).contains(3))
        assert(max3(Seq(8, 10, 3)).contains(10))
    }

    private val sumTest = (sum: (Int, Int) => Int) => {
        assert(sum(1, 2) == 3)
        assert(sum(100, 200) == 300)
        assert(sum(-5, 5) == 0)
    }

    test("sum1Test") {
        sumTest(sum1)
        sumTest(sum2)
        sumTest(sum3)
    }
}
