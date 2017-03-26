package uk.co.mintuk.service

import org.scalatest._
import uk.co.mintuk.datamodel.{Apple, Orange, ShoppingItem}


//as no dependency to any other services so we use only dummy data, not mocked data
class ShoppingCartWithOffersTest extends FunSpec with ShouldMatchers with BeforeAndAfter with Matchers {

  describe("Simple shopping cart with no offers") {
    it("an empty shopping cart should pay zero amount") {
      val noItems: List[ShoppingItem] = List.empty[ShoppingItem]
      shoppingCart.calculatePaymentByGroupWithOffers(noItems) should equal(0)
    }

    it("an shopping cart with 5 apples should pay 180") {
      val someItems: List[ShoppingItem] = List(Apple(), Apple(), Apple(), Apple(), Apple())
      shoppingCart.calculatePaymentByGroupWithOffers(someItems) should equal(180)
    }

    it("an shopping cart with 5 oranges should pay 75") {
      val someItems: List[ShoppingItem] = List(Orange(), Orange(), Orange(), Orange(), Orange())
      shoppingCart.calculatePaymentByGroupWithOffers(someItems) should equal(75)
    }

    it("an shopping cart with some items should pay some amount") {
      val someItems: List[ShoppingItem] = List(Apple(),Apple(),Orange(),Apple())
      shoppingCart.calculatePaymentByGroupWithOffers(someItems) should equal(145)
    }

    it("an shopping cart with some items should pay 195") {
      val someItems: List[ShoppingItem] = List(Orange(),Orange(),Apple(),Apple(),Orange(),Apple())
      shoppingCart.calculatePaymentByGroupWithOffers(someItems) should equal(195)
    }

    it("an shopping cart with mixed items should pay 195") {
      val someItems: List[ShoppingItem] = List(Orange(),Orange(),Apple(),Apple(),Orange(),Apple(),Orange())
      shoppingCart.calculatePaymentByGroupWithOffers(someItems) should equal(195)
    }
  }
}