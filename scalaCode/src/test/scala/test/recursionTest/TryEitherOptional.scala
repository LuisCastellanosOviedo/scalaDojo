package test.recursionTest

import com.sun.net.httpserver.Authenticator.Success
import org.scalatest.{FreeSpec, Matchers}

import scala.util.{Success, Try}

class TryEitherOptional extends FreeSpec with Matchers{

// pattern mat vs if
  // ejemplo either
  // ejemplo try
  // try vs either vs optional

  "Try"-{




    def dividir(x:Int,y:Int):Either[String,Int] ={
        if(y==0) Left("No se puede dividir ") else Right(x/y)
    }

    def execute(x:Int,y:Int) :String = dividir(x,y) match {
      case Left(x) =>   s"MALDITA SEA ERROR $x"
      case Right(x) => s"EL RESULTADO ES $x"
    }


    def validValue(value:String):Try[Int]={
        Try(value.toInt)
    }

    def executeString(x:String):Int = {

        validValue(x).map(_ + 2).getOrElse(1)

    }

    def executeStringHead(x:String):Int = {

      validValue(x).recover{
        case e : Exception => 0
      }.map(_ + 2)
        .get
    }

    executeStringHead("gfdgfdgdgdf") should be (2)
    executeStringHead("3") should be (5)
    executeString("a") should be (1)
    executeString("3") should be (5)
    execute(4,2) should be ("EL RESULTADO ES 2")
    execute(4,0) should be ("MALDITA SEA ERROR No se puede dividir ")
  }

}
