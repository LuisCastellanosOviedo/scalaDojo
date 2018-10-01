package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

import scala.annotation.tailrec

class Parentesis extends FreeSpec with Matchers {

  " homework recursion " - {

    val GetLeftParenthesis = (s: String, parLeft: Int) => if (s == "(") parLeft + 1 else parLeft
    val GetRightParenthesis = (s: String, parRight: Int) => if (s == ")") parRight + 1 else parRight
    val isValid = (parLeft: Int, parRight: Int) => if (parRight == parLeft) true else false


    def isBalanced(s: String): Boolean = {

     @tailrec
      def parenthessis(current: String, parLeft: Int, parRight: Int): Boolean = {
        if (current.length == 0) {
         isValid(parLeft, parRight)
        } else {
          parenthessis(current.tail, GetLeftParenthesis(current.head.toString, parLeft), GetRightParenthesis(current.head.toString(), parRight))
        }
      }

      parenthessis(s, 0, 0)
    }


    "(a".charAt(0).toString should be("(")
    "(a".length() should be(2)
    "(a".substring(1) should be("a")
    isBalanced("a") should be(true)
    isBalanced("(a") should be(false)

  }
}
