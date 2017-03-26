package uk.co.mintuk.service

import org.scalatest._
import uk.co.mintuk.datamodel.{Apple, Orange, ShoppingItem}


//as no dependency to any other services so we use only dummy data, not mocked data
class ShoppingCartWithoutOffersTest extends FunSpec with ShouldMatchers with BeforeAndAfter with Matchers{

  describe("Simple shopping cart with no offers") {
    it("an empty shopping cart should pay zero amount") {
      val noItems : List[ShoppingItem] = List.empty[ShoppingItem]
      shoppingCart.calculatePaymentByGroupWithOffers(noItems) should equal(0)
    }

    it("an shopping cart with some items should pay some amount") {
      val someItems: List[ShoppingItem] = List(Apple(),Apple(),Orange(),Apple())
      shoppingCart.calculatePaymentByGroupWithOffers(someItems) should equal(0)
    }
  }
}