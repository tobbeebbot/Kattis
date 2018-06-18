import scala.collection.mutable
import scala.collection.mutable.PriorityQueue

object ShortestPath1 {
  val graph = Array
}

class Node(index : Int) {
  val neighs : mutable.PriorityQueue[(Int, Int)] = mutable.PriorityQueue.empty

  def add(index: Int, weight: Int) : Unit = neighs.enqueue((weight,index))


}
