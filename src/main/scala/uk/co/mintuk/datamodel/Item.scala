package uk.co.mintuk.datamodel

trait Payable {
  def price: BigDecimal
  def discountRatio : BigDecimal
  def cost : BigDecimal = price * (1.00-discountRatio)
}

case class Apple(name:String = "Apple", override val price: BigDecimal= 60,override val discountRatio: BigDecimal= 0.0) extends Payable
case class Orange(name:String = "Orange",override val price:BigDecimal= 25,override val discountRatio: BigDecimal= 0.0) extends Payable
