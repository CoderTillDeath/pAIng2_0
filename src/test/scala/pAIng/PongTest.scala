package pAIng

import org.scalatest.{BeforeAndAfter,FunSuite}
import org.scalatest.junit.JUnitRunner
import org.scalamock.scalatest.MockFactory

class PongTest extends FunSuite with BeforeAndAfter with MockFactory {
  var p : Pong = _;

  test("Canary test") {
    assert(true)
  }

  before {
    p = new Pong();
  }

  test("Player 1 paddle should be at position 0 in the beginning") {
    assert(p.get_P1_position() == 0)
  }

  test("Player 1 moving paddle down should affect his position") {
    p.move_P1_down()
    p.update()

    assert(p.get_P1_position() == 1)
  }
}
