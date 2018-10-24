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
      (a, b) match {
        case (None, Some(b)) => None
        case (Some(a), None) => None
        case (None, None) => None
        case (Some(a), Some(b)) => try {
          Some(f(a, b))
        } catch {
          case e: Exception => None
        }
      }
    }

    map2(Some(2), Some(4))((a, b) => a * b) should be(Some(8))
    map2(Some(2), Some(0))((a, b) => a / b) should be(None)
    map2(None, None)((a: Int, b: Int) => a + b) should be(None)

    def calcularImpuesto(a: Int, b: Int): Option[Int] = {
      val optionA = Some(a)
      val optionB = Some(b)
      map2(optionA, optionB)(calcularDeVerdad)
    }

    def calcularDeVerdad(a: Int, b: Int): Int = a + b
  }

}
