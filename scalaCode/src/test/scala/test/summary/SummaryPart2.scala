package test.summary

import org.scalatest.{FreeSpec, Matchers}

class SummaryPart2 extends FreeSpec with Matchers {

  "HOF" - {
    def sum(arg1: Int, arg2: Int): Int = arg1 + arg2

    def prod(arg1: Int, arg2: Int): Int = arg1 * arg2

    sum(1, 2) should be(3)
    prod(1, 2) should be(2)

    def concatMult(sMessage: String, aInt: Int, bInt: Int): String = {
      sMessage + prod(aInt, bInt)
    }

    def concatSum(sMessage: String, aInt: Int, bInt: Int): String = {
      sMessage + sum(aInt, bInt)
    }

    def concatStr(sMessage1: String, sMessage2: String) : String = sMessage1 + sMessage2

    def concatHUF(sMessage: String, aInt: Int, bInt: Int, f: (Int, Int) => Int): String = sMessage + f(aInt, bInt)

    def concatPoli[A](sMessage: String, aInt: A, bInt: A, f: (A, A) => A): String = sMessage + f(aInt, bInt)

    def getHead(l : List[Int]): Int = l match {
      case Nil => -1
      case x :: xs => x
     // case x :: Nil => x
    }

    getHead(List.range(1, 5)) should be (1)
    getHead(List(1)) should be (1)

    concatMult("Hello ", 4, 5) should be("Hello 20")

    concatSum("Hello ", 4, 5) should be("Hello 9")

    concatHUF("Hello ", 4, 5, sum) should be("Hello 9")

    concatHUF("Hello ", 4, 5, prod) should be("Hello 20")

    concatPoli("Hello", " sol y", " luna", concatStr) should be ("Hello sol y luna")
  }

}
