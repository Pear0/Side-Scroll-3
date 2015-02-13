package pear.math

/**
 * 0 1 2  1 0 x 
 * 3 4 5  0 1 y
 * 6 7 8  0 0 1
 *
 * Created by William on 2/12/2015.
 */
object Mat3 {
  
  def identity = new Mat3(Array[Double](
    1, 0, 0,
    0, 1, 0,
    0, 0, 1
  ))

  def translate(x: Double, y: Double) = new Mat3(Array[Double](
    1, 0, x,
    0, 1, y,
    0, 0, 1
  ))

  def scale(x: Double, y: Double): Mat3 = new Mat3(Array[Double](
    x, 0, 0,
    0, y, 0,
    0, 0, 1
  ))
  
  def scale(x: Double): Mat3 = scale(x, x)
  
  def rotate(rotation: Double) = {
    val rad = Math.toRadians(rotation)
    val sin = Math.sin(rad)
    val cos = Math.cos(rad)
    new Mat3(Array[Double](
       cos, sin, 0,
      -sin, cos, 0,
         0,   0, 1
    ))
  }
  
}

class Mat3(private val array: Array[Double] = new Array[Double](9)) {
  assert(array.length == 9, s"$array must have a length of 9")
  
  def * (v: Vec2) = new Vec2(
    v.x * array(0) + v.y * array(1) + array(2),
    v.x * array(3) + v.y * array(4) + array(5)
  )
  
  def * (that: Mat3) = {
    val n = new Array[Double](9)
    
    for (x <- 0 until 3; y <- 0 until 3; i <- 0 until 3)
      n(3 * y + x) += this.array(3 * y + i) * that.array(3 * i + x)
    
    new Mat3(n)
  }
  
  def copy() = new Mat3(array)
}
