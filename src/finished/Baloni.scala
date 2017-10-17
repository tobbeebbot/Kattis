package finished

import scala.collection.mutable
import scala.io.StdIn

object Baloni {
  def main(args: Array[String]): Unit = {
    val N = StdIn.readInt() // används ej, då foreach används istället
    val baloons = StdIn.readLine().split(" ")

    //(Height, Number of Arrows)
    val activeArrows = mutable.Map.empty[Int, Int]

    var n = 0
    baloons foreach { s =>
      val height = s.toInt
      val arrows = activeArrows.getOrElse(height, 0) //nr of arrows at that height

      if (arrows > 0) { //Don't need to shoot another one
        activeArrows.update(height, arrows - 1)
      }
      else n += 1 //Had to shoot
      val newHeight = height - 1
      activeArrows.update(newHeight, activeArrows.getOrElse(newHeight, 0) + 1) //Lower arrow one step
    }
    println(n)
  }
}