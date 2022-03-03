package com.example.kt



fun main() {
    for (i in 1..9) {
        for (j in 1..9) {
            println("i:$i "+ "j:$j")
        }
    }
    head@for (i in 1..9) {
        for (j in 1..9) {
            println("i:$i " + "j:$j")
            if (i==5) {
                break@head
            }
        }
    }
}