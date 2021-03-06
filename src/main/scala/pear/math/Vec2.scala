package pear.math

import Constants._

/**
 * 
 * Created by William on 2/12/2015.
 */
object Vec2 {
  val UP    = new Vec2( 0, -1)
  val DOWN  = new Vec2( 0,  1)
  val RIGHT = new Vec2( 1,  0)
  val LEFT  = new Vec2(-1,  0)
}

case class Vec2(x: Double = 0, y: Double = 0) {
  lazy val length = Math.sqrt(x * x + y * y)
  lazy val normalized = this / length

  def dot (v: Vec2) = {
    val a = normalized
    val b = v.normalized
    new Vec2(a.x * a.y, b.x * b.y)
  }
  
  def isOnLine(l: Line) =
    (Line(l.p1, this).slope is Line(this, l.p2).slope) && 
      (l.infinite || (l.lower.x <= x && x <= l.upper.x))
  
  def rotate(deg: Double) = {
    val rad = Math.toRadians(deg)
    val sin = Math.sin(rad)
    val cos = Math.cos(rad)
    new Vec2(cos * x + sin * y, cos * y - sin * x)
  }
  
  //math ops
  def + (v: Vec2) = new Vec2(x + v.x, y + v.y)
  def + (a: Double, b: Double) = new Vec2(x + a, x + b)
  def + (a: Double) = new Vec2(x + a, y + a)

  def - (v: Vec2) = new Vec2(x - v.x, y - v.y)
  def - (a: Double, b: Double) = new Vec2(x - a, x - b)
  def - (a: Double) = new Vec2(x - a, y - a)

  def * (v: Vec2) = new Vec2(x * v.x, y * v.y)
  def * (a: Double, b: Double) = new Vec2(x * a, x * b)
  def * (a: Double) = new Vec2(x * a, y * a)

  def / (v: Vec2) = new Vec2(x / v.x, y / v.y)
  def / (a: Double, b: Double) = new Vec2(x / a, x / b)
  def / (a: Double) = new Vec2(x / a, y / a)

}
