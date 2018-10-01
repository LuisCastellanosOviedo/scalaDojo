package test

object Dojo1 {
  def getStringDojo1(param1 : String) : String = {
    "hello world " + param1
  }


  def stringInterpolationtest(param:String):String=s" valor param $param"

  def getListNumbers() : Int = List(1,2,3,4,5).head

  def testFoldLeft():Int = List(1,2,3).foldLeft(0)(_+_)


}
