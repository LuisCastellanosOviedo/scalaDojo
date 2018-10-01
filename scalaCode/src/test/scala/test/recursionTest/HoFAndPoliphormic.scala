package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class HoFAndPoliphormic  extends  FreeSpec with Matchers{


  " hOF test " - {

    def sum(a:Int,b:Int):Int = {
      a.+(b)
    }

    def calc (a:Int,b:Int,x:(Int,Int) => Int):Int={
      x(a,b)
    }


    def calcPoli[A] (a:A,b:A,x:(A,A) => A):A={
      x(a,b)
    }

    calc(3,3,(a,b) => a+b) should be (6)
    calc(3,3,sum) should be (6)

    calcPoli(3,3,(a:Int,b:Int) => a.+(b)) should be (6)
    calcPoli(3,3,sum) should be (6)
  }

}
