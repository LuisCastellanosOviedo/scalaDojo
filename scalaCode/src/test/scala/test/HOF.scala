package test

import org.scalatest.{FreeSpec, Matchers}

class HOF extends FreeSpec with Matchers {

  "sum" - {
    def sum(a: Int, b: Int): Int = {
      a+b
    }

    def mult(a : Int, b: Int): Int = {
      a*b
    }

    def display(aString: String, aInt: Int, bInt: Int) = {
      aString + sum(aInt, bInt)
    }

    def displayString(aString: String, bString:String) = {
      aString + bString
    }

    def display1(aString: String, aInt: Int, bInt: Int, f:(Int, Int) => Int)= {
      aString + f(aInt, bInt)
    }

    // funcion polimorfica
    def display3[A](aString: String, aInt: A, bInt: A, f:(A, A) => A)= {
      aString + f(aInt, bInt)
    }

    sum(1, 2) should be (3)
    mult(2, 3) should be (6)
    display("Hello world ", 650, 300) should be ("Hello world 950")
    display1("Hello world ", 650, 300, sum) should be ("Hello world 950")
    display1("Hello world ", 6, 3, mult) should be ("Hello world 18")
    //display3("Hello world ", "6", "3", mult) should be ("Hello world 18")
    display3("Hello world ", "6", "3", displayString) should be ("Hello world 63")

  }
}
