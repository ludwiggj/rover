package com.ludwig.rover

import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MoverTest extends AnyFlatSpec with should.Matchers with BeforeAndAfterAll {
  val fiveByFiveGrid = Position(4, 4)

  "turnClockwise90" should "maintain position and change direction from Left to Down" in {
    object Sut extends Mover
    Sut.move(RotateClockwise90, Position(1,1), Direction.Left, fiveByFiveGrid) should equal(Right(Position(1,1), Direction.Up))
  }

  "turnClockwise90" should "return Left if off the grid" in {
    object Sut extends Mover
    Sut.move(RotateClockwise90, Position(6,1), Direction.Left, fiveByFiveGrid).isLeft should equal(true)
  }
//
//  it should "maintain position and change direction from Down to Right" in {
//    object Sut extends Mover
//    Sut.move(RotateClockwise90, Position(1,1), Up, fiveByFiveGrid) should equal(Position(1,1), Right)
//  }
//
//  it should "maintain position and change direction from Right to Up" in {
//    object Sut extends Mover
//    Sut.move(RotateClockwise90, Position(1,1), Right, fiveByFiveGrid) should equal(Position(1,1), Down)
//  }
//
//  it should "maintain position and change direction from Up to Left" in {
//    object Sut extends Mover
//    Sut.move(RotateClockwise90, Position(1,1), Down, fiveByFiveGrid) should equal(Position(1,1), Left)
//  }
//
//  "turnAnticlockwise90" should "maintain position and change direction from Left to Up" in {
//    object Sut extends Mover
//    Sut.move(RotateAntiClockwise90, Position(1,1), Left, fiveByFiveGrid) should equal(Position(1,1), Down)
//  }
//
//  it should "maintain position and change direction from Up to Right" in {
//    object Sut extends Mover
//    Sut.move(RotateAntiClockwise90, Position(1,1), Down, fiveByFiveGrid) should equal(Position(1,1), Right)
//  }
//
//  it should "maintain position and change direction from Right to Down" in {
//    object Sut extends Mover
//    Sut.move(RotateAntiClockwise90, Position(1,1), Right, fiveByFiveGrid) should equal(Position(1,1), Up)
//  }
//
//  it should "maintain position and change direction from Down to Left" in {
//    object Sut extends Mover
//    Sut.move(RotateAntiClockwise90, Position(1,1), Up, fiveByFiveGrid) should equal(Position(1,1), Left)
//  }
//
//  "move forward" should "move up if facing up" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(1,1), Up, fiveByFiveGrid) should equal(Position(1,2), Up)
//  }
//
//  it should "move left if facing left" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(1,1), Left, fiveByFiveGrid) should equal(Position(0,1), Left)
//  }
//
//  it should "move down if facing down" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(1,1), Down, fiveByFiveGrid) should equal(Position(1,0), Down)
//  }
//
//  it should "move right if facing right" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(1,1), Right, fiveByFiveGrid) should equal(Position(2,1), Right)
//  }
//
//  it should "reappear at bottom if move up at top" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(1,4), Up, fiveByFiveGrid) should equal(Position(1,0), Up)
//  }
//
//  it should "reappear at right if move left at left edge" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(0,2), Left, fiveByFiveGrid) should equal(Position(4,2), Left)
//  }
//
//  it should "reappear at top if move down at bottom" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(1,0), Down, fiveByFiveGrid) should equal(Position(1,4), Down)
//  }
//
//  it should "reappear at left if move right at right edge" in {
//    object Sut extends Mover
//    Sut.move(Forward, Position(4,2), Right, fiveByFiveGrid) should equal(Position(0,2), Right)
//  }
}
