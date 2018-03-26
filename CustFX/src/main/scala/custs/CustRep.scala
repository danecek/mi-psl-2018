package custs

import scalafx.collections.ObservableBuffer

object CustRep {
    val custs = new ObservableBuffer[Cust]
    custs.add(Cust("Tom", "Prague"))
}
