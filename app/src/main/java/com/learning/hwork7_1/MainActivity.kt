package com.learning.hwork7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.hwork7_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var input: String = ""
    private var number: String = ""
    private val divisionSign = "\u00F7"
    private val multiplicationSign = "\u00D7"
    private val operators: Array<String> = arrayOf("+", "-", "\u00F7", "\u00D7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDivisionSign()
        setMultiplicationSign()

        binding.buttonZero.setOnClickListener {
            handleDigits0to9Input(binding.buttonZero.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonOne.setOnClickListener {
            handleDigits0to9Input(binding.buttonOne.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonTwo.setOnClickListener {
            handleDigits0to9Input(binding.buttonTwo.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonThree.setOnClickListener {
            handleDigits0to9Input(binding.buttonThree.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonFour.setOnClickListener {
            handleDigits0to9Input(binding.buttonFour.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonFive.setOnClickListener {
            handleDigits0to9Input(binding.buttonFive.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonSix.setOnClickListener {
            handleDigits0to9Input(binding.buttonSix.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonSeven.setOnClickListener {
            handleDigits0to9Input(binding.buttonSeven.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonEight.setOnClickListener {
            handleDigits0to9Input(binding.buttonEight.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonNine.setOnClickListener {
            handleDigits0to9Input(binding.buttonNine.text.toString())
            binding.resultOfOperations.text = input
        }

        binding.buttonDotSign.setOnClickListener {
            handleDotSignInput(binding.buttonDotSign.text.toString())
            binding.resultOfOperations.text = input
        }

        binding.buttonDivisionSign.setOnClickListener{
            handleOperatorInput(binding.buttonDivisionSign.text.toString())
            storeInput(binding.buttonDivisionSign.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonMultiplicationSign.setOnClickListener{
            handleOperatorInput(binding.buttonMultiplicationSign.text.toString())
            storeInput(binding.buttonMultiplicationSign.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonSubmissionSign.setOnClickListener{
            handleOperatorInput(binding.buttonSubmissionSign.text.toString())
            storeInput(binding.buttonSubmissionSign.text.toString())
            binding.resultOfOperations.text = input
        }
        binding.buttonAdditionSign.setOnClickListener{
            handleOperatorInput(binding.buttonAdditionSign.text.toString())
            storeInput(binding.buttonAdditionSign.text.toString())
            binding.resultOfOperations.text = input
        }

    }

    private fun setDivisionSign() {
        binding.buttonDivisionSign.text = divisionSign
    }

    private fun setMultiplicationSign() {
        binding.buttonMultiplicationSign.text = multiplicationSign
    }

    private fun handleDotSignInput(dotSign: String) {
            if (!number.contains(".")) {
                input += dotSign
                number += dotSign
            }
    }

    private fun handleDigits0to9Input(newDigit: String) {
        if (input.lastOrNull()
                .toString() == "0" && (input.length == 1 || input[input.indexOf("0") - 1].toString() in operators)
        ) {
            input = input.replace(input.last(), newDigit.first())
            number += newDigit
        } else {
            input += newDigit
            number += newDigit
        }
    }

    private fun handleOperatorInput(operator: String) {
        if (((operator == "-") && (input.last().toString() == "\u00F7" || input.last().toString() == "\u00D7")) || input.last().toString() !in operators) {
            input += operator
        }
    }

    private fun storeInput(operator: String) {
        MathematicalOperation.listOfOperators.add(operator)
        MathematicalOperation.listOfNumbers.add(number.toDouble())
        number = ""
    }
}