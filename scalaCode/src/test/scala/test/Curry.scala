package test

import org.scalatest.{FreeSpec, Matchers}

class Curry extends FreeSpec with Matchers{

  "curry" - {
    def curry[A,B,C](f:(A, B) => C): A => (B => C) = {
      a => b => f(a, b)
    }

    def concat(aInt: Int, aString: String): String = {
      aInt + aString
    }

    val curry1 = curry(concat)
    val curryA = curry1(5)
    curryA("Raticas") should be ("5Raticas")
  }



}
