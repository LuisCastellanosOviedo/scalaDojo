package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class DropWhileOverList extends FreeSpec with Matchers{

  "drop while 1 " - {

    def drop[A](list:List[A],n:Int):List[A] = {

     if(n==0) list
     else  list match {

        case Nil => Nil
        case x::xs => drop(xs,n-1)
      }
    }

    drop(List(Nil),3) should be (Nil)
    drop(List(1,2,3,4),2) should be (List(3,4))
  }

  "drop while function " - {

    def dropWhile[A] (list:List[A],f:A=>Boolean): List[A] = {
      list match {
        case Nil => Nil
        case x::xs if f(x) => dropWhile(xs,f)
        case _ => list

      }

    }

    dropWhile(List(1,2,3,4,5),(x:Int)=> x<4) should be (List(4,5))
    dropWhile(List(),(x:Int)=> x<4) should be (List())
   // dropWhile(List(Nil),(x:Int)=> x<4) should be (Nil)

  }

  " curry " - {
    def dropWhile[A] (list:List[A])(f:A=>Boolean): List[A] = {
      list match {
        case Nil => Nil
        case x::xs if(f(x)) => dropWhile(xs)(f)
        case _ => list

      }
    }

    List.range(1,4).foldLeft(0)(_+_) should be (6)
    dropWhile(List(1,2,3,4,5))(x => x<4) should be (List(4,5))
    dropWhile(List(1)) (x => x<4) should be (List())
  }

}
