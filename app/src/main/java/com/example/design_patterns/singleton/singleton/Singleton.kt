package com.example.design_patterns.singleton.singleton

object Singleton {
    var someName = "STANISLAV"
}


fun main(){
    val s = Singleton
    val secondS = Singleton

    secondS.someName = "NOT STANISLAV"

    println(s.someName)

}


