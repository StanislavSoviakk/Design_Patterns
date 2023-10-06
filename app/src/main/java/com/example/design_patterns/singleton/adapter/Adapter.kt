package com.example.design_patterns.singleton.adapter

interface Car {
    fun accelerate()
    fun honk()
}

interface Bicycle {
    fun pedal()
    fun ringBell()
}

class Sedan : Car {
    override fun accelerate() {
        println("Sedan is accelerating!")
    }

    override fun honk() {
        println("Sedan is honking!")
    }
}

class MountainBike : Bicycle {
    override fun pedal() {
        println("Mountain bike is pedaling!")
    }

    override fun ringBell() {
        println("Mountain bike is ringing the bell!")
    }
}

class Adapter(bicycle: Bicycle) : Car {
    private val currentBicycle: Bicycle = bicycle

    override fun accelerate() {
        currentBicycle.pedal()
    }

    override fun honk() {
        currentBicycle.ringBell()
    }
}

fun main() {
    val sedan = Sedan()
    val mountainBike = MountainBike()

    println("Sedan:")
    sedan.accelerate()
    sedan.honk()

    println("\nMountain Bike:")
    mountainBike.pedal()
    mountainBike.ringBell()

    val adaptedBike = Adapter(mountainBike)
    println("\nAdapted Mountain Bike (as Car):")
    adaptedBike.accelerate()
    adaptedBike.honk()
}