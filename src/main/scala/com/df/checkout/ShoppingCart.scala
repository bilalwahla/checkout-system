package com.df.checkout

/**
  * A shopping cart with a checkout system for a shop which only sells apples and oranges.
  */
case class ShoppingCart(fruits: List[String], appleCost: BigDecimal, orangeCost: BigDecimal)

object ShoppingCart {
  private val orange = "Orange"
  private val apple = "Apple"

  def checkout(cart: ShoppingCart): BigDecimal = ???
}
