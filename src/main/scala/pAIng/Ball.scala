package pAIng

class Ball {
  var x = 10
  var y = 10
  var xspeed = 1
  var yspeed = 1

  def getX() = {
    x
  }

  def getY() = {
    y
  }

  def update() {
    x += xspeed
    y += yspeed
  }

  def setSpeed(newXSpeed : Int, newYSpeed : Int) {
    xspeed = newXSpeed
    yspeed = newYSpeed
  }

  def reflectYSpeed() {
    yspeed *= -1
  }
}
