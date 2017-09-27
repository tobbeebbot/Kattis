/**
  * Created by Tobias Bladh on 2017-09-27.
  */
import scala.io.StdIn

object AlmostPerfect {
  def main(args: Array[String]): Unit = {
    var cont = true
    while(cont) {
      val s = StdIn.readLine()
      if (s == null) cont = false
      else {
        val n = s.toLong
        println("find: " + findDivs(1,n))
        println("proper: " + properDivs(n))
        println("primes: " + AnIndustrialSpy.calcPrimes(math.sqrt(n).toInt).toVector.sorted)
        println(n + " " + determine(n))
      }
    }
  }

  def determine(n: Long): String = {
    val divs = properDivs(n)
    val sum = divs.sum
    if (sum < n - 2 || sum > n + 2) "not perfect"
    else if (sum == n) "perfect"
    else "almost perfect"
  }
  //Too slow!!
  def properDivs(n: Long): Seq[Long] = for (i <- 1L to n / 2 if n % i == 0) yield i

  def findDivs(start: Long = 1, end: Long) : Seq[Long] = {
    if (start >= end) Seq.empty[Long]
    else {
      var i = start
      while (i < end && end % i != 0) {
        i += 1
      }
      i +: findDivs(i + 1, end)
    }
  }
}
