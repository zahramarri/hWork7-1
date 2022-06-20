package com.learning.hwork7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.hwork7_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var input: String = ""
    private val divisionSign = "\u00F7"
    private val multiplicationSign = "\u00D7"
    private val digits1to9: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    private val operators: Array<String> = arrayOf("+", "-", "\u00F7", "\u00D7")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDivisionSign()
        setMultiplicationSign()

        binding.buttonZero.setOnClickListener {
            input += binding.buttonZero.text
        }
        binding.buttonOne.setOnClickListener {
            input += binding.buttonOne.text
        }
        binding.buttonTwo.setOnClickListener {
            input += binding.buttonTwo.text
        }
        binding.buttonThree.setOnClickListener {
            input += binding.buttonThree.text
        }
        binding.buttonFour.setOnClickListener {
            input += binding.buttonFour.text
        }
        binding.buttonFive.setOnClickListener {
            input += binding.buttonFive.text
        }
        binding.buttonSix.setOnClickListener {
            input += binding.buttonSix.text
        }
        binding.buttonSeven.setOnClickListener {
            input += binding.buttonSeven.text
        }
        binding.buttonEight.setOnClickListener {
            input += binding.buttonEight.text
        }
        binding.buttonNine.setOnClickListener {
            input += binding.buttonNine.text
        }
    }

    private fun setDivisionSign() {
        binding.buttonDivisionSign.text = divisionSign
    }

    private fun setMultiplicationSign() {
        binding.buttonMultiplicationSign.text = multiplicationSign
    }

    private fun handleDotSignInput(newInput: String) {
        if (newInput == ".") {
            if (!input.contains(".")) {
                input += newInput
            }
        }
    }

    private fun handleDigits0to9Input(newInput: Char) {
        if (input.last().toString() == "0" && (input.length == 1 || input[input.indexOf("0") - 1].toString() in operators)) {
        input.replace(input.last(), newInput)
        }
    }

    private fun handleOperatorInput(newInput: String) {
        if (((newInput == "-") && (input.last().toString() == "\u00F7" || input.last().toString() == "\u00D7")) ||
            input.last().toString() !in operators) {
            input += newInput
        }
    }
}