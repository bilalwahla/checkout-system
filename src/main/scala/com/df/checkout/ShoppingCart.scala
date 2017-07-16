package com.df.checkout

/**
  * A shopping cart with a checkout system for a shop which only sells apples and oranges.
  */
case class ShoppingCart(fruits: List[String], appleCost: BigDecimal, orangeCost: BigDecimal)

object ShoppingCart {
  private val orange = "Orange"
  private val apple = "Apple"

  def checkout(cart: ShoppingCart, applyOffers: Boolean = false): BigDecimal =
    if (applyOffers) checkoutWithOffers(cart)
    else checkout(cart)

  def checkout(cart: ShoppingCart): BigDecimal = cart.fruits match {
    case Nil => 0.00
    case f :: _ if f == apple || f == orange =>
      cart.fruits.count(_ == apple) * cart.appleCost + cart.fruits.count(_ == orange) * cart.orangeCost
  }

  private def checkoutWithOffers(cart: ShoppingCart): BigDecimal = {
    checkout(
      new ShoppingCart(
        List.fill(buy2For1ApplesOffer(cart.fruits))(apple) ++ List.fill(buy3For2OrangesOffer(cart.fruits))(orange),
        cart.appleCost,
        cart.orangeCost
      )
    )
  }

  def buy2For1ApplesOffer(fruits: List[String]) = {
    val appleCount: Int = fruits.count(_ == apple)
    appleCount / 2 + appleCount % 2
  }

  def buy3For2OrangesOffer(fruits: List[String]) = {
    val orangeCount: Int = fruits.count(_ == orange)
    (orangeCount / 3) * 2 + orangeCount % 3
  }
}
