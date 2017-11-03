package pAIng

import org.scalatest.{BeforeAndAfter,FunSuite}
import org.scalatest.junit.JUnitRunner
import org.scalamock.scalatest.MockFactory

class PaddleTest extends FunSuite with BeforeAndAfter with MockFactory {
  var p : Paddle = _

  before {
    p = new Paddle()
  }

  test("Paddle position is 0 at the beginning") {
    assert(p.getPosition() == 0)
  }

  test("Paddle position moves amount passed") {
    p.move(10)

    assert(p.getPosition() == 10)
  }

  test("Collision at the start at 0 should happen") {
    assert(p.isColliding(0))
  }

  test("Default paddle should collide at 1") {
    assert(p.isColliding(1))
  }

  test("Default paddle should not collide at 2") {
    assert(!p.isColliding(2))
  }

  test("Paddle cannot be size 2") {
    assertThrows[Exception] {
      p.setSize(0)
    }
  }

  test("Setting size greater than 1 is valid") {
    p.setSize(1)

    assert(p.getSize() == 1)
  }

  test("Paddle of size 2 should collide at 2") {
    p.setSize(2)

    assert(p.isColliding(2))
  }

  test("Paddle should not collide at 0 after moving") {
    p.move(1)

    assert(!p.isColliding(0))
  }
}
