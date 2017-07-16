package com.df.checkout

/**
  * A shopping cart with a checkout system for a shop which only sells apples and oranges.
  */
case class ShoppingCart(fruits: List[String], appleCost: BigDecimal, orangeCost: BigDecimal)

object ShoppingCart {
  private val orange = "Orange"
  private val apple = "Apple"

  def checkout2(cart: ShoppingCart, applyOffers: Boolean = false): BigDecimal = ???

  def checkout(cart: ShoppingCart): BigDecimal = cart.fruits match {
    case Nil => 0.00
    case f :: _ if f == apple || f == orange =>
      cart.fruits.count(_ == apple) * cart.appleCost + cart.fruits.count(_ == orange) * cart.orangeCost
  }
}
