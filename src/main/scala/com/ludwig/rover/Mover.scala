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

      case _ => (Position(0,0), Up)
    }
  }
}
