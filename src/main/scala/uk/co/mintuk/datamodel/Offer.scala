package uk.co.mintuk.datamodel

trait Offer {
  val payableSize: Int = Integer.MAX_VALUE
  val freeItemSize : Int = 0
  def cashBackAmount: BigDecimal = 0
  def fixedCostAmount: BigDecimal = 0
}

case object NoDiscountOffer extends Offer
case object BuyOneGetOneFreeOffer extends Offer {override val payableSize = 1; override  val freeItemSize =2 }
case object BuyThreeGetTwoFreeOffer extends Offer{override val payableSize = 1; override  val freeItemSize =2}