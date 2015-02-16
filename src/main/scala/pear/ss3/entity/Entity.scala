package pear.ss3.entity

import org.scalajs.dom.ext.Color
import pear.math.Vec2
import pear.physics.{BoundingBox, RectangleBoundingBox}
import pear.ss3.{SideScroll, World}
import pear.ss3.entity.ability.Ability
import pear.ss3.render.Renderer

/**
 *
 * Created by William on 2/12/2015.
 */
object Entity {
  var showDebug = false

}

class Entity private(var renderFunc: (Renderer) => Unit, var mass: Double, var position: Vec2, var size: Vec2, 
                     var velocity: Vec2, var acceleration: Vec2, var rotation: Double, var rVelocity: Double, 
                     var abilities: Set[Ability]) {
  import Entity._
  
  def boundingBox: BoundingBox = new RectangleBoundingBox(position.x, position.y, size.x, size.y, rotation)
  
  def applyForce(force: Vec2): Unit = velocity += force / mass
  
  def tick(w: World): Unit = {
    val prevPosition = position.copy()
    val prevVelocity = velocity.copy()
    val prevRotation = rotation
    val prevRVelocity = rVelocity
    
    for (entity <- w.getEntities.filter(_ != this)) {
      val b1 = boundingBox
      val b2 = entity.boundingBox
      for (collisions <- SideScroll.collisionMethod.check(b1, b2)) {
        
        
        
      }
    }
    
    
  }
  
  def render(r: Renderer): Unit = r.context {
    r.translate(position.x, position.y)
    r.translate(size.x / 2, size.y / 2)
    r.rotate(rotation)
    r.translate(-size.x / 2, -size.y / 2)
    renderFunc(r)
    if (showDebug) r.context {
      r.translate(size.x / 2, size.y / 2)
      r.drawVec2(velocity, Color("#FF0000"))
      r.drawVec2(acceleration, Color("#00FF00"))
    }

  }


}
