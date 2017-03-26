package uk.co.mintuk.datamodel

trait ShoppingItem {
  val name = ""
  val price: BigDecimal = 0
  val discountRatio : BigDecimal = 0
  def cost : BigDecimal = price * (1.00-discountRatio)
}

case class Apple(override val name:String = "Apple", override val price: BigDecimal= 60) extends ShoppingItem
case class Orange(override val name:String = "Orange",override val price:BigDecimal= 25) extends ShoppingItem

