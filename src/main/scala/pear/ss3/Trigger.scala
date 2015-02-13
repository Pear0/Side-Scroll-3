package pear.ss3

import scala.collection.mutable
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

/**
 *
 * Created by William on 2/12/2015.
 */
@JSExport
class Trigger[A] {

  val listeners = mutable.Queue[js.Function1[A, Unit]]()

  @JSExport
  def add(f: js.Function1[A, Unit]) = apply(f)

  def apply(f: js.Function1[A, Unit]): Unit = {
    listeners += f
  }

  @JSExport
  def trigger(e: A): Unit = {
    for (f <- listeners)
      f(e)
  }

}
