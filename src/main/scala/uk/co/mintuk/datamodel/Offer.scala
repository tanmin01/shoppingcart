package uk.co.mintuk.datamodel

trait Offer {
  def payableCount: Int = Integer.MAX_VALUE
  def freeItemCount : Int = 0
  def cashBackAmount: BigDecimal = 0
  def fixedCostAmount: BigDecimal = 0
}

case class NoOffer(name:String = "BuyOneGetOneFreeOffer")
case class BuyOneGetOneFreeOffer(name:String = "BuyOneGetOneFreeOffer",
                                 override val payableCount: Int = 1, override val freeItemCount: Int = 1 ) extends Offer
case class BuyThreeGetTwoFreeOffer(name:String = "BuyThreeGetTwoFreeOffer",
                                   override val payableCount: Int = 3, override val freeItemCount: Int =2) extends Offer