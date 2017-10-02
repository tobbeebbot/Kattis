/**
  * Created by Tobias Bladh on 2017-10-02.
  */
import scala.io.StdIn

object TextEncryption {
  def main(args: Array[String]): Unit = {
    while(true) {
      val n = StdIn.readInt()
      if (n == 0) System.exit(0)
      else {
        val s = StdIn.readLine()
        val rm = s.replaceAll(" ", "").toUpperCase()
        val enc = encrypt(rm, n)
        println(enc)
        //println(decrypt(enc, n))
      }
    }
  }

  def encrypt(s: String, n: Int): String = {
    val a: Array[Char] = Array.ofDim(s.length)
    var i = 0
    var k = 0
    for (c <- s) {
      a(i) = c
      i += n
      if (i >= s.length) {
        k += 1
        i = k
      }
    }
    a.mkString
  }

  def decrypt(s: String, n: Int): String = {
    var count = 0
    var k = 0
    val sb = new StringBuilder()
    while (count < s.length) {
      for (i <- k until s.length by n) {
        count += 1
        sb.append(s(i))
      }
      k += 1
    }
    sb.toString()
  }
}
