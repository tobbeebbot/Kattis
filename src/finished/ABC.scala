package finished

/**
  * Created by Tobias Bladh on 2017-09-26.
  */

import scala.io.StdIn
object ABC {
  def main(args: Array[String]): Unit = {
    val xs = StdIn.readLine().split(" ").map(_.toInt)
    val cs = StdIn.readLine().map(_.toInt - 65)
    val sorted = xs.sorted
    cs.foreach(i => print(sorted(i) + " "))
  }
}
