package finished

/**
  * Created by Tobias Bladh on 2017-09-27.
  */

object AListGame {
  def main(args: Array[String]): Unit = {
    val num = scala.io.StdIn.readLong()
    val primes :Vector[Long] = calcPrimes(math.sqrt(num).toLong)

    var i = 0
    var count = 0
    var rest = num
    while(i < primes.size) {
      if (rest % primes(i) == 0) {
        rest /= primes(i)
        count += 1
        i = 0
      }
      else i += 1
    }
    //If statement below is true the last rest was a prime larger than that of primes, and has to be counted.
    if (primes.nonEmpty && rest > primes.last) count += 1

    print(count)
  }
  def calcPrimes(max: Long): Vector[Long] = {
    var primes = Vector.empty[Long]
    for (i <- 2L to max) {
      var div = 2L
      while (div < math.sqrt(i) && i % div != 0L) {
        if (div == 2L) div += 1 else div += 2L
      }
      if (div > math.sqrt(i)) primes :+= i
    }
    primes
  }
}
