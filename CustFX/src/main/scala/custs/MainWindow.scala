package custs

import scalafx.scene.control.Label
import scalafx.scene.layout.VBox

object MainWindow extends VBox {

  children = List(
    CustMenuBar,
    CustTable

  )

}
