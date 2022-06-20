package com.learning.hwork7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.hwork7_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var input: String = ""
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
        val divisionSign = "\u00F7"
        binding.buttonDivisionSign.text = divisionSign
    }

    private fun setMultiplicationSign() {
        val multiplicationSign = "\u00D7"
        binding.buttonMultiplicationSign.text = multiplicationSign
    }
}