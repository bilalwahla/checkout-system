package com.df.checkout

case class GenericShoppingCart(fruits: List[Fruit])

case class Offer(items: Int, forItems: Int, fruit: Fruit) {
  def calcItemsToPrice(count: Int): Int = (count / items) * forItems + count % items
}

object GenericShoppingCart {
  // 3. Generalised offers
  def checkout(cart: GenericShoppingCart, offers: List[Offer]): BigDecimal = cart.fruits match {
    case Nil => 0.00
    case fruit :: _ if fruit.isInstanceOf[Apple] =>
      calcFruitPrice(fruit, cart.fruits.count(_.name == fruit.name), offers) +
      checkout(GenericShoppingCart(cart.fruits.filter(!_.isInstanceOf[Apple])), offers)
    case fruit :: _ if fruit.isInstanceOf[Orange] =>
      calcFruitPrice(fruit, cart.fruits.count(_.name == fruit.name), offers) +
      checkout(GenericShoppingCart(cart.fruits.filter(!_.isInstanceOf[Orange])), offers)
  }

  private def calcFruitPrice(fruit: Fruit, count:Int, offers: List[Offer]): BigDecimal =
    offers match {
      case Nil => count * fruit.price
      case offer :: _ if offer.fruit.name == fruit.name => offer.calcItemsToPrice(count) * fruit.price
      case _ :: otherOffers => calcFruitPrice(fruit, count, otherOffers)
    }
}