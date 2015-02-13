package pear.math

/**
 *
 * Created by William on 2/12/2015.
 */
object Constants {
  
  val epsilon = 1e-5
  val PI = Math.PI
  val E = Math.E
  
  implicit class SuperDouble(x: Double) {
    def isZero = Math.abs(x) < epsilon
    def is (y: Double) = Math.abs(x - y) < epsilon
    def isnt (y: Double) = !is(y)
  }
  
}
