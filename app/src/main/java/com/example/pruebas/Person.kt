package com.example.pruebas

class Person(var name: String = "Anonimo", var rut: String? = null, var altura:Float, var peso: Float) {

    fun Person(){
        name= "José"
        rut= "76894836-8"
    }
    fun checkPolicia(fn: (Float)->Boolean): Boolean{
    return fn(altura)
    }
}