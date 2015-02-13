package pear.math

import pear.math
import pear.math.Constants._

/**
 *
 * Created by William on 2/12/2015.
 */
case class Line(p1: Vec2, p2: Vec2, infinite: Boolean = false) {
  lazy val midpoint = (p1 + p2) / 2
  lazy val slope = (p1.y - p2.y) / (p1.x - p2.x)
  
  //Based on X
  def lower = if (p1.x <= p2.x) p1 else p2
  def upper = if (p1.x > p2.x) p1 else p2
  
  def intersect(l : Line): Option[Vec2] = {
    val p3 = l.p1
    val p4 = l.p2
    
    val denominator = (p1.x - p2.x) * (p3.y - p4.y) - (p1.y - p2.y) * (p3.x - p4.x)
    
    if (denominator.isZero)
      None
    else {
      val x = (p1.x * p2.y - p1.y * p2.x) * (p3.x - p4.x) - (p1.x - p2.x) * (p3.x * p4.y - p3.y * p4.x)
      val y = (p1.x * p2.y - p1.y * p2.x) * (p3.y - p4.y) - (p1.y - p2.y) * (p3.x * p4.y - p3.y * p4.x)
      
      val intersection = new Vec2(x / denominator, y / denominator)
      
      if ((infinite || (lower.x <= intersection.x && intersection.x <= upper.x)) && 
          (l.infinite || (l.lower.x <= intersection.x && intersection.x <= l.upper.x)))
        Some(intersection)
      else None
    }
  }
  
  
  
}
