package com.ludwig.rover

sealed trait MoveInstruction
case object Forward extends MoveInstruction
case object RotateClockwise90 extends MoveInstruction
case object RotateAntiClockwise90 extends MoveInstruction

trait Mover {

  def rotateClockwise(d: Direction): Direction = d match {
    case Direction.Up => Direction.Right
    case Direction.Right => Direction.Down
    case Direction.Down => Direction.Left
    case Direction.Left => Direction.Up
  }

  def rotateAntiClockwise(d: Direction): Direction = d match {
    case Direction.Up => Direction.Left
    case Direction.Left => Direction.Down
    case Direction.Down => Direction.Right
    case Direction.Right => Direction.Up
  }

  def offGrid(p: Position, gridTopRight: Position): Boolean =
    (p.x > gridTopRight.x) || (p.y > gridTopRight.y)


  def move(m: MoveInstruction, p: Position, d: Direction, gridTopRight: Position): Either[Exception, (Position, Direction)] = {
    if (offGrid(p, gridTopRight)) {
      Left(new IllegalArgumentException(s"Position $p is outside grid $gridTopRight"))
    }
    else {
      m match {
        case RotateClockwise90 =>
          Right((p, rotateClockwise(d)))

        case RotateAntiClockwise90 =>
          Right((p, rotateAntiClockwise(d)))

        case Forward =>
          d match {
            case Direction.Up =>
              val newY = if (p.y == gridTopRight.y) 0 else p.y + 1
              Right((p.copy(y = newY), d))
            case Direction.Left =>
              val newX = if (p.x == 0) gridTopRight.x else p.x - 1
              Right((p.copy(x = newX), d))
            case Direction.Down =>
              val newY = if (p.y == 0) gridTopRight.y else p.y - 1
              Right((p.copy(y = newY), d))
            case Direction.Right =>
              val newX = if (p.x == gridTopRight.x) 0 else p.x + 1
              Right((p.copy(x = newX), d))
          }
      }
    }
  }
}
