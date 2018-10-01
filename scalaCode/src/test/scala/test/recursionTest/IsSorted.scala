package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class IsSorted extends FreeSpec with Matchers{



  " list"- {
    val x = List(1)
    val y = x :: List(2)

    print("")



  }

  " is Sorted " - {


    def isSorted[b] (as:Array[b],ordered:(b,b)=>Boolean):Boolean = {
      @annotation.tailrec
      def g (asTemp:Array[b]):Boolean={
        if(asTemp.length==0 || asTemp.length ==1){
          true
        } else if(ordered(asTemp(0),asTemp(1)) ) {
          g(asTemp.tail)
        }else{
          false
        }
      }

      g(as)
    }

    isSorted(Array(1),(a:Int,b:Int)=>a<=b) should be (true)
    isSorted(Array(0),(a:Int,b:Int)=>a<=b) should be (true)
    isSorted(Array(),(a:Int,b:Int)=>a<=b) should be (true)
    isSorted(Array(1,2),(a:Int,b:Int)=>a<=b) should be (true)
    isSorted(Array(2,1),(a:Int,b:Int)=>a<=b) should be (false)
    isSorted(Array(1,2,3),(a:Int,b:Int)=>a<=b) should be (true)
    isSorted(Array(1,2,4,3),(a:Int,b:Int)=>a<=b) should be (false)

  }
}
