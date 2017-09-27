package finished

import scala.io.StdIn

object Secret_Message {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to StdIn.readInt()) {
      println(encrypt(StdIn.readLine()))
    }
  }

  lazy val squares = (1 to 100).map(x => x*x)

  def findM(L: Int): Int = {
    squares.find(M => M >= L).get
  }

  def encrypt(s: String): String = {
    val L = s.length
    val M = findM(L)
    val K = math.sqrt(M).toInt
    val matrix = Array.ofDim[Char](K, K)




    def fillMatrix() = {
      for (i <- 0 until M) {
        matrix(i % K)(i / K) = if (i < s.length) s(i) else '*'
      }
    }

    def readMatrix() = {
      val s = for (i <- 0 until M) yield {
        matrix(i / K)(K - (i % K) - 1) match {
          case '*'  => ""
          case c    => c
        }
      }
      s.mkString
    }

    fillMatrix()
    readMatrix()
  }
}
