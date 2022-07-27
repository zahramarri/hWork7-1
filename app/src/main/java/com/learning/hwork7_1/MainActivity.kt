package com.learning.hwork7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.hwork7_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mathematicalOperation: MathematicalOperation? = null
    private lateinit var binding: ActivityMainBinding
    private var input: String = ""
    private var number: String = ""
    private val divisionSign = "\u00F7"
    private val multiplicationSign = "\u00D7"
    private val operators: Array<String> = arrayOf("+", "-", "\u00F7", "\u00D7")
    private val digits: Array<String> = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            initializeOperationObject()
        } else {
            with(savedInstanceState) {
                binding.tvScreen.text = getString(STATE_RESULT)
                input = getString(STATE_RESULT).toString()
                mathematicalOperation = getParcelable(STATE_OPERATION_OBJECT)
            }
        }

        setDivisionSign()
        setMultiplicationSign()

        binding.buttonZero.setOnClickListener {
            handleDigits0to9Input(binding.buttonZero.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonOne.setOnClickListener {
            handleDigits0to9Input(binding.buttonOne.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonTwo.setOnClickListener {
            handleDigits0to9Input(binding.buttonTwo.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonThree.setOnClickListener {
            handleDigits0to9Input(binding.buttonThree.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonFour.setOnClickListener {
            handleDigits0to9Input(binding.buttonFour.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonFive.setOnClickListener {
            handleDigits0to9Input(binding.buttonFive.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonSix.setOnClickListener {
            handleDigits0to9Input(binding.buttonSix.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonSeven.setOnClickListener {
            handleDigits0to9Input(binding.buttonSeven.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonEight.setOnClickListener {
            handleDigits0to9Input(binding.buttonEight.text.toString())
            binding.tvScreen.text = input
        }
        binding.buttonNine.setOnClickListener {
            handleDigits0to9Input(binding.buttonNine.text.toString())
            binding.tvScreen.text = input
        }

        binding.buttonDotSign.setOnClickListener {
            handleDotSignInput(binding.buttonDotSign.text.toString())
            binding.tvScreen.text = input
        }

        binding.buttonDivisionSign.setOnClickListener {
            handleOperatorInput(binding.buttonDivisionSign.text.toString())
            storeOperator(binding.buttonDivisionSign.text.toString())
            storeNumber()
            binding.tvScreen.text = input
        }
        binding.buttonMultiplicationSign.setOnClickListener {
            handleOperatorInput(binding.buttonMultiplicationSign.text.toString())
            storeOperator(binding.buttonMultiplicationSign.text.toString())
            storeNumber()
            binding.tvScreen.text = input
        }
        binding.buttonSubmissionSign.setOnClickListener {
            handleOperatorInput(binding.buttonSubmissionSign.text.toString())
            storeOperator(binding.buttonSubmissionSign.text.toString())
            storeNumber()
            binding.tvScreen.text = input
        }
        binding.buttonAdditionSign.setOnClickListener {
            handleOperatorInput(binding.buttonAdditionSign.text.toString())
            storeNumber()
            storeOperator(binding.buttonAdditionSign.text.toString())
            binding.tvScreen.text = input
        }

        binding.buttonEqualSign.setOnClickListener {
            if (input.lastOrNull().toString() !in operators && (
                        input.contains("+") ||
                                input.contains("-") ||
                                input.contains("\u00F7") ||
                                input.contains("\u00D7"))
            ) {
                storeNumber()
                val result = mathematicalOperation?.doOperationsInOrder()
                input = if (result.toString().last() == '0') {
                    result?.toInt().toString()
                } else {
                    result.toString()
                }
                binding.tvScreen.text = input
                number = input
            }
        }

        binding.buttonDelete.setOnClickListener {
            handleDeleteAction()
            binding.tvScreen.text = input
        }
    }

    private fun setDivisionSign() {
        binding.buttonDivisionSign.text = divisionSign
    }

    private fun setMultiplicationSign() {
        binding.buttonMultiplicationSign.text = multiplicationSign
    }

    private fun handleDotSignInput(dotSign: String) {
        if (input.isNotEmpty()) {
            if (input.last().toString() != dotSign &&
                input.last().toString() !in operators &&
                !number.contains(dotSign)
            ) {
                input += dotSign
                number += dotSign
            }
        }
    }

    private fun handleDigits0to9Input(newDigit: String) {
        if (input.lastOrNull().toString() == "0" &&
            (input.length == 1 || input[input.lastIndex - 1].toString() in operators)
        ) {
            input = input.replace(input.last(), newDigit.first())
            number += newDigit
        } else {
            input += newDigit
            number += newDigit
        }
    }

    private fun handleOperatorInput(operator: String) {
        if (input.isNotEmpty()) {
            if (input.last().toString() !in operators) {
                input += operator
            } else {
                if (input.last().toString() == "\u00F7" || input.last().toString() == "\u00D7") {
                    if (operator == "-") {
                        input += operator
                        number += operator
                    }
                }
            }
        } else if (operator == "-") {
            input += operator
            number += operator
        }
    }

    private fun storeNumber() {
        if (input.isNotEmpty()) {
            if (number.isNotEmpty()) {
                if (number != "-") {
                    mathematicalOperation?.listOfNumbers?.add(number.toDouble())
                    number = ""
                }
            }
        }
    }

    private fun storeOperator(operator: String) {
        if (input.isNotEmpty() && input.length > 1) {
            if (input[input.lastIndexOf(operator) - 1].toString() in digits) {
                mathematicalOperation?.listOfOperators?.add(operator)
            } else {
                if (operator == "-") {
                    if (input[input.lastIndexOf(operator) - 1].toString() != "\u00F7" &&
                        input[input.lastIndexOf(operator) - 1].toString() != "\u00D7"
                    ) {
                        mathematicalOperation?.listOfOperators?.add(operator)
                    }
                }
            }
        }
    }

    private fun handleDeleteAction() {
        if (input.isNotEmpty()) {
            if (input.last().toString() in operators) {
                if (input.last().toString() == "-") {
                    if (input.length == 1 ||
                        input[input.lastIndexOf("-") - 1].toString() == "\u00F7" ||
                        input[input.lastIndexOf("-") - 1].toString() == "\u00D7"
                    ) {
                        input = input.dropLast(1)
                        number = number.dropLast(1)
                    } else {
                        input = input.dropLast(1)
                        mathematicalOperation?.listOfOperators?.removeLast()
                        number = mathematicalOperation?.listOfNumbers?.last().toString()
                        mathematicalOperation?.listOfNumbers?.removeLast()
                    }
                } else {
                    input = input.dropLast(1)
                    mathematicalOperation?.listOfOperators?.removeLast()
                    number = mathematicalOperation?.listOfNumbers?.last().toString()
                    mathematicalOperation?.listOfNumbers?.removeLast()
                }
            } else {
                input = input.dropLast(1)
                number = number.dropLast(1)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(STATE_RESULT, binding.tvScreen.text.toString())
            setLastNumberRemained()
            putParcelable(STATE_OPERATION_OBJECT, mathematicalOperation)
        }
        super.onSaveInstanceState(outState)
    }

    companion object {
        const val STATE_RESULT = "text view result status"
        const val STATE_OPERATION_OBJECT = "mathematical operation object status"
    }

    private fun initializeOperationObject() {
        mathematicalOperation = MathematicalOperation(mutableListOf(), mutableListOf())
    }

    private fun setLastNumberRemained() {
        if (input.lastOrNull().toString() in digits) {
            val lastOperatorInList = mathematicalOperation?.listOfOperators?.last()
            val indexOfLastOperatorInInput = lastOperatorInList?.let { input.lastIndexOf(it) }
            val lastNumberInInput = indexOfLastOperatorInInput?.let { input.substring(it + 1) }
            lastNumberInInput?.toDouble()?.let { mathematicalOperation?.listOfNumbers?.add(it) }
        }
    }
}