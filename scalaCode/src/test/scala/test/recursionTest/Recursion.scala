package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class Recursion extends FreeSpec with Matchers{

  "fib " - {

    def fibNoRec (n:Int):Int={
      if(n==0 || n==1){
        1
      }else{
        (fibNoRec(n-1)).+(fibNoRec(n-2))
      }
    }

    fibNoRec(0) should be (1)
    fibNoRec(1) should be (1)
    fibNoRec(2) should be (2)
    fibNoRec(3) should  be (3)
    fibNoRec(11) should be (144)
  }


  "fib tail rec " - {
    def fibTail(n:Int):Int={
      def innerFib(acc:Int,n:Int): Int ={
        if(n==0 || n==1){
          acc
        }else {
         innerFib(acc,n-1)
        }
      }
      innerFib(1,n)
    }


    fibTail(0) should be (1)
    fibTail(1) should be (1)


  }


  " facto" - {
    def facto(n:Int):Int={
      if(n==0 || n == 1){
        1
      }else{
        n.*(facto(n-1))
      }
    }

    facto(0) should be (1)
    facto(1) should be (1)
    facto(2) should be (2)
    facto(3) should  be (6)

  }


  " facto tail" - {
    def factTail(n:Int):Int={

      @annotation.tailrec
      def innerFacto(acc:Int,n:Int): Int ={
        if(n<=0){
          acc
        }else{
          innerFacto(n*acc,n-1)
        }
      }
      innerFacto(1,n)
    }


    factTail(0) should be (1)
    factTail(1) should be (1)
    factTail(2) should be (2)
    factTail(9) should be (362880)
  }




}
