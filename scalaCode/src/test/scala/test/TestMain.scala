package test

import org.scalatest.{FreeSpec, Matchers}

class TestMain extends FreeSpec with Matchers{


  "main test " - {
    test.test() should be ("test")
  }



}
