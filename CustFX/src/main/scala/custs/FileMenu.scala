package custs

import scalafx.scene.control.Menu

object FileMenu extends Menu {

  text = "File"
  items = List(
    ExitAction.mi,
    AddCustAction.mi
  )

}
