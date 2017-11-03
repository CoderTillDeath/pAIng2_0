package pAIng

class Pong {
  var P1Y = 0
  var down = false

  def get_P1_position() = {
    P1Y
  }

  def move_P1_down(){
    var down = true
  }

  def update() {
    P1Y += 1
  }
}
