package pear.ss3

import pear.physics.Collision
import pear.ss3.module.Images

import scala.scalajs.js.annotation.JSExport

/**
 *
 * Created by William on 2/12/2015.
 */
object SideScroll {

  val collisionMethod: Collision = Collision.Naive
  
  //Modules
  @JSExport val img = Images
  
  
  
}
