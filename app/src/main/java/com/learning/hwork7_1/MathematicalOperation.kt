package com.learning.hwork7_1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MathematicalOperation(
    val listOfNumbers: MutableList<Double>,
    val listOfOperators: MutableList<String>
) : Parcelable {

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

    private fun operate(index: Int, operation: (Double, Double) -> Double) {
        val resultOfOperation = operation(listOfNumbers[index], listOfNumbers[index + 1])
        listOfNumbers[index] = resultOfOperation
        listOfNumbers.removeAt(index + 1)
    }

    fun doOperationsInOrder(): Double {
        val listOfRemainedOperators = listOfOperators.toMutableList()
        var index: Int

        for (operator in listOfOperators) {
            index = listOfRemainedOperators.indexOf(operator)
            if (operator == "×") {
                operate(index, ::multiply)
                listOfRemainedOperators.remove("×")
            } else if (operator == "÷") {
                operate(index, ::divide)
                listOfRemainedOperators.remove("÷")
            } else {
                continue
            }
        }

        for (operator in listOfOperators) {
            index = listOfRemainedOperators.indexOf(operator)
            if (operator == "+") {
                operate(index, ::add)
                listOfRemainedOperators.remove("+")
            } else if (operator == "-") {
                operate(index, ::submit)
                listOfRemainedOperators.remove("-")
            } else {
                continue
            }
        }

        val result = listOfNumbers[0]
        listOfNumbers.clear()
        listOfOperators.clear()
        return result
    }
}