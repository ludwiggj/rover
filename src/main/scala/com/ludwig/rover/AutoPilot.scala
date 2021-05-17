package com.ludwig.rover

class AutoPilot {
  def shortestPath(start: Position, finish: Position, gridTopRight: Position): List[Direction] = {
    val xDiffShortest = shortestDistance(start.x, finish.x, gridTopRight.x)

    val yDiffShortest: Int = shortestDistance(start.y, finish.y, gridTopRight.y)

    val xMoves = xDiffShortest match {
      case x if x > 0 => List.fill(x)(Direction.Right)
      case x if x < 0 => List.fill(-x)(Direction.Left)
      case _ => List()
    }

    val yMoves = yDiffShortest match {
      case y if y > 0 => List.fill(y)(Direction.Up)
      case y if y < 0 => List.fill(-y)(Direction.Down)
      case _ => List()
    }

    xMoves ++ yMoves
  }

  private def shortestDistance(start: Int, finish: Int, gridTopRight: Int): Int = {
    val diff = finish - start

    val diffMoveOffGrid =
      if (start < finish)
        -(start + (gridTopRight - finish) + 1)
      else if (start > finish)
        finish + (gridTopRight - start) + 1
      else 0

    if (Math.abs(diffMoveOffGrid) < Math.abs(diff)) diffMoveOffGrid else diff
  }
}
