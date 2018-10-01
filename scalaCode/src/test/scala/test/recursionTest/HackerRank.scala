package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class HackerRank extends FreeSpec with Matchers{


  "print n timnes "-{

    def f (n:Int):String ={
      @annotation.tailrec
      def g (n:Int,acc:String):String = {
        if(n>0){
         g(n-1,acc+"Hello World \n")
        }else{
          acc
        }
      }
      g(n,"")

    }


    f(1) should be ("Hello World \n")
    f(2) should be ("Hello World \nHello World \n")

  }

}
