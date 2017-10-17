/**
  * Created by Tobias Bladh on 2017-10-10.
  */
object nnnnn {
  def main(args: Array[String]): Unit = {
      for (i <- 0 to 100000) {
        println(s"$i: ${encrypt(i)} - len: ${i.toString.length} vs ${encrypt(i).toString.length}")
      }
  }

  def decrypt(L : BigInt, length : Double): Long = {
???
  }

  def encrypt(n : Int) : Int = {
    n.toString.length * n
  }
}
