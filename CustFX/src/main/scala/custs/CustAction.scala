package custs


import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.MenuItem

trait CustAction {
  val name: String
  val h: EventHandler[ActionEvent]

  def mi: MenuItem = new MenuItem(name) {
    this.onAction = h
  }
}
