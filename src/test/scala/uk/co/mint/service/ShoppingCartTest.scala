package uk.co.mint.service

import org.scalatest._
import uk.co.mintuk.datamodel.{Apple, Orange, Payable}
import uk.co.mintuk.service.shoppingCart

//as no dependency to any other services so we use only dummy data, not mocked data
class ShoppingCartTest extends FunSpec with ShouldMatchers with BeforeAndAfter with Matchers{

  describe("Simple shopping cart with no offers") {
    it("an empty shopping cart should pay zero amount") {
      val noItems : List[Payable] = List.empty[Payable]
      shoppingCart.calculatePayment(noItems) should equal(0)
    }

    it("an shopping cart with some items should pay some amount") {
      val someItems: List[Payable] = List(Apple(),Apple(),Orange(),Apple())
      shoppingCart.calculatePayment(someItems) should equal(205.0)
    }
  }
}