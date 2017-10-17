package finished

/**
  * Created by Tobias Bladh on 2017-09-30.
  */
import scala.collection.mutable
import scala.io.StdIn

object AddingWords {
  def main(args: Array[String]): Unit = {
    while (true) {
      val line = StdIn.readLine()
      if (line == null) System.exit(0)

      val inst = line.split(" ")
      evaluate(inst.toVector)
    }
  }

  val vars = mutable.Map.empty[String, Int]

  def evaluate(inst : Vector[String]): Unit = {
    inst match {
      case Vector("def", s, i)
      => vars.update(s, i.toInt)

      case "calc" +: v :+ "="
      => println(v.mkString(" ") + " = " + calculate(v))

      case Vector("clear") =>
        vars.clear()

      case _
      => System.exit(0) //En till exit bara för att va säker.
    }
  }

  def isDef(s : String): Boolean = {
    s match {
      case "+" => true
      case "-" => true
      case s => vars.isDefinedAt(s)
    }
  }

  def calculate(a :Vector[String]): String = {
    var op = 1
    var sum = 0
    var i = 0
    var lastok = true
    while(i < a.length && {lastok = isDef(a(i)); lastok}) {
      a(i) match {
        case "+" => op = sign(a(i))
        case "-" => op = sign(a(i))
        case s => sum += vars(s) * op
      }
      i += 1
    }
    if (lastok)
      vars.find(_._2 == sum) match {
        case Some((s, _)) => s
        case None => "unknown"
      }
    else
      "unknown"
  }

  def sign(s : String): Int = {
    s match {
      case "+" => 1
      case "-" => -1
      case _ => throw new Exception("ej aritmetiskt!")
    }
  }
}
