package uk.co.mintuk.datamodel

import scala.collection.mutable.ListBuffer

trait Group {
  val offer: Offer = NoDiscountOffer
  val costItems: ListBuffer[ShoppingItem] = ListBuffer.empty[ShoppingItem]
  val freeItems: ListBuffer[ShoppingItem] = ListBuffer.empty[ShoppingItem]

  def cost : BigDecimal = {
     costItems.toList.map(each => each.cost).sum - offer.cashBackAmount
  }

  def full : Boolean = {
    costItems.size == offer.payableSize && freeItems.size == offer.freeItemSize
  }


  def add(item: ShoppingItem): Boolean = {
    if(costItems.size < offer.payableSize) {
      costItems += item
    } else if ( freeItems.size < offer.freeItemSize) {
      freeItems += item
    } else {
      return false
    }
    true
  }
}


case class ClonedGroup (group :Group) extends Group {
    this.costItems ++=group.costItems
    this.freeItems ++=group.freeItems
}

case class NoDiscountGroup() extends Group
case class BuyOneGetOneFreeGroup(override val offer: Offer = BuyOneGetOneFreeOffer) extends Group
case class BuyThreeGetTwoFreeGroup(override val offer:Offer= BuyThreeGetTwoFreeOffer) extends Group