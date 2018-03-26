package custs

import scalafx.beans.property.StringProperty
import scalafx.scene.control.{TableColumn, TableView}
import scalafx.scene.control.TableColumn._

object CustTable extends TableView[Cust](CustRep.custs) {
  columns ++= List(
    new TableColumn[Cust, String] {
      text = "Name"
      cellValueFactory = (x) => {
        new StringProperty(x.value.name)
      }
      prefWidth = 100

    },
    new TableColumn[Cust, String] {
      text = "Address"
      cellValueFactory = (x) => {
        new StringProperty(x.value.address)
      }
      prefWidth = 100

    }
  )

}
