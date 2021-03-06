package pAIng

import org.scalatest.{BeforeAndAfter,FunSuite}
import org.scalatest.junit.JUnitRunner
import org.scalamock.scalatest.MockFactory

class BallTest extends FunSuite with BeforeAndAfter with MockFactory {
  var b : Ball = _

  before {
    b = new Ball()
  }

  def assertPosition(x : Int, y : Int) {
    assert(b.getX() == x)
    assert(b.getY() == y)
  }

  test("Ball initially is at (10,10)") {
    assertPosition(10,10)
  }

  test("Ball updated once will be at (11,11)") {
    b.update()

    assertPosition(11,11)
  }

  test("Set magnitude to sqrt of 8 will double the distance travelled") {
    b.setSpeed(2,2)
    b.update()

    assertPosition(12,12)
  }

  test("Reflecting y speed will make the ball go up instead of down") {
    b.reflectYSpeed()
    b.update()

    assertPosition(11,9)
  }
}
