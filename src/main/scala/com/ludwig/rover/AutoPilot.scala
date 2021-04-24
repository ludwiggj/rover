package com.ludwig.rover

class AutoPilot {
  def shortestPath(start: Position, finish: Position, gridTopRight: Position): List[Direction] = {
    val xDiff = finish.x - start.x
    val yDiff = finish.y - start.y

    val xMoves = xDiff match {
      case x if x > 0 => List.fill(x)(Right)
      case x if x < 0 => List.fill(-x)(Left)
      case _ => List()
    }

    val yMoves = yDiff match {
      case y if y > 0 => List.fill(y)(Up)
      case y if y < 0 => List.fill(-y)(Down)
      case _ => List()
    }

    xMoves ++ yMoves

//    if (xDiff == 0 && yDiff == 0) List()
//    else {
//      val xMoves = if (xDiff > 0)  List.fill()
//    }
  }
}
