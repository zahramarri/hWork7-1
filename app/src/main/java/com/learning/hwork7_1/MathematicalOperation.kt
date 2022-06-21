package com.learning.hwork7_1

object MathematicalOperation {
    val listOfNumbers: MutableList<Double> = mutableListOf()
    val listOfOperators: MutableList<String> = mutableListOf()

    private fun add(a: Double, b: Double): Double {
        return a + b
    }

    private fun submit(a: Double, b: Double): Double {
        return a - b
    }

    private fun multiply(a: Double, b: Double): Double {
        return a * b

    }

    private fun divide(a: Double, b: Double): Double {
        return a / b

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