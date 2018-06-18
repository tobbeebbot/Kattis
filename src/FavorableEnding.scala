import scala.io.StdIn
import scala.collection.mutable

object FavorableEnding {
  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    for (i <- 1 to t) {

      val nrOfPages = StdIn.readInt()
      val graph = mutable.Map.empty[Int, Array[Int]]
      val values = mutable.Map.empty[Int, Long]

      for (i <- 1 to nrOfPages) {
        val line = StdIn.readLine().split(" ")
        if (line.size > 2) {
          val vals = line.map(_.toInt)
          graph.update(vals.head, vals.tail)
        }
        else {
          values.update(line.head.toInt, line(1) match {
            case "favourably" => 1
            case _            => 0
          })
        }
      }

      println(distEndingsFrom(1))

      def distEndingsFrom(index: Int): Long = {
        if (values.contains(index)) {
          values(index)
        } else {
          val sum = graph(index).map(distEndingsFrom).sum
          values.update(index, sum)
          sum
        }
      }
    }
  }
}
