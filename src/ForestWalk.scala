/**
  * Created by Tobias Bladh on 2017-10-13.
  */
import scala.io.StdIn

object ForestWalk {
  def main(args: Array[String]): Unit = {
    var continue = true
    while(continue) {
      StdIn.readLine().split(" ") match {
        case Array(is, ps) => {
          val paths = createNetwork(is.toInt, ps.toInt)
          println(calculate(paths))
        }
        case _ => continue = false
      }
    }
  }

  def createNetwork(is :Int, ps: Int) : Array[Intersection] = {
    val paths = Array.fill(is)(new Intersection)
    for (i <- 1 to ps) {
      val Array(i1, i2, dis) = StdIn.readLine().split(" ").map(_.toInt)
      addConnection(i1, i2, dis)
    }

    def addConnection(i1 : Int , i2:Int, dis: Int) = {
      paths(i1 - 1).addConnection(paths(i2), dis)
      paths(i2 - 1).addConnection(paths(i1), dis)
    }

    paths
  }

  def calculate(paths : Array[Intersection]) :String = {
???
  }

  def calculateDistance() = ???
}

class Intersection() {
  val ab = scala.collection.mutable.MutableList.empty[(Intersection, Int)]
  def addConnection(i: Intersection, d: Int) = {
   ab += (i -> d)
  }
}

