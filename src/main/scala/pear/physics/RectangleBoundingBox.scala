package pear.physics

import pear.math.{Mat3, Vec2}

/**
 *
 * Created by William on 2/12/2015.
 */
case class RectangleBoundingBox(x: Double, y: Double, width: Double, height: Double, r: Double) extends BoundingBox{

  override def getPoints: List[Vec2] = {
    val hw = width / 2
    val hh = height / 2
    val mat = Mat3.translate(x, y) * Mat3.rotate(r)
    List(Vec2(-hw, -hh), Vec2(hw, -hh), Vec2(hw, hh), Vec2(-hw, hh)).map(mat * _)
  }
  
}
