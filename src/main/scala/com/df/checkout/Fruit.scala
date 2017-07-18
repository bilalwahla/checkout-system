package com.df.checkout

abstract class Fruit {
  def name: String
  def price: BigDecimal
}

case class Apple(price: BigDecimal = 0.60) extends Fruit {
  override def name = "Apple"
}
case class Orange(price: BigDecimal = 0.25) extends Fruit {
  override def name = "Orange"
}
