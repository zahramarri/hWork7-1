package com.learning.hwork7_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learning.hwork7_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDivisionSign()
        setMultiplicationSign()
    }

    fun setDivisionSign() {
        val divisionSign = "\u00F7"
        binding.buttonDivisionSign.text = divisionSign
    }

    fun setMultiplicationSign() {
        val multiplicationSign = "\u00D7"
        binding.buttonMultiplicationSign.text = multiplicationSign
    }
}