package com.ludwig.rover

sealed trait MoveInstruction
case object Forward extends MoveInstruction
case object RotateClockwise90 extends MoveInstruction
case object RotateAntiClockwise90 extends MoveInstruction

trait Mover {
  private val directions: List[Direction] = List(Up, Left, Down, Right)
  private val numberOfDirections = directions.size

  def move(m: MoveInstruction, p: Position, d: Direction, gridTopRight: Position): (Position, Direction) = {
    m match {
      case RotateClockwise90 =>
        val newDirection = directions((directions.indexOf(d) + 1) % numberOfDirections)
        (p, newDirection)

      case RotateAntiClockwise90 =>
        val currentIndex = directions.indexOf(d)
        val newDirection = directions(if (currentIndex == 0) numberOfDirections - 1 else currentIndex - 1)
        (p, newDirection)

      case Forward =>
        d match {
          case Up =>
            val newY = if (p.y == gridTopRight.y) 0 else p.y + 1
            (p.copy(y = newY), d)
          case Left =>
            val newX = if (p.x == 0) gridTopRight.x else p.x - 1
            (p.copy(x = newX), d)
          case Down =>
            val newY = if (p.y == 0) gridTopRight.y else p.y - 1
            (p.copy(y = newY), d)
          case Right =>
            val newX = if (p.x == gridTopRight.x) 0 else p.x + 1
            (p.copy(x = newX), d)
        }
    }
  }
}
