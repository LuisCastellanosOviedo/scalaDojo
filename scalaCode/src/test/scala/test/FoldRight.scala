package test

import org.scalatest.{FreeSpec, Matchers}

class FoldRightTest extends FreeSpec with Matchers {

  "FUck test" - {

    def sum(n: List[Int]): Int = n match {
      case Nil => 0
      case x :: xs => x + sum(xs)
    }

    def mult(n: List[Int]): Int = n match {
      case Nil => 1
      case x :: xs => x * mult(xs)
    }

    def foldRight[A, B](n: List[A], z: B) (f: (A, B) => B): B = n match {
      case Nil => z
      case x :: xs => f(x, foldRight(xs, z) (f))
    }

    foldRight(List.range(1, 5), 0) ((x, y) => x + y) should be (10)
    foldRight(List.range(1, 3), 1) ((x, y) => x * y) should be (2)
    foldRight(List(1,2,3),Nil:List[Int])(_::_) should be (List(1,2,3))

  }
}
