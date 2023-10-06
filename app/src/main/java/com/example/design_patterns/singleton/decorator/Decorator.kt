package com.example.design_patterns.singleton.decorator

interface Coffee{
    fun cost(): Double
}

class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 50.0
    }
}

class MilkDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double {
        return coffee.cost() + 20
    }
}

class WhipDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double {
        return coffee.cost() + 10
    }
}

fun main(){
    val coffee: Coffee = SimpleCoffee()
    println("Cost: ${coffee.cost()}")

    val coffeeMilk: Coffee = MilkDecorator(coffee)
    println("Cost with Milk: ${coffeeMilk.cost()}")


    val coffeeMilkWhip: Coffee = WhipDecorator(coffee)
    println("Cost with Milk and Whip: ${coffeeMilkWhip.cost()}")

}