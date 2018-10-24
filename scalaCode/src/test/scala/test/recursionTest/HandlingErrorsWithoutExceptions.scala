package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class HandlingErrorsWithoutExceptions extends FreeSpec with Matchers{

  "optional " - {
    def mean (list: Seq[Int]): Option[Int]={
      list match {
        case Nil => None
        case x::xs => Some(list.sum/list.length)
      }
    }

    mean(List()) should be (None)
    mean(List(2,2)) should be (Some(2))
    mean(List(2,2)).get should be (2)
  }


  "head option " - {
    List(1).headOption should be (Some(1))
    List().headOption should be (None)
  }

  "last option " - {
    List(1).lastOption should be (Some(1))
    List().lastOption should be (None)
  }

  " getorelse " - {
    List().headOption.orElse(Some(1)) should be (Some(1))
    List().headOption.getOrElse(1) should be (1)
  }

  "new example " - {
    case class Employee (name:String ,department : String )

    def lookupByNameSome(name:String) : Option[Employee] = {
      val employee = Employee("lucho","sales")
      Some(employee)
    }

    def lookupByNameNone(name:String) : Option[Employee] = {
      None
    }

    val department = lookupByNameNone("lucho").map(_.department)
    department should be (None)

  }


  "def map2 " - {


    def parseInsurance(age:String,numberOfTickets:String):Option[Int]={
      val optAge = Try{age.toInt}
      val optTickets = Try {numberOfTickets.toInt}
      map2(optAge,optTickets) (insurance)
    }

    def insurance(age:Int,numberOfTickets:Int):Int = age+numberOfTickets




    def Try[A](a: =>A):Option[A]={
      try Some(a)
      catch {case e : Exception => None}
    }


    def map2[A,B,C](a:Option[A],b:Option[B])(f:(A,B)=>C):Option[C]={
      if(!a.isDefined || !b.isDefined){
        None
      }else{
        Option(f(a.get,b.get))
      }
    }

    parseInsurance("2","dddd") should be (None)
    parseInsurance("2","3") should be (Some(5))
  }

}
