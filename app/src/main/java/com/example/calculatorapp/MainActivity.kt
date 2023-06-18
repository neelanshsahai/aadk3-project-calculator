package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorapp.databinding.ActivityMainBinding
import java.util.Stack

// TODO 0: Clone the calc repo
// TODO 1: Create a new branch <name_calc>
// TODO 2: Push all your code to this new branch
// TODO 3: Share the link of your branch with me (on Discord or on WA)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfTVs = listOf(
            binding.tvAC,
            binding.tvOpeningBracket,
            binding.tvClosingBracket,
            binding.tvDivide,
            binding.tv7,
            binding.tv8,
            binding.tv9,
            binding.tvMultiply,
            binding.tv4,
            binding.tv5,
            binding.tv6,
            binding.tvSubstract,
            binding.tv1,
            binding.tv2,
            binding.tv3,
            binding.tvAdd,
            binding.tv0,
            binding.tvDot,
            binding.tvBackspace,
            binding.tvEqual,
        )

        for (textView in listOfTVs) {
            textView.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        val tvDisplayText = binding.tvDisplay.text.toString()
        when (v?.id) {
            R.id.tvAC -> {
                // Implement action for R.id.tvAC
                binding.tvDisplay.text = ""
            }
            R.id.tvOpeningBracket -> {
                // Implement action for R.id.tvOpeningBracket
                binding.tvDisplay.text = tvDisplayText + "("
            }
            R.id.tvClosingBracket -> {
                // Implement action for R.id.tvClosingBracket
                binding.tvDisplay.text = tvDisplayText + ")"
            }
            R.id.tvDivide -> {
                // Implement action for R.id.tvDivide
                binding.tvDisplay.text = tvDisplayText + "/"
            }
            R.id.tv7 -> {
                // Implement action for R.id.tv7
                binding.tvDisplay.text = tvDisplayText + "7"
            }
            R.id.tv8 -> {
                // Implement action for R.id.tv8
                binding.tvDisplay.text = tvDisplayText + "8"
            }
            R.id.tv9 -> {
                // Implement action for R.id.tv9
                binding.tvDisplay.text = tvDisplayText + "9"
            }
            R.id.tvMultiply -> {
                // Implement action for R.id.tvMultiply
                binding.tvDisplay.text = tvDisplayText + "*"
            }
            R.id.tv4 -> {
                // Implement action for R.id.tv4
                binding.tvDisplay.text = tvDisplayText + "4"
            }
            R.id.tv5 -> {
                // Implement action for R.id.tv5
                binding.tvDisplay.text = tvDisplayText + "5"
            }
            R.id.tv6 -> {
                // Implement action for R.id.tv6
                binding.tvDisplay.text = tvDisplayText + "6"
            }
            R.id.tvSubstract -> {
                // Implement action for R.id.tvSubstract
                binding.tvDisplay.text = tvDisplayText + "-"
            }
            R.id.tv1 -> {
                // Implement action for R.id.tv1
                binding.tvDisplay.text = tvDisplayText + "1"
            }
            R.id.tv2 -> {
                // Implement action for R.id.tv2
                binding.tvDisplay.text = tvDisplayText + "2"
            }
            R.id.tv3 -> {
                // Implement action for R.id.tv3
                binding.tvDisplay.text = tvDisplayText + "3"
            }
            R.id.tvAdd -> {
                // Implement action for R.id.tvAdd
                binding.tvDisplay.text = tvDisplayText + "+"
            }
            R.id.tv0 -> {
                // Implement action for R.id.tv0
                binding.tvDisplay.text = tvDisplayText + "0"
            }
            R.id.tvDot -> {
                // Implement action for R.id.tvDot
                binding.tvDisplay.text = tvDisplayText + "."
            }
            R.id.tvBackspace -> {
                // Implement action for R.id.tvBackspace
                if(tvDisplayText!="")
                binding.tvDisplay.text = tvDisplayText.substring(0,tvDisplayText.length-1)
            }
            R.id.tvEqual -> {
                // Implement action for R.id.tvEqual
                binding.tvDisplay.text = try {
                    calculateParenthesis(binding.tvDisplay.text.toString())
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

    private fun calculateParenthesis(tvDisplayText: String): String {
        var copyTxt = tvDisplayText
        var openParenIdx = -1 // open parenthesis indices
        var i = -1
        while('(' in copyTxt || ')' in copyTxt) {
            i++
            if(copyTxt[i]=='(') openParenIdx = i
            else if(copyTxt[i]==')') {
                val closeParenIdx = i
                val currNum = calculateExpression(copyTxt.substring(openParenIdx+1, closeParenIdx))
                copyTxt = copyTxt.substring(0, openParenIdx)  +  currNum  +  copyTxt.substring(closeParenIdx+1, copyTxt.length)
                i=-1
                openParenIdx = -1
            }
        }
        return calculateExpression(copyTxt)
    }

    private fun calculateExpression(expression: String): String {
        if('+' !in expression && '/' !in expression && '*' !in expression && ('-' !in expression || expression[0]=='-')) return expression
        val nums = expression.split('+', '-', '*', '/').toMutableList()
        var operatorIdx = -1
        for(char in expression) {
            if(char=='*') {
                operatorIdx++
                nums[operatorIdx] = (nums[operatorIdx].toDouble()*nums[operatorIdx+1].toDouble()).toString()
                nums.removeAt(operatorIdx+1)
                operatorIdx--
            } else if(char=='/') {
                operatorIdx++
                nums[operatorIdx] = (nums[operatorIdx].toDouble()/nums[operatorIdx+1].toDouble()).toString()
                nums.removeAt(operatorIdx+1)
                operatorIdx--
            } else if (char in listOf('+', '-')) {
                operatorIdx++;
            }
        }
        for(char in expression) {
            if(char=='+') {
                nums[0] = (nums[0].toDouble()+nums[1].toDouble()).toString()
                nums.removeAt(1)
            } else if(char=='-') {
                nums[0] = (nums[0].toDouble()-nums[1].toDouble()).toString()
                nums.removeAt(1)
            }
        }
        return nums[0]
    //        when(true) {
//            tvDisplayText.contains('+') -> {
//                val nums = tvDisplayText.split('+')
//                val n1 = nums[0].toBigDecimal()
//                val n2 = nums[1].toBigDecimal()
//                return (n1+n2).toString()
//            }
//            tvDisplayText.contains('-') -> {
//                val nums = tvDisplayText.split('-')
//                val n1 = nums[0].toBigDecimal()
//                val n2 = nums[1].toBigDecimal()
//                return (n1-n2).toString()
//            }
//            tvDisplayText.contains('*') -> {
//                val nums = tvDisplayText.split('*')
//                val n1 = nums[0].toBigDecimal()
//                val n2 = nums[1].toBigDecimal()
//                return (n1*n2).toString()
//            }
//            tvDisplayText.contains('/') -> {
//                val nums = tvDisplayText.split('/')
//                val n1 = nums[0].toBigDecimal()
//                val n2 = nums[1].toBigDecimal()
//                return (n1.toDouble()/n2.toDouble()).toString()
//            }
//            else -> return "Invalid Input"
//        }
    }

}
