package test

import org.scalatest.{FreeSpec, Matchers}

class Dojo1test extends FreeSpec with Matchers {
  "prueba string" - {
    Dojo1.getStringDojo1("Luchito") should be ("hello world Luchito")

  }

  " test string interpolation " - {
    Dojo1.stringInterpolationtest(" interpolation") should be (" valor param  interpolation")

  }

  "test get tail" - {
    Dojo1.getListNumbers() should be (1)
  }

  "foldLeft" - {
    Dojo1.testFoldLeft() should be (6)
  }

  "case class" - {
    case class Car (brand: String, price: Int)
    val carrito = Car("Mazda", 1000)
    carrito.brand should be ("Mazda")
  }
  }
