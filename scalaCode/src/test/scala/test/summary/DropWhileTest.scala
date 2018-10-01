package test.summary

import org.scalatest.{FreeSpec, Matchers}

class DropWhileTest extends FreeSpec with Matchers {

  "Drop While bitches" - {
    def dropWhile[A](list: List[A], n: Int): List[A] = {

      if (n == 0) list
      else
        list match {
          case Nil => Nil
          case x :: xs => dropWhile(xs, n - 1)
        }
    }

    dropWhile(Nil, 4) should be(Nil)
    dropWhile(List.range(1, 3), 0) should be(List(1, 2))
    dropWhile(List.range(1, 5), 2) should be(List(3, 4))
  }

  "Another test mother fucker" - {
    def dropWhileH[A](list: List[A])(f: (A) => Boolean): List[A] = list match {
      case Nil => Nil
      case x :: xs if !f(x) => dropWhileH(xs)(f)
      case _ => list
    }

      dropWhileH(List.range(1, 6))(x => x > 3) should be(List(4, 5))
  }
}
