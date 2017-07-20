package com.df.checkout

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GenericShoppingCartSuite extends FunSuite {
  trait GenericShoppingCarts {
    val apple = Apple()
    val orange = Orange()
    val gsc1 = GenericShoppingCart(List(apple, apple, orange, apple, orange, orange, orange, orange))
    val gsc2 = GenericShoppingCart(List(apple, apple, orange, apple))
    val gsc3 = GenericShoppingCart(List())
    val gsc4 = GenericShoppingCart(List(apple, apple, orange, apple, orange, apple, orange, orange, orange, apple, apple))
    val appleOffer = Offer(2, 1, apple)
    val orangeOffer = Offer(3, 2, orange)
  }

  test("total cost of a shopping cart with 3 apples and 5 oranges with offers applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc1, List(appleOffer, orangeOffer)) === 2.20)
    }
  }

  test("total cost of an empty shopping cart with offers applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc3, List(appleOffer, orangeOffer)) === 0.00)
    }
  }

  test("total cost of a shopping cart with 6 apples and 5 oranges with offers applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc4, List(appleOffer, orangeOffer)) === 2.80)
    }
  }

  test("total cost of shopping cart with 3 apples and 5 oranges without any offers applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc1, List()) === 3.05)
    }
  }

  test("total cost of shopping cart with 3 apples and 1 orange without any offers applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc2, List()) === 2.05)
    }
  }

  test("total cost of empty shopping cart without any offers applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc3, List()) === 0.00)
    }
  }

  test("total cost of shopping cart with 6 apples and 5 oranges without any offers applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc4, List()) === 4.85)
    }
  }

  test("total cost of shopping cart with 6 apples and 5 oranges with only apple offer applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc4, List(appleOffer)) === 3.05)
    }
  }

  test("total cost of shopping cart with 6 apples and 5 oranges with only orange offer applied") {
    new GenericShoppingCarts {
      assert(GenericShoppingCart.checkout(gsc4, List(orangeOffer)) === 4.6)
    }
  }
}
