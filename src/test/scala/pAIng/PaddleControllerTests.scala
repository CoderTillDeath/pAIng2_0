package pAIng

import org.scalatest.{BeforeAndAfter,FunSuite}
import org.scalatest.junit.JUnitRunner
import org.scalamock.scalatest.MockFactory

class PaddleControllerTest extends FunSuite with BeforeAndAfter with MockFactory {
  var paddle : Paddle = _
  var padcontrol : PaddleController = _

  before {
    paddle = new Paddle()
    padcontrol = new PaddleController()
    padcontrol.setPaddle(paddle)
  }

  test("Setting the direction of the paddle does nothing") {
    padcontrol.setDirection(Direction.UP)

    assert(paddle.getPosition == 0)
  }

  test("Setting the direction and then updating does change the position") {
    padcontrol.setDirection(Direction.DOWN)
    padcontrol.update()

    assert(paddle.getPosition == 10)
  }

  test("Moving the paddle is done at a set speed") {
    padcontrol.setSpeed(5)
    padcontrol.setDirection(Direction.DOWN)
    padcontrol.update()

    assert(paddle.getPosition == 5)
  }

  test("Updating the paddle while neutral should do nothing") {
    padcontrol.update()

    assert(paddle.getPosition() == 0)
  }

  test("Moving the paddle down, then up, should reset the position") {
    padcontrol.setDirection(Direction.DOWN)
    padcontrol.update()
    padcontrol.setDirection(Direction.UP)
    padcontrol.update()

    assert(paddle.getPosition() == 0)
  }
}
