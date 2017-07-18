package com.df.checkout

case class GenericShoppingCart(fruits: List[Fruit])

case class Offer(items: Int, forItems: Int, fruit: Fruit) {
  def calcItemsToPrice(count: Int): Int = (count / items) * forItems + count % items
}

object GenericShoppingCart {
  // 3. Generalised offers
  def checkout(cart: GenericShoppingCart, offers: List[Offer]): BigDecimal = cart.fruits match {
    case Nil => 0.00
    case fruit :: _ if fruit.isInstanceOf[Apple] => calcFruitPrice(fruit, cart.fruits, offers.filter(_.fruit.isInstanceOf[Apple])) +
      checkout(GenericShoppingCart(cart.fruits.filter(!_.isInstanceOf[Apple])), offers.filter(!_.fruit.isInstanceOf[Apple]))
    case fruit :: _ if fruit.isInstanceOf[Orange] => calcFruitPrice(fruit, cart.fruits, offers.filter(_.fruit.isInstanceOf[Orange])) +
      checkout(GenericShoppingCart(cart.fruits.filter(!_.isInstanceOf[Orange])), offers.filter(!_.fruit.isInstanceOf[Orange]))
  }

  private def calcFruitPrice(fruit: Fruit, fruits: List[Fruit], offers: List[Offer]): BigDecimal =
    offers match {
      case Nil => fruits.count(_.name == fruit.name) * fruit.price
      case offer :: _ if offer.fruit.name == fruit.name => offer.calcItemsToPrice(fruits.count(_.name == fruit.name)) * fruit.price
      case _ :: otherOffers => calcFruitPrice(fruit, fruits, otherOffers)
    }
}