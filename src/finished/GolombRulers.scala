package finished

/**
  * Created by Tobias Bladh on 2017-10-10.
  */
import scala.io.StdIn.readLine

object GolombRulers {
  def main(args: Array[String]): Unit = {
      var input = readLine()
      do {
        println(inspect(input.split(" ")))

        input = readLine()
      } while (input != null)
  }

  val found : Array[Boolean] = Array.ofDim(2001)

  def inspect(ss : Array[String]) : String = {
    val nums : Array[Int] = Array.ofDim(ss.length)
    var largest = 0

    for (i <- ss.indices) {
      nums(i) = ss(i).toInt

      if (nums(i) > largest) largest = nums(i)

      for (j <- 0 until i) {
        val dif = math.abs(nums(j) - nums(i))
        if (found(dif)) return "not a ruler"
        else found(dif) = true
      }
    }

    val missing = for (i <- 1 to largest if !found(i)) yield i
    if (missing.nonEmpty) "missing " + missing.mkString(" ")
    else "perfect"
  }
}
