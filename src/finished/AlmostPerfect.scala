package finished

/**
  * Created by Tobias Bladh on 2017-09-27.
  */
import scala.collection.mutable
import scala.io.StdIn

object AlmostPerfect {
  def main(args: Array[String]): Unit = {
    var cont = true
    while(cont) {
      val s = StdIn.readLine()
      if (s == null) cont = false
      else {
        val n = s.toLong
        println(n + " " + determine(n))
      }
    }
  }

  def determine(n: Long): String = {
    val divs = findDivs(n)
    val sum = divs.sum
    if (sum == n)                           "perfect"
    else if (sum <= n + 2 && sum >= n - 2)  "almost perfect"
    else                                    "not perfect"
  }
  //Too slow!!
  //def properDivs(n: Long): Seq[Long] = for (i <- 1L to n if n % i == 0) yield i

  def findDivs(n: Long) : Set[Long] = {
    val nums: mutable.Set[Long] = mutable.Set(1)
    var i = 2
    var cont = true
    val limit = math.sqrt(n).toInt + 1
    while(i < limit && cont) {
      if (n % i == 0) {
        if (nums.contains(i)) cont = false
        nums.add(i)
        nums.add(n / i)

      }
      i += 1
    }
    nums.toSet
  }
}
