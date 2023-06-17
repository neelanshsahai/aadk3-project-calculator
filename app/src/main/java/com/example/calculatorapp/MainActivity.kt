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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
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
                onClear()
            }

            R.id.tvbracket1 -> {
                onClickDigit("(")
            }

            R.id.tvbracket2 -> {
                onClickDigit(")")
            }

            R.id.tvDiv -> {
                onEqual()
                onClickDigit("/")

            }

            R.id.tv7 -> {

                onClickDigit("7")
            }

            R.id.tv8 -> {

                onClickDigit("8")
            }

            R.id.tv9 -> {

                onClickDigit("9")
            }

            R.id.tvMul -> {
                onEqual()
                onClickDigit("*")

            }

            R.id.tv4 -> {

                onClickDigit("4")
            }

            R.id.tv5 -> {

                onClickDigit("5")
            }

            R.id.tv6 -> {

                onClickDigit("6")
            }

            R.id.tvSub -> {
                onEqual()
                onClickDigit("-")



            }

            R.id.tv1 -> {

                onClickDigit("1")
            }

            R.id.tv2 -> {

                onClickDigit("2")
            }

            R.id.tv3 -> {

                onClickDigit("3")
            }

            R.id.tvAdd -> {
                onEqual()
                onClickDigit("+")


            }

            R.id.tv0 -> {

                onClickDigit("0")
            }

            R.id.tvDot -> {

                onClickDigit(".")
            }

            R.id.tvBackSpace -> {

                if (tvResult.text.toString() != "")
                    tvResult.text =
                        tvResult.text.toString().substring(0, tvResult.text.toString().length - 1)
            }

            R.id.tvAns -> {
                onEqual()
            }

            else -> {

                Log.d("Error","Invalid Operation")

            }

        }
    }

    fun onClickDigit(text:String){

        tvResult.append(text)

    }

    fun onEqual(){

        var text = tvResult.text.toString()
        var sum:Double = 0.0
        var numbers = text.split("+","-","/","*")

        if(numbers.size >= 2){

            if (text.contains("+")) {
                var num = tvResult.text.split("+")
                for(i in num){
                    sum += i.toDouble()
                }
                tvResult.text = sum.toString()


            }

            if (text.contains("-")) {
                var num = tvResult.text.split("-")
                sum = num[0].toDouble()
                for(i in num.drop(1)){
                    sum -= i.toDouble()
                }
                tvResult.text = sum.toString()

            }

            if (text.contains("/")) {
                var num = tvResult.text.split("/")
                sum = num[0].toDouble()
                for(i in num.drop(1)){
                    sum /= i.toDouble()
                }
                tvResult.text = sum.toString()

            }

            if (text.contains("*")) {
                var num = tvResult.text.split("*")
                sum = 1.0
                for(i in num){
                    sum *= i.toDouble()
                }
                tvResult.text = sum.toString()
            }
        }


    }

    fun onClear(){

        tvResult.text = "0"

    }

}