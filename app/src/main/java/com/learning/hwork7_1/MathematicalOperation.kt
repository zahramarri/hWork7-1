package com.learning.hwork7_1

object MathematicalOperation {
    private val listOfNumbers: MutableList<Double> = mutableListOf()
    private val listOfOperators: MutableList<String> = mutableListOf()
    private var memory: Double = 0.0

    private fun add(a: Double = memory, b: Double): Double {
        memory = a + b
        return memory
    }

    private fun submit(a: Double = memory, b: Double): Double {
        memory = a - b
        return memory
    }

    private fun multiply(a: Double = memory, b: Double): Double {
        memory = a * b
        return memory
    }

    private fun divide(a: Double = memory, b: Double): Double {
        memory = a / b
        return memory
    }

    private fun operate(operator: String, index: Int, operation: (Double, Double)-> Double) {
        val b = operation(listOfNumbers[index], listOfNumbers[index + 1])
        listOfNumbers[index] = b
        listOfNumbers.removeAt(index + 1)
        listOfOperators.removeAt(index)
    }

    fun doOperationsInOrder() {
        for (operator in listOfOperators) {
            val index = listOfOperators.indexOf(operator)
            if (listOfOperators.contains("×") || listOfOperators.contains("÷")) {
               if (operator == "×") {
                   operate(operator, index, ::multiply)
               } else {
                   operate(operator, index, ::divide)
               }
           } else {
               if (operator == "+") {
                   operate(operator, index, ::add)
               } else {
                   operate(operator, index, ::submit)
               }
           }
        }
    }
}