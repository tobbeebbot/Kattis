/**
  * Created by Tobias Bladh on 2017-09-26.
  */

//NOT FINISHEED!!
import scala.io.StdIn

object AnIndustrialSpy {
  def main(args: Array[String]): Unit = {
    //(1 to StdIn.readInt()).foreach(i => countPrimes(StdIn.readLine()))
    println(calcPrimes(20))
  }

  lazy val primes: Set[Int] = calcPrimes(10000)
  def countPrimes(s: String): Unit = {

    val nums: Set[Int] = calcNums(s)
    var count = 0
    for (i <- nums)
      if (primes.contains(i))
        count += 1
    println(count)
  }

  def calcPrimes(max: Int): Set[Int] = {
    var primes: Set[Int] = Set.empty
    for (i <- 2 to max by 1) {
      var div = 2
      while (div < math.sqrt(i) && i % div != 0) {
        if (div == 2) div += 1 else div += 2
      }
      if (div > math.sqrt(i)) primes += i
    }
    primes
  }

  def calcNums(s : String): Set[Int] = {
    ???
  }
}
