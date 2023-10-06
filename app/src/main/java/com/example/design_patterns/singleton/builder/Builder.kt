package com.example.design_patterns.singleton.builder

class Car private constructor(
    val brand: String,
    val model: String,
    val color: String,
    val hasSunroof: Boolean
) {
    data class Builder(
        var brand: String = "",
        var model: String = "",
        var color: String = "Black",
        var hasSunroof: Boolean = false
    ) {
        fun setBrand(brand: String) = apply { this.brand = brand }
        fun setModel(model: String) = apply { this.model = model }
        fun setColor(color: String) = apply { this.color = color }
        fun setSunroof(hasSunroof: Boolean) = apply { this.hasSunroof = hasSunroof }
        fun build(): Car = Car(brand, model, color, hasSunroof)

    }
}

//Kotlin style :)
data class CarKotlin(val brand: String = "No Brand",
                      val model: String = "No Model",
                      val color: String = "Black",
                      val hasSunroof: Boolean = false)

fun main() {
    val car = Car.Builder()
        .setBrand("Audi")
        .setModel("A4")
        .setSunroof(false)
        .build()

    println("Car Details:")
    println("Brand: ${car.brand}")
    println("Model: ${car.model}")
    println("Color: ${car.color}")
    println("Has Sunroof: ${car.hasSunroof}")

    val car2 = CarKotlin(model = "fusion", color = "Orange")
    println(car2.toString())
}





