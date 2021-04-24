package com.ludwig.rover

sealed trait MoveInstruction
case object Forward extends MoveInstruction
case object RotateClockwise90 extends MoveInstruction
case object RotateAntiClockwise90 extends MoveInstruction

trait Mover {
  private val directions: List[Direction] = List(Up, Left, Down, Right)
  private val numberOfDirections = directions.size

  def move(m: MoveInstruction, p: Position, d: Direction): (Position, Direction) = {
    m match {
      case RotateClockwise90 =>
        val newDirection = directions((directions.indexOf(d) + 1) % numberOfDirections)
        (p, newDirection)

      case RotateAntiClockwise90 =>
        val currentIndex = directions.indexOf(d)
        val newDirection = directions(if (currentIndex == 0) numberOfDirections - 1 else currentIndex - 1)
        (p, newDirection)

      case _ => (Position(0,0), Up)
    }
  }
}
