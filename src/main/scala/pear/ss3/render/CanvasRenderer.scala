package pear.ss3.render

import org.scalajs.dom.ext.Color
import org.scalajs.dom.raw.{CanvasRenderingContext2D => C2D, HTMLImageElement}
import pear.math.Vec2

/**
 *
 * Created by William on 2/15/2015.
 */
class CanvasRenderer(val ctx: C2D) extends Renderer{
  private var _color = Color("#000000")
  
  override def pushContext(): Unit = ctx.save()
  override def popContext(): Unit = ctx.restore()

  override def color: Color = _color
  override def color_=(c: Color): Unit = _color = c

  override def drawLine(p1: Vec2, p2: Vec2, c: Color = color): Unit = {
    ctx.strokeStyle = c.toString()
    ctx.beginPath()
    ctx.moveTo(p1.x, p1.y)
    ctx.lineTo(p2.x, p2.y)
    ctx.stroke()
  }

  override def clear(): Unit = ctx.clearRect(0, 0, width, height)

  override def drawImage(img: HTMLImageElement, location: Vec2, dimensions: Vec2): Unit = 
    ctx.drawImage(img, location.x, location.y, dimensions.x, dimensions.y)

  override def width: Int = ctx.canvas.width
  override def height: Int = ctx.canvas.height

  override def rotate(deg: Double): Unit = ctx.rotate(Math.toRadians(deg))

  override def translate(x: Double, y: Double): Unit = ctx.translate(x, y)

  override def scale(x: Double, y: Double): Unit = ctx.scale(x, y)
}
