package test

import org.scalatest.{FreeSpec, Matchers}

class List1Test extends FreeSpec with Matchers {

  "Functional Structures" - {
    def addHead[A](aList: List[A], element: A): List[A] = {
      element :: aList
    }

    def addElementAtEnd [A] (aList: List[A], element: A): List[A] = {
      aList :+ element
    }

    def replaceHead [A] (aList: List[A], element: A) : List[A] = {
      element :: aList.tail
    }

    def replaceHeadPM[A](aList: List[A], element:A): List[A] = aList match {
      case Nil => List(element)
      case x :: xs => element :: xs
    }

    def sumList (aList: List[Int]): Int = aList match {
      case Nil => 0
      case x:: xs => x + sumList(xs)
    }


    addHead(List.range(1, 5), 0) should be (List.range(0, 5))
    addHead(List("a", "b"), "c") should be (List("c", "a", "b"))
    addElementAtEnd(List("a", "b", "c"), "d") should be (List("a", "b", "c", "d"))
    replaceHeadPM(List.range(1, 4), 0) should be (List(0, 2, 3))
    sumList(List.range(1, 5)) should be (10)
  }




}
