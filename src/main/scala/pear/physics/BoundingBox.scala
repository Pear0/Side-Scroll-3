package pear.physics

import pear.math.Vec2

/**
 *
 * Created by William on 2/12/2015.
 */
trait BoundingBox {

  def isPointInside(v: Vec2): Boolean

  /**
   *  Returns a list of points in clockwise rotation that approximates the shape
   * @return a list of Vec2
   */
  def getPoints: List[Vec2]

}
