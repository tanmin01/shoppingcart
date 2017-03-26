package uk.co.mintuk.datamodel

trait ShoppingItem {
  val price: BigDecimal = 0
  val discountRatio : BigDecimal = 0
  val cost : BigDecimal = price * (1.00-discountRatio)
}

case class Apple(name:String = "Apple", override val price: BigDecimal= 60) extends ShoppingItem
case class Orange(name:String = "Orange",override val price:BigDecimal= 25) extends ShoppingItem
