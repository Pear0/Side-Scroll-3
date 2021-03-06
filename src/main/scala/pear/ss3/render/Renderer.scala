package pear.ss3.render

import org.scalajs.dom.ext.Color
import org.scalajs.dom.raw.HTMLImageElement
import pear.math.Vec2

import scala.collection.immutable.Queue

//import org.scalajs.dom.raw.{CanvasRenderingContext2D => C2D}

/**
 *
 * Created by William on 2/13/2015.
 */
object Renderer {
  
  private[render] var queuedDraws = Queue[(Renderer) => Unit]()
  
  def queueDraw(f: (Renderer) => Unit): Unit = queuedDraws = queuedDraws :+ f
  
  
  
  
}

trait Renderer {
  import Renderer._
  
  def context(f: => Unit): Unit = {
    pushContext()
    f
    popContext()
  }
  
  def rotate(deg: Double): Unit
  
  def scale(x: Double, y: Double): Unit
  
  def translate(x: Double, y: Double): Unit
  
  def pushContext(): Unit
  
  def popContext(): Unit
  
  def clear(): Unit
  
  def completeQueue(): Unit = {
    for (f <- queuedDraws)
      f(this)
  }
  
  def color: Color
  def color_=(c: Color): Unit
  
  def drawLine(p1: Vec2, p2: Vec2, c: Color = color): Unit
  
  def drawImage(img: HTMLImageElement, location: Vec2, dimensions: Vec2): Unit
  
  def drawPolygon(l: IndexedSeq[Vec2], c: Color = color): Unit = {
    var b = l.length - 1
    for (a <- 0 until l.length) {
      drawLine(l(b), l(a), c)
      b = a
    }
  }
  
  def drawVec2(vec: Vec2, c: Color = Color("#00FF00"), offX: Int = 0, offY: Int = 0): Unit = {
    val p1 = Vec2(offX, offY)
    val p2 = p1 + vec
    drawLine(p1, p2, color)
  }
  
  def width: Int
  def height: Int
  
}