package com.df.checkout

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Test suite for `ShoppingCart`.
  */
@RunWith(classOf[JUnitRunner])
class ShoppingCartSuite extends FunSuite {
  trait ShoppingCarts {
    val appleCost: BigDecimal = 0.60
    val orangeCost: BigDecimal = 0.25

    val sc1 = ShoppingCart(
      List("Apple", "Apple", "Orange", "Apple"), appleCost, orangeCost
    )

    val sc2 = ShoppingCart(List(), appleCost, orangeCost)

    val sc3 = ShoppingCart(
      List("Apple", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Orange"),
      appleCost,
      orangeCost
    )

    val sc4 = ShoppingCart(
      List(
        "Apple", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange",
        "Apple", "Apple"
      ),
      appleCost,
      orangeCost
    )
  }

  test("total cost of a shopping cart with 3 apples and 1 orange") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout(sc1) === 2.05)
    }
  }

  test("total cost of an empty shopping cart") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout(sc2) === 0.0)
    }
  }

  test("total cost of a shopping cart with 3 apples and 5 oranges") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout(sc3) === 3.05)
    }
  }

  test("total cost of a shopping cart with 6 apples and 5 oranges") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout(sc4) === 4.85)
    }
  }

  test("total cost of a shopping cart with 3 apples and 2 oranges with offers applied") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout2(sc1, applyOffers = true) === 1.45)
    }
  }

  test("total cost of a shopping cart with 3 apples and 5 oranges with offers applied") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout2(sc3, applyOffers = true) === 2.20)
    }
  }

  test("total cost of a shopping cart with 6 apples and 5 oranges with offers applied") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout2(sc4, applyOffers = true) === 2.80)
    }
  }

  test("total cost of an empty shopping cart with offers applied") {
    new ShoppingCarts {
      assert(ShoppingCart.checkout2(sc2, applyOffers = true) === 0.0)
    }
  }
}
