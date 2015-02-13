package pear.ss3.module

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.HTMLImageElement

import scala.scalajs.js.annotation.JSExport

/**
 *
 * Created by William on 2/12/2015.
 */
object Images {

  var images: Map[String, HTMLImageElement] = Map()

  def imagesLeft = images.map(_._2).count(!_.complete)

  @JSExport
  def registerImage(name: String, url: String, timeout: Int = 5000) = {
    val img = document.createElement("img").asInstanceOf[HTMLImageElement]
    img.src = url
    images += ((name, img))
    dom.window.setTimeout(() => {
      if (!img.complete) {
        println("Image taking too long to load. Cancelling...")
        images = images - name
      }
    }, timeout)
    img
  }

  @JSExport
  def get(name: String) = images.getOrElse(name, null)

  @JSExport
  def reg(name: String, url: String) = registerImage(name, url)

  def apply(name: String) = get(name)

  def clear(): Unit = {
    images = Map()
  }

}
