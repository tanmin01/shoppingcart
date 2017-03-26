package uk.co.mintuk.service

import uk.co.mintuk.datamodel._

import scala.collection.mutable.ListBuffer

object shoppingCart {
  val avaiableOffers: List[Offer] = List(NoDiscountOffer, BuyOneGetOneFreeOffer, BuyThreeGetTwoFreeOffer)

  def calculatePayment(items: List[ShoppingItem]): BigDecimal = {
    items.map(item => item.cost).sum
  }

  def calculatePaymentByGroupWithOffers(items: List[ShoppingItem]): BigDecimal = {
    val closedGroups: ListBuffer[Group] = ListBuffer.empty[Group]
    val openGroups: Map[String, Group] = Map(Apple().name -> BuyOneGetOneFreeGroup(),
       Orange().name ->BuyThreeGetTwoFreeGroup(), "" -> NoDiscountGroup())
    items.foreach(item => buildGroups(item, openGroups, closedGroups))
    closedGroups.toList.map(group => group.cost).sum + openGroups.values.toList.map(group => group.cost).sum
  }

  def buildGroups(item: ShoppingItem, open: Map[String, Group], closed: ListBuffer[Group]) = {
    val group: Option[Group] = addItem(item, open)
    if (group.nonEmpty) {
      closed += ClonedGroup(group.get)
      group.get.costItems.clear()
      group.get.freeItems.clear()
    }
  }

  def addItem(item: ShoppingItem, open: Map[String, Group]): Option[Group] = {
    val opt: Option[Group] = open.get(item.name)
    if (opt.nonEmpty) {
      opt.get.add(item)
      if (opt.get.full) {
        return opt
      }
    }
    Option.empty[Group]
  }
}
