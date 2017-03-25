package uk.co.mintuk

import uk.co.mintuk.datamodel.{Apple, Orange, Payable}
import uk.co.mintuk.service.shoppingCart

object simpleCheckoutApplication {
  def main(args : Array[String]) {
    val noItems : List[Payable] = List.empty[Payable]
    println("I have got no item " + noItems)
    println("I have to pay this amount " + shoppingCart.calculatePayment(noItems) + " pence")

    val someItems: List[Payable] = List(Apple(),Apple(),Orange(),Apple())
    println("I have got some items " + someItems)
    println("I have to pay this amount " + shoppingCart.calculatePayment(someItems)+ " pence")
  }
}
