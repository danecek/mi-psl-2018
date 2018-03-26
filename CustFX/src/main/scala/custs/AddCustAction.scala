package custs
import javafx.event.{ActionEvent, EventHandler}

object AddCustAction extends CustAction {
  override val name: String = "Add Customer"
  override val h: EventHandler[ActionEvent] = _=>new AddCustDialog().exec()
}
