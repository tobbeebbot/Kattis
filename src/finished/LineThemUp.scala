package finished

/**
  * Created by Tobiab Bladh on 2017-09-26.
  */
import scala.io.StdIn

object LineThemUp {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    var prev = StdIn.readLine()

    var continue = true

    var order = 0

    // 0 neither, 1 increasing, 2 decreasing
    def increasing() = {
      if (order == 0 || order == 1) order = 1
      else {
        order = 0
        continue = false
      }
    }

    def decreasing() = {
      if (order == 0 || order == 2) order = 2
      else {
        order = 0
        continue = false
      }
    }

    var i = 1
    while (i < n && continue) {
      val curr = StdIn.readLine()
      if (prev < curr)
        increasing()
      else decreasing()
      prev = curr
      i += 1
    }
    if (order == 1) println("INCREASING")
    else if (order == 2) print("DECREASING")
    else print("NEITHER")
  }
}
