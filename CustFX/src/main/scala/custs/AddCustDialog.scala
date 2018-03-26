package custs

//import javafx.scene.control.ButtonType
import scalafx.geometry.Insets
import scalafx.scene.control.{ButtonType, Dialog, Label, TextField}
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.text.Text
import scalafx.scene.control.Dialog

class AddCustDialog extends Dialog[Cust] {

  initOwner(CustsApp.stage)
  title = "Add Customer Dialog"

  def validate(): Unit = {
    if (nameTf.text.value.isEmpty) {
      erro.text = "Empty name"
      dialogPane().lookupButton(ButtonType.OK).setDisable(true)
    } else {
      dialogPane().lookupButton(ButtonType.OK).setDisable(false)
      erro.text = ""
    }

  }

  val nameTf = new TextField()
  val addressTf = new TextField()
  val erro = new Text() {
    fill = Color.Red
  }

  nameTf.onKeyReleased = (x) => {
    validate()
  }

  val form = new GridPane {

    hgap = 10
    vgap = 10
    padding = Insets(20, 100, 10, 10)
    add(new Label("Name"), 0, 0)
    add(nameTf, 1, 0)
    add(new Label("Address"), 0, 1)
    add(addressTf, 1, 1)
  }
  this.getDialogPane().setContent(new VBox(form, erro))
  this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.Cancel)
  validate()

  resultConverter = {
    case ButtonType.OK => Cust(nameTf.text(), addressTf.text())
    case _ => null
  }


  def exec(): Unit = {
    val result = showAndWait()
    if (result.isDefined) {
      val c: Cust = result.get.asInstanceOf[Cust]
    }

    result match {
      //case Some(c @ Cust(n, a)) => CustRep.custs.add(c)
      case Some(c: Cust) => CustRep.custs.add(c)
      case _ =>
    }
  }


}
