package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

// TODO 0: Clone the calc repo
// TODO 1: Create a new branch <name_calc>
// TODO 2: Push all your code to this new branch
// TODO 3: Share the link of your branch with me (on Discord or on WA)
class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var tvResult: TextView
    lateinit var myCalculatorOperations: MyCalculatorOperations
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        myCalculatorOperations = MyCalculatorOperations(tvResult)
        findViewById<TextView>(R.id.tvAc).setOnClickListener(this)
        findViewById<TextView>(R.id.tvbracket1).setOnClickListener(this)
        findViewById<TextView>(R.id.tvbracket2).setOnClickListener(this)
        findViewById<TextView>(R.id.tvDiv).setOnClickListener(this)
        findViewById<TextView>(R.id.tv7).setOnClickListener(this)
        findViewById<TextView>(R.id.tv8).setOnClickListener(this)
        findViewById<TextView>(R.id.tv9).setOnClickListener(this)
        findViewById<TextView>(R.id.tvMul).setOnClickListener(this)
        findViewById<TextView>(R.id.tv4).setOnClickListener(this)
        findViewById<TextView>(R.id.tv5).setOnClickListener(this)
        findViewById<TextView>(R.id.tv6).setOnClickListener(this)
        findViewById<TextView>(R.id.tvSub).setOnClickListener(this)
        findViewById<TextView>(R.id.tv1).setOnClickListener(this)
        findViewById<TextView>(R.id.tv2).setOnClickListener(this)
        findViewById<TextView>(R.id.tv3).setOnClickListener(this)
        findViewById<TextView>(R.id.tvAdd).setOnClickListener(this)
        findViewById<TextView>(R.id.tv0).setOnClickListener(this)
        findViewById<TextView>(R.id.tvDot).setOnClickListener(this)
        findViewById<TextView>(R.id.tvBackSpace).setOnClickListener(this)
        findViewById<TextView>(R.id.tvAns).setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v?.id) {
            R.id.tvAc -> {
                myCalculatorOperations.onClear()
            }

            R.id.tvbracket1 -> {
                myCalculatorOperations.onClickDigit("(")
            }

            R.id.tvbracket2 -> {
                myCalculatorOperations.onClickDigit(")")
            }

            R.id.tvDiv -> {
                myCalculatorOperations.onEqual()
                myCalculatorOperations.onClickDigit("/")

            }

            R.id.tv7 -> {

                myCalculatorOperations.onClickDigit("7")
            }

            R.id.tv8 -> {

                myCalculatorOperations.onClickDigit("8")
            }

            R.id.tv9 -> {

                myCalculatorOperations.onClickDigit("9")
            }

            R.id.tvMul -> {
                myCalculatorOperations.onEqual()
                myCalculatorOperations.onClickDigit("*")

            }

            R.id.tv4 -> {

                myCalculatorOperations.onClickDigit("4")
            }

            R.id.tv5 -> {

                myCalculatorOperations.onClickDigit("5")
            }

            R.id.tv6 -> {

                myCalculatorOperations.onClickDigit("6")
            }

            R.id.tvSub -> {
                myCalculatorOperations.onEqual()
                myCalculatorOperations.onClickDigit("-")



            }

            R.id.tv1 -> {

                myCalculatorOperations.onClickDigit("1")
            }

            R.id.tv2 -> {

                myCalculatorOperations.onClickDigit("2")
            }

            R.id.tv3 -> {

                myCalculatorOperations.onClickDigit("3")
            }

            R.id.tvAdd -> {
                myCalculatorOperations.onEqual()
                myCalculatorOperations.onClickDigit("+")


            }

            R.id.tv0 -> {

                myCalculatorOperations.onClickDigit("0")
            }

            R.id.tvDot -> {

                myCalculatorOperations.onClickDigit(".")
            }

            R.id.tvBackSpace -> {

                if (tvResult.text.toString() != "")
                    tvResult.text =
                        tvResult.text.toString().substring(0, tvResult.text.toString().length - 1)
            }

            R.id.tvAns -> {
                myCalculatorOperations.onEqual()
            }

            else -> {

                Log.d("Error","Invalid Operation")

            }

        }
    }



}