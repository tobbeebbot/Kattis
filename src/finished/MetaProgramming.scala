package finished

/**
  * Created by Tobias Bladh on 2017-09-29.
  */
import scala.collection.mutable
import scala.io.StdIn

object MetaProgramming {
  def main(args: Array[String]): Unit = {
    while (true) {
      val line = StdIn.readLine()
      if (line == null) System.exit(0)

      val inst = line.split(" ")
      evaluate(inst)
    }
  }

  val vars = mutable.Map.empty[String, Int]

  def evaluate(inst : Array[String]): Unit = {
    inst match {
      case Array("define", i, s)
      => vars.update(s, i.toInt)

      case Array("eval", s1, op, s2) if checkdef(s1, s2)
      => compare(vars(s1), vars(s2), op)

      case _
      => println("undefined")
    }
  }

  def compare(i1: Int, i2: Int, op: String): Unit = {
    op match {
      case ">" => println(i1 > i2)
      case "<" => println(i1 < i2)
      case "=" => println(i1 == i2)
    }
  }

  def checkdef(s1 : String, s2: String): Boolean = {
    vars.isDefinedAt(s1) && vars.isDefinedAt(s2)
  }
}
