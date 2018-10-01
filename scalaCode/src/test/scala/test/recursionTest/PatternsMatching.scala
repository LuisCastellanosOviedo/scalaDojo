package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class PatternsMatching extends FreeSpec with Matchers{


  " PM " - {
    case class Person(name:String,age:Int,lastName:String);
    val per1 = Person("per1",33,"lastName1")
    val per2 = Person("per2",34,"lastName2")
    val per3 = Person("per3",35,"lastName3")

    val personList = List(per1,per2,per3)


  val res =   per1 match  {
        case Person("per1",33,"lastName1") => "5"
    }

    res should be ("5")

  }

}
