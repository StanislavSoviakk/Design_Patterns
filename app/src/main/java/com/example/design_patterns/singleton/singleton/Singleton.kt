package com.example.design_patterns.singleton.singleton

class Singleton private constructor() {
    companion object {
        @Volatile
        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Singleton()
                    }
                }
            }
            return instance!!
        }
    }

    var someName = "STANISLAV"
}


fun main(){
    val s = Singleton.getInstance()
    val secondS = Singleton.getInstance()

    secondS.someName = "NOT STANISLAV"

    println(s.someName)

}


