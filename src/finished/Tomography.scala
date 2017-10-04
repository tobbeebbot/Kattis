/**
  * Created by Tobias Bladh on 2017-10-04.
  */
import scala.io.StdIn.readLine
import collection.mutable

object Tomography {
  //Så länge det finns radnummer kvar (ev. i längsta sida JAA)
    //ta största talet r och subtrahera från r st kolumnnummer
    //tar det slut gick det ej
  //När radnummerna är slut (och cols är tom) vet vi att det gick.

  //prioritetskö!!

  //rad och col nummer ska ligga sorterade i varsin hasmap
  //tar ut begärt antal största, subtraherar, lägger in igen om skiljda från 0.
  def readNums(): Array[Int] = readLine().split(" ").map(_.toInt)

  def main(args: Array[String]): Unit = {
    //r = nr of rows, c = nr of cols
    val Array(r,c) = readNums()

    //Init rows and cols
    val rows = mutable.PriorityQueue[Int]()
    for (i <- readNums() if i > 0) rows.enqueue(i)
    val cols = mutable.PriorityQueue[Int]()
    for (i <- readNums() if i > 0) cols.enqueue(i)

    //Find siutable order
    val (large, small) = if (r >= c) (rows, cols) else (cols, rows)

    var failed = false
    while(large.nonEmpty && !failed) {
      val l = large.dequeue()
      if (small.length >= l) {
        val ss = for (i <- 1 to l) yield small.dequeue()

        for (i <- ss if i > 1) small.enqueue(i - 1)
      } else {
        failed = true
      }
    }
    if (failed || small.nonEmpty)
      println("No")
    else
      println("Yes")
  }



}
