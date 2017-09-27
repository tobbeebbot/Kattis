package finished

/**
  * Created by Tobias Bladh on 2017-09-27.
  */
import scala.io.StdIn

object AnagramCounting {
  def main(args: Array[String]): Unit = {
    while(true) {
      val s = StdIn.readLine()
      if (s == null) System.exit(0) //fan för denna uppgift med sitt nullande
      else println(combinations(s))
    }
  }

  def combinations(s: String): BigInt = {
    val n = s.length
    val groups = s.groupBy(x => x)
    val divs = groups.map(_._2.length)

    var amount = fac(n)
    for (div <- divs) amount /= fac(div)
    amount
  }

  def fac(n : BigInt) : BigInt = {
    if (n <= 1) 1
    else n * fac(n-1)
  }
}
