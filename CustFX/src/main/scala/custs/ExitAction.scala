package custs

import scalafx.application.Platform

object ExitAction extends CustAction {
  val name = "Exit"

  val h = _ => {
    Platform.exit()
  }

}
