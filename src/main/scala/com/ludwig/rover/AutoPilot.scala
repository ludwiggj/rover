package com.ludwig.rover

class AutoPilot {
  def shortestPath(start: Position, finish: Position, gridTopRight: Position): List[Direction] = {
    val xDiff = finish.x - start.x

    val xDiffMoveOffGrid =
      if (start.x < finish.x)
        -(start.x + (gridTopRight.x - finish.x) + 1)
      else if (start.x > finish.x)
        finish.x + (gridTopRight.x - start.x) + 1
      else 0

    val xDiffShortest = if (Math.abs(xDiffMoveOffGrid) < Math.abs(xDiff)) xDiffMoveOffGrid else xDiff

    val yDiff = finish.y - start.y

    val xMoves = xDiffShortest match {
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
  }
}
