package finished

/**
  * Created by Tobias Bladh on 2017-09-29.
  */
import scala.io.StdIn.{readInt, readLine}

object AClassyProblem {
  def main(args: Array[String]): Unit = {
    val T = readInt()
    for (i <- 1 to T) {

      val n = readInt()
      var people = for (j <- 1 to n) yield {

        val input = readLine().split(Array(':',' ','-'))
        val name: String = input.head
        val status = input.tail.dropRight(1).drop(1)

        var stringRep = status.map(_.head).reverse.mkString
        val missing = 10 - stringRep.length
        stringRep += "m" * missing
        (stringRep, name)
      }

      people = people.sortWith((p1, p2) => p1._1 > p2._1 || (p1._1 == p2._1 && p1._2 < p2._2))

      people.foreach(p => println(p._2))
      println("=" * 30)
    }
  }
}
