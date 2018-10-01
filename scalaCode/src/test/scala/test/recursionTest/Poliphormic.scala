package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class Poliphormic extends FreeSpec with Matchers{

  " poli" - {
    def partial1[A,B,C] (a:A,f:(A,B)=> C): B => C  ={
      (b:B) => f(a,b)
    }
  }


  "curry " - {
    def curry[A,B,C] (f:(A,B)=>C): A=> (B=>C)={
      a=>b=> f(a,b)
    }

    def concat (i:Int,s:String):String =i+s



      val curried =  curry(concat)
    val curriedA = curried(5)
    curriedA("ratas") should be ("5ratas")

  }


}
