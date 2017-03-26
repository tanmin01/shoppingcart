package uk.co.mintuk.service

import uk.co.mintuk.datamodel._

object shoppingCart {
  val avaiableOffers : List[Offer] = List(NoDiscountOffer, BuyOneGetOneFreeOffer, BuyThreeGetTwoFreeOffer)

  def calculatePayment(items: List[ShoppingItem]): BigDecimal = {
    items.map(item => item.cost).sum
  }

  def calculatePaymentByGroupWithOffers(items: List[ShoppingItem]): BigDecimal = {
    val groups : List[Group] = List.empty[Group]
    items.foreach(item => addToGroup(item))
    groups.map(group => group.cost).sum
  }

  def addToGroup (item :ShoppingItem) : Unit = {}
}
