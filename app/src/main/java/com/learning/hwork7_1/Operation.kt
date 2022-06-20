package com.learning.hwork7_1

class Operation {
    private var memory: Double = 0.0

    fun add(a: Double = memory, b: Double): Double {
        memory = a + b
        return memory
    }

    fun submit(a: Double = memory, b: Double): Double {
        memory = a - b
        return memory
    }

    fun multiply(a: Double = memory, b: Double): Double {
        memory = a * b
        return memory
    }

    fun divide(a: Double = memory, b: Double): Double {
        memory = a / b
        return memory
    }
}