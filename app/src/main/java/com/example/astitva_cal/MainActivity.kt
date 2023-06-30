package com.example.astitva_cal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.example.astitva_cal.databinding.ActivityMainBinding
import java.util.Stack

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tv0.setOnClickListener {
            addDigit("0")
        }
        binding.tv1.setOnClickListener {
            addDigit("1")
        }
        binding.tv2.setOnClickListener {
            addDigit("2")
        }
        binding.tv3.setOnClickListener {
            addDigit("3")
        }
        binding.tv4.setOnClickListener {
            addDigit("4")
        }
        binding.tv5.setOnClickListener {
            addDigit("5")
        }
        binding.tv6.setOnClickListener {
            addDigit("6")
        }
        binding.tv7.setOnClickListener {
            addDigit("7")
        }
        binding.tv8.setOnClickListener {
            addDigit("8")
        }
        binding.tv9.setOnClickListener {
            addDigit("9")
        }
        binding.tvOpeningBracket.setOnClickListener {
            addDigit("(")
        }
        binding.tvClosingBracket.setOnClickListener {
            addDigit(")")
        }
        binding.tvDot.setOnClickListener {
            addDigit(".")
        }
        binding.tvAdd.setOnClickListener {
            addDigit("+")
        }
        binding.tvSubtract.setOnClickListener {
            addDigit("-")
        }
        binding.tvMultiply.setOnClickListener {
            addDigit("*")
        }
        binding.tvdivide.setOnClickListener {
            addDigit("/")
        }
        binding.tvAC.setOnClickListener {
            binding.tvDisplay.text = " "
        }
        binding.tvDel.setOnClickListener {
            del(binding.tvDisplay)
        }
        binding.tvequal.setOnClickListener {
            val str: String = binding.tvDisplay.text.toString()
            binding.tvDisplay.text = evaluateInfixExpression(str)
        }
    }


    fun addDigit(str: String) {
        binding.tvDisplay.append(str)
    }

    fun del(str: TextView) {
        if (str.length() != 0) {
            str.text = str.text.subSequence(0, str.text.toString().length - 1)
        }
    }

    fun evaluateInfixExpression(expression: String): String {
        val operatorPrecedence = hashMapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2)

        fun performOperation(operator: Char, operand2: Double, operand1: Double): Double {
            return when (operator) {
                '+' -> operand1 + operand2
                '-' -> operand1 - operand2
                '*' -> operand1 * operand2
                '/' -> operand1 / operand2
                else -> throw IllegalArgumentException("Invalid operator: $operator")
            }
        }

        val tokens = expression.replace(" ", "").toCharArray()
        val outputQueue = mutableListOf<String>()
        val operatorStack = Stack<Char>()

        var currentNumber = ""
        for (token in tokens) {
            if (token.isDigit() || token == '.') {
                currentNumber += token
            } else {
                if (currentNumber.isNotEmpty()) {
                    outputQueue.add(currentNumber)
                    currentNumber = ""
                }
                if (operatorPrecedence.containsKey(token)) {
                    while (!operatorStack.isEmpty() &&
                        operatorPrecedence[operatorStack.peek()]!! >= operatorPrecedence[token]!!
                    ) {
                        outputQueue.add(operatorStack.pop().toString())
                    }
                    operatorStack.push(token)
                }
            }
        }

        if (currentNumber.isNotEmpty()) {
            outputQueue.add(currentNumber)
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.pop().toString())
        }

        val operandStack = Stack<Double>()

        for (token in outputQueue) {
            if (token.toCharArray().all { it.isDigit() }) {
                operandStack.push(token.toDouble())
            } else {
                val operand2 = operandStack.pop()
                val operand1 = operandStack.pop()
                val result = performOperation(token[0], operand2, operand1)
                operandStack.push(result)
            }
        }

        if (operandStack.size != 1) {
            throw IllegalArgumentException("Invalid expression")
        }

        val result = operandStack.pop()
        return result.toString()
    }




}




