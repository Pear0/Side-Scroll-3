package pear.physics

import pear.math.Vec2

/**
 *
 * Created by William on 2/12/2015.
 */
trait BoundingBox {
  /**
   * Checks if a point is within this bounding box
   * This is a straight port of http://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html
   * @param v the Vec2 point
   * @return whether or not the Vec2 is within the bounding box
   */
  def isPointInside(v: Vec2): Boolean = {
    val p = getPoints
    
    val num = p.length
    var j = num - 1
    var c = false
    for (i <- 0 until num)
      if  ((p(i).y > v.y) != (p(j).y > v.y) && (v.x < (p(j).x - p(i).x) * (v.y - p(i).y) / (p(j).y - p(i).y) + p(i).x)) {
        c = !c
        j = i
      }
    c
  }

  /**
   *  Returns a list of points in clockwise rotation that approximates the shape
   * @return a list of Vec2
   */
  def getPoints: List[Vec2]

}
