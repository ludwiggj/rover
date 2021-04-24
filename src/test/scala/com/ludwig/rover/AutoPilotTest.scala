package com.ludwig.rover

import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class AutoPilotTest extends AnyFlatSpec with should.Matchers with BeforeAndAfterAll {
  val fiveByFiveGrid = Position(4, 4)

  "shortestPath" should "be empty if already at target" in {
    new AutoPilot().shortestPath(Position(3,3), Position(3,3), fiveByFiveGrid) should equal(List())
  }

  it should "be left if target is on left" in {
    new AutoPilot().shortestPath(Position(4,3), Position(3,3), fiveByFiveGrid) should equal(List(Left))
  }

  it should "be left and up if target is north west" in {
    new AutoPilot().shortestPath(Position(4,0), Position(3,2), fiveByFiveGrid) should equal(List(Left, Up, Up))
  }

  it should "move off grid to left if that is nearest path" in {
    new AutoPilot().shortestPath(Position(1,2), Position(4,2), fiveByFiveGrid) should equal(List(Left, Left))
  }

  it should "move off grid to right if that is nearest path" in {
    new AutoPilot().shortestPath(Position(4,2), Position(1,2), fiveByFiveGrid) should equal(List(Right, Right))
  }

  it should "move off grid upwards if that is nearest path" in {
    new AutoPilot().shortestPath(Position(1,4), Position(1,0), fiveByFiveGrid) should equal(List(Up))
  }

  it should "move off grid downwards if that is nearest path" in {
    new AutoPilot().shortestPath(Position(1,0), Position(1,4), fiveByFiveGrid) should equal(List(Down))
  }

  it should "move off grid in one direction if that is nearest path" in {
    new AutoPilot().shortestPath(Position(1,4), Position(2,0), fiveByFiveGrid) should equal(List(Right, Up))
  }

  it should "move off grid in two directions if that is nearest path" in {
    new AutoPilot().shortestPath(Position(4,0), Position(0,4), fiveByFiveGrid) should equal(List(Right, Down))
  }
}