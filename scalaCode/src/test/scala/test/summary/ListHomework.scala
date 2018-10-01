package test.summary

import org.scalatest.{FreeSpec, Matchers}

class ListHomework extends FreeSpec with Matchers {

  "Take example" - {

    List.range(1, 9).take(4) should be(List(1, 2, 3, 4)) //toma los primeros n , retorna lista vacia si no
    List.range(1, 9).takeWhile(p => p < 4) should be(List(1, 2, 3)) //toma los n primeros que cumplan la condicion
    List.range(1, 9).forall(x => x % 2 == 0) should be(false) //todos los elementos deben cumplir la condicion para true
    List.range(1, 9).exists(x => x > 7 && x < 9) should be(true) //si existe algun elemento que cumpla la condicion = true
  }

  "None-Some example" - {

    def listMean(list: List[Int]): Option[Int] = {
      list match {
        case Nil => None
        case x::xs => Some(list.sum / list.length)
      }
    }

    listMean(List(1, 5)) should be (Some(3))
    listMean(List()) should be (None)

    List(2, 4, 6).head should be(Some(2).get)
    List().headOption should be (None)
    List().headOption.getOrElse(0) should be (0)
    List().headOption.orElse(Some(0)) should be (Some(0))
  }

}