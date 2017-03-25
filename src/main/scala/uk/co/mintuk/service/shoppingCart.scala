package uk.co.mintuk.service

import uk.co.mintuk.datamodel.Payable

object shoppingCart {
  def calculatePayment(payables: List[Payable]): BigDecimal = {
    payables.map(payable => payable.cost).sum
  }
}
