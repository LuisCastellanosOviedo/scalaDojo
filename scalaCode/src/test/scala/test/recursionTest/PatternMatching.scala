package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}


class PatternMatching extends FreeSpec with Matchers{

  " main pm" - {

    def sumInts(ints:List[Int]):Int = ints match {
      case Nil => 0
      case x::xs => x+sumInts(xs)
    }


    sumInts(List(1)) should be (1)
    sumInts(List(1,2)) should be (3)
    sumInts(Nil) should be (0)
    sumInts(List.range(0,6)) should be (15)
  }


  "multi pm " - {
    def multi(ints:List[Int]):Int = ints match {
      case Nil => 0
      case 0::_ =>0
      case x::xs => x + multi(xs)
    }


    multi(Nil) should be (0)
    multi(List(0)) should be (0)
    multi(List(1)) should be (1)
    multi(List.range(1,4)) should be (6)


  }

  " list " - {

    def addEleemntTail(list : List[Int],elem:Int):List[Int]={
      elem::list
    }


    addEleemntTail(List.range(0,3),4) should be (List(4,0,1,2))
    addEleemntTail(Nil,1) should be (List(1))

  }

  " add tail " - {
    def addTail(ints:List[Int],element:Int):List[Int]= {
      ints:+element
    }

    addTail(List(1),2) should be (List(1,2))
  }


  " set head " - {
    def setHead(ints:List[Int],newHead:Int):List[Int]={
      newHead::ints.tail
    }

    def setHeadPM(ints:List[Int],newHead:Int):List[Int]= ints match {
      case Nil => List(newHead)
      case x::xs => newHead::xs
    }


    setHead(List(2),1) should be (List(1))
    setHeadPM(List(1,2),3) should be (List(3,2))
  }

}
