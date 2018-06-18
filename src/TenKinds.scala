import scala.io.StdIn

object TenKinds {
  def main(args: Array[String]): Unit = {

    val Array(rows,cols) = StdIn.readLine().split(" ").map(_.toInt)


    val matrix : Array[String] = Array.ofDim(rows)
    for (i <- 0 until rows) {
      matrix(i) = StdIn.readLine()
    }

    val n = StdIn.readInt()
    val cordPairs = for (i <- 0 until n) yield {
      val line = StdIn.readLine().split(" ").map(_.toInt)
      ((line(0), line(1)), (line(2), line(3)))
    }

    val queue = scala.collection.mutable.Queue((0,0))
    val identities : Array[Array[Int]] = Array.ofDim(rows, cols)

    var counter = 1
    while(queue.nonEmpty) {
      val (x,y) = queue.dequeue()
      bfs(x,y,matrix(y)(x))
      counter += 1
    }

    for (((x1,y1),(x2,y2)) <- cordPairs) {
      //identities.foreach(_.foreach(println))
      if (identities(x1 - 1)(y1 - 1) == identities(x2 - 1)(y2 - 1)) {
        if(matrix (x1 - 1)(y1 - 1) == '1') println("decimal")
        else println("binary")
      } else println("neither")
    }

    def bfs(inX: Int, inY: Int, id: Int): Unit = {
      val neighboursQueue = scala.collection.mutable.Queue((inX,inY))
      while (neighboursQueue.nonEmpty) {
        val (x,y) = neighboursQueue.dequeue()
        if (identities(y)(x) == 0) {
          if (matrix(y)(x) != id) {
            queue.enqueue((x, y))
          } else {
            identities(y)(x) = counter

            val neigh = neigbours(x, y)
            neighboursQueue.enqueue(neigh: _*)
          }
        }
      }
    }

    def neigbours(x : Int, y: Int) : List[(Int,Int)] = {
      var result = List.empty[(Int, Int)]
      if (x > 0) result = (x - 1, y) +: result
      if (y > 0) result = (x, y - 1) +: result
      if (x + 1 < cols) result = (x + 1, y) +: result
      if (y + 1 < rows) result = (x, y + 1) +: result
      /*def withinBounds(x : Int,y : Int) : Boolean = {
        x >= 0 && x < cols && y >= 0 && y < rows
      }*/

      /*List((x, y -1), (x, y + 1), (x - 1, y), (x + 1, y))
        . filter(c => withinBounds(c._1, c._2))*/

      result
    }
  }


}
