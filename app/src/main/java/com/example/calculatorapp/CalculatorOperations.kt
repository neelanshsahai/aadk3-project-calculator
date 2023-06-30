package com.example.calculatorapp

import android.widget.TextView

interface CalculatorOperations {

    fun onEqual()
    fun onClear()
    fun onClickDigit(text: String)

}

class MyCalculatorOperations(

    private var tvResult: TextView

) :CalculatorOperations {
    override fun onEqual(){

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

    override fun onClear() {
        tvResult.text = "0"
    }

    override fun onClickDigit(text:String) {
        tvResult.append(text)
    }


}