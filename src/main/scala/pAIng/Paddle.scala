package pAIng

class Paddle {
  var position = 0
  var size = 1

  def move(dist : Int) {
    position += dist
  }

  def getPosition() = {
    position
  }

  def isColliding(x : Int) = {
    x <= size && x >= position
  }

  def setSize(x : Int) {
    if(x == 0)
      throw new Exception
    size = x
  }

  def getSize() = {
    1
  }
}

object Direction extends Enumeration{
  type Direction = Value
  val UP, NEUTRAL, DOWN = Value
}

class PaddleController {
  var paddle : Paddle = _
  var direction = Direction.NEUTRAL
  var speed = 10

  def setPaddle(p : Paddle) {
    paddle = p
  }

  def setDirection(dir : Direction.Value) {
    direction = dir
  }

  def update() {
    direction match {
      case Direction.DOWN => paddle.move(speed)
      case Direction.UP => paddle.move(-speed)
      case _ => {}
    }
  }

  def setSpeed(sp : Int) {
    speed = sp
  }
}
