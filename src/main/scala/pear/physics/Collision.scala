package pear.physics

import pear.math.{Line, Vec2}

/**
 *
 * Created by William on 2/12/2015.
 */
object Collision {
  
  object Naive extends Collision{
    
    override def check(a: BoundingBox, b: BoundingBox): Option[List[Vec2]] = {
      val aPoints = a.getPoints
      val bPoints = b.getPoints
      
      val aLines = for (i <- 0 until aPoints.length - 1) yield Line(aPoints(i), aPoints(i + 1))
      val bLines = for (i <- 0 until bPoints.length - 1) yield Line(bPoints(i), bPoints(i + 1))

      var intersections = List[Option[Vec2]]()
      for (aLine <- aLines; bLine <- bLines)
        intersections = intersections ::: List(aLine intersect bLine)
      
      val valid = intersections.filter(_.isDefined).map(_.asInstanceOf[Some[Vec2]].x)
      if (valid.length == 0) None
      else Some(valid)
    }

  }

}

trait Collision {

  /**
   * Checks for a collision between two bounding boxes using an implementation.
   * @param a the first collision box
   * @param b the second collision box
   * @return Either None() which means no collision or
   *         Some(List(Vec2)) which means that there are collisions and they are at the list of vec2 coordinates.
   */
  def check(a: BoundingBox, b: BoundingBox): Option[List[Vec2]]
  
}
