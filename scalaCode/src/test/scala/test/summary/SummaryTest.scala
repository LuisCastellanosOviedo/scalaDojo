package test.summary

import org.scalatest.{FreeSpec, Matchers}

class SummaryTest extends FreeSpec with Matchers {

  "String interpolation" - {
    def stringInterpolation(param: String): String = {
      s"Hello World $param"
    }

    stringInterpolation("Maricas") should be("Hello World Maricas")
  }

  "Listas" - {
    def listas(params: List[Int]): Int = params.head

    listas(List(1, 2, 3)) should be(1)
  }

  "no recursive" - {
    def sum(param: List[Int]): Int = {
      if (param.isEmpty)0
      else param.head + sum(param.tail)
    }

    sum(List()) should be(0)
    sum(List.range(1,5)) should be(10)
  }

  "tail recursion" - {
    def sumR(param : List[Int]) : Int = {
      def iter(acum : Int, p : List[Int]): Int = {
        if(p.isEmpty) acum
        else iter(acum + p.head, p.tail)
      }

      iter(0, param)
    }

    sumR(List.range(1, 5)) should be (10)
  }



}
