package test

import org.scalatest.{FreeSpec, Matchers}

class OptionalTest extends FreeSpec with Matchers {

  "Optional" - {
    case class Employee(name: String, department: String)
    val em = Employee("Ronaldo", "Juventus")

    def lookUpByName(name: String): Option[Employee] = {
      Some(em)
    }

    lookUpByName("Ronaldo") should be(Some(em))

    val department = lookUpByName("Ronaldo").map(_.department)
    department should be(Some("Juventus"))

    def lookUpByNameNone(name: String): Option[Employee] = {
      None
    }

    lookUpByNameNone("Camilito gay") should be(None)
    val tmpDepartment = lookUpByNameNone("anyString").map(_.department)
    tmpDepartment should be(None)

    def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
      val algo = f(a.get, b.get)
      if (algo == Nil)
        None
      else
        Some(algo)
    }
  }

}
