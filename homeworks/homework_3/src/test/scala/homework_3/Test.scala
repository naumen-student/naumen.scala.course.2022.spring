package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
    }
    
    'prettyBooleanFormatter1 - {
      assert(Exercises.prettyBooleanFormatter1(true) == "правда")
      assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter1(1) == "1")
      assert(Exercises.prettyBooleanFormatter1(ttt) == "ttt")
    }
    
      'prettyBooleanFormatter2 - {
      assert(Exercises.prettyBooleanFormatter2(true) == "правда")
      assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter2(1) == "1")
      assert(Exercises.prettyBooleanFormatter2(ttt) == "ttt")
    }
     'prettyBooleanFormatter3 - {
      assert(Exercises.prettyBooleanFormatter3(true) == "правда")
      assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter3(1) == "1")
      assert(Exercises.prettyBooleanFormatter3(ttt) == "ttt")
    }    
    
    'test_max1 - {
        assert(Exercises.max1(Seq(0)) == 0)
        assert(Exercises.max1(List(1,2,3)) == 3)
        assert(Exercises.max1(Seq(-1,-2,-3)) == -1)
    }
    
    'test_max2 - {
        assert(Exercises.max2(List(1,2,3)) == List(3))
        assert(Exercises.max2(Seq()) == Seq())
        assert(Exercises.max2(Seq(-2, 1, 1)) == Seq(1))
    }
    
    'test_max3 - {
        assert(Exercises.max3(emptyList).isEmpty)
        assert(Exercises.max3(Seq(1,2,3)) == Option(3))
    }
    
    'sum1 - {
        assert(Exercises.sum1(-1, 1) == 0)
        assert(Exercises.sum1(1, 4) == 5)
        assert(Exercises.sum1(0,0) == 0)
    }
    
    'sum2 - {
        assert(Exercises.sum1(-1, 1) == 0)
        assert(Exercises.sum1(1, 4) == 5)
        assert(Exercises.sum1(0,0) == 0)
    }

     'sum3 - {
        assert(Exercises.sum1(-1, 1) == 0)
        assert(Exercises.sum1(1, 4) == 5)
        assert(Exercises.sum1(0,0) == 0)
    }
    
        
    
}
