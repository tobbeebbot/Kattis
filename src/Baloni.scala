import java.util.{Collections, Scanner}

import scala.collection.mutable
import scala.io.StdIn

object Baloni {
  def main(args: Array[String]): Unit = {
    val N = StdIn.readInt()
    val input = StdIn.readLine().split(" ").map(x => x.toInt)
    val bloons = (0 until N).map(i => Bloon(i, input(i))).sortBy(x => x.y)

    println(bloons)


    def highest = bloons.head.y
    val grouped = bloons.groupBy(x => x.y)
    println(grouped)
    while(bloons.nonEmpty) {
      var height = highest

      while (height > 0) {
        val b = grouped(height).head
        height -= 1

      }
    }


  }

}

case class Bloon(x: Int,y :Int)