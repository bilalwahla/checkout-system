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

}
