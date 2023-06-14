package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// TODO 0: Clone the calc repo
// TODO 1: Create a new branch <name_calc>
// TODO 2: Push all your code to this new branch
// TODO 3: Share the link of your branch with me (on Discord or on WA)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvDisplay: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay  = findViewById(R.id.tvDisplay)

        findViewById<TextView>(R.id.tvAC).setOnClickListener(this)
        findViewById<TextView>(R.id.tvOpeningBracket).setOnClickListener(this)
        findViewById<TextView>(R.id.tvClosingBracket).setOnClickListener(this)
        findViewById<TextView>(R.id.tvDivide).setOnClickListener(this)
        findViewById<TextView>(R.id.tv7).setOnClickListener(this)
        findViewById<TextView>(R.id.tv8).setOnClickListener(this)
        findViewById<TextView>(R.id.tv9).setOnClickListener(this)
        findViewById<TextView>(R.id.tvMultiply).setOnClickListener(this)
        findViewById<TextView>(R.id.tv4).setOnClickListener(this)
        findViewById<TextView>(R.id.tv5).setOnClickListener(this)
        findViewById<TextView>(R.id.tv6).setOnClickListener(this)
        findViewById<TextView>(R.id.tvSubstract).setOnClickListener(this)
        findViewById<TextView>(R.id.tv1).setOnClickListener(this)
        findViewById<TextView>(R.id.tv2).setOnClickListener(this)
        findViewById<TextView>(R.id.tv3).setOnClickListener(this)
        findViewById<TextView>(R.id.tvAdd).setOnClickListener(this)
        findViewById<TextView>(R.id.tv0).setOnClickListener(this)
        findViewById<TextView>(R.id.tvDot).setOnClickListener(this)
        findViewById<TextView>(R.id.tvBackspace).setOnClickListener(this)
        findViewById<TextView>(R.id.tvEqual).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvAC -> {
                // Implement action for R.id.tvAC
                tvDisplay.text = ""
            }
            R.id.tvOpeningBracket -> {
                // Implement action for R.id.tvOpeningBracket
                tvDisplay.text = tvDisplay.text.toString() + "("
            }
            R.id.tvClosingBracket -> {
                // Implement action for R.id.tvClosingBracket
                tvDisplay.text = tvDisplay.text.toString() + ")"
            }
            R.id.tvDivide -> {
                // Implement action for R.id.tvDivide
                tvDisplay.text = tvDisplay.text.toString() + "/"
            }
            R.id.tv7 -> {
                // Implement action for R.id.tv7
                tvDisplay.text = tvDisplay.text.toString() + "7"
            }
            R.id.tv8 -> {
                // Implement action for R.id.tv8
                tvDisplay.text = tvDisplay.text.toString() + "8"
            }
            R.id.tv9 -> {
                // Implement action for R.id.tv9
                tvDisplay.text = tvDisplay.text.toString() + "9"
            }
            R.id.tvMultiply -> {
                // Implement action for R.id.tvMultiply
                tvDisplay.text = tvDisplay.text.toString() + "*"
            }
            R.id.tv4 -> {
                // Implement action for R.id.tv4
                tvDisplay.text = tvDisplay.text.toString() + "4"
            }
            R.id.tv5 -> {
                // Implement action for R.id.tv5
                tvDisplay.text = tvDisplay.text.toString() + "5"
            }
            R.id.tv6 -> {
                // Implement action for R.id.tv6
                tvDisplay.text = tvDisplay.text.toString() + "6"
            }
            R.id.tvSubstract -> {
                // Implement action for R.id.tvSubstract
                tvDisplay.text = tvDisplay.text.toString() + "-"
            }
            R.id.tv1 -> {
                // Implement action for R.id.tv1
                tvDisplay.text = tvDisplay.text.toString() + "1"
            }
            R.id.tv2 -> {
                // Implement action for R.id.tv2
                tvDisplay.text = tvDisplay.text.toString() + "2"
            }
            R.id.tv3 -> {
                // Implement action for R.id.tv3
                tvDisplay.text = tvDisplay.text.toString() + "3"
            }
            R.id.tvAdd -> {
                // Implement action for R.id.tvAdd
                tvDisplay.text = tvDisplay.text.toString() + "+"
            }
            R.id.tv0 -> {
                // Implement action for R.id.tv0
                tvDisplay.text = tvDisplay.text.toString() + "0"
            }
            R.id.tvDot -> {
                // Implement action for R.id.tvDot
                tvDisplay.text = tvDisplay.text.toString() + "."
            }
            R.id.tvBackspace -> {
                // Implement action for R.id.tvBackspace
                if(tvDisplay.text.toString()!="")
                tvDisplay.text = tvDisplay.text.toString().substring(0,tvDisplay.text.toString().length-1)
            }
            R.id.tvEqual -> {
                // Implement action for R.id.tvEqual
                tvDisplay.text = try {
                    calculate(tvDisplay.text.toString())
                } catch (e: Exception) {
                    e.toString()
                }
            }
            else -> {
                // Handle other views, if any
                Log.d("Else", "This is an else part")
            }
        }
    }

    private fun calculate(tvDisplayText: String): String? {
        when(true) {
            tvDisplayText.contains('+') -> {
                val nums = tvDisplayText.split('+')
                val n1 = nums[0].toBigDecimal()
                val n2 = nums[1].toBigDecimal()
                return (n1+n2).toString()
            }
            tvDisplayText.contains('-') -> {
                val nums = tvDisplayText.split('-')
                val n1 = nums[0].toBigDecimal()
                val n2 = nums[1].toBigDecimal()
                return (n1-n2).toString()
            }
            tvDisplayText.contains('*') -> {
                val nums = tvDisplayText.split('*')
                val n1 = nums[0].toBigDecimal()
                val n2 = nums[1].toBigDecimal()
                return (n1*n2).toString()
            }
            tvDisplayText.contains('/') -> {
                val nums = tvDisplayText.split('/')
                val n1 = nums[0].toBigDecimal()
                val n2 = nums[1].toBigDecimal()
                return (n1/n2).toString()
            }
            else -> return "Invalid Input"
        }
    }

}
