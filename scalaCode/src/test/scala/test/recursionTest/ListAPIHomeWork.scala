package test.recursionTest

import org.scalatest.{FreeSpec, Matchers}

class ListAPIHomeWork extends FreeSpec with Matchers{

  "take example " - {

    List(1,2,3,4).take(2) should be (List(1,2))
  }

  " takewhile" - {
    List(1,2,3,4).takeWhile(x=>x%2!=0) should be (List(1))
  }

  "for all example " - {
    List.range(1,5).forall(y=>y<99) should be (true)
    List.range(1,5).forall(y=>y>99) should be (false)
  }

  " exist example " - {
    List(1,2,3,4).exists(x=>x==3) should be (true)
    List.range(1,4).exists(x=>x==88) should be (false)
  }

}
