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

    private fun operate(index: Int, operation: (Double, Double)-> Double): Double {
        val resultOfOperation = operation(listOfNumbers[index], listOfNumbers[index + 1])
        listOfNumbers[index] = resultOfOperation
        listOfNumbers.removeAt(index + 1)
        listOfOperators.removeAt(index)
        return resultOfOperation
    }

    fun doOperationsInOrder(): Double? {
        for (operator in listOfOperators) {
            val index = listOfOperators.indexOf(operator)
            return if (listOfOperators.contains("×") || listOfOperators.contains("÷")) {
                if (operator == "×") {
                    operate(index, ::multiply)
                } else {
                    operate(index, ::divide)
                }
            } else {
                if (operator == "+") {
                    operate(index, ::add)
                } else {
                    operate(index, ::submit)
                }
            }
        }
        listOfNumbers.clear()
        listOfNumbers.clear()
        return null
    }
}