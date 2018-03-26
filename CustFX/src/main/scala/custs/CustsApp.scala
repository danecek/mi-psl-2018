package custs

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene

object CustsApp extends JFXApp {

   stage = new PrimaryStage {
      title = "Customers"
      scene = new Scene(MainWindow, 600, 400)
   }
}
