package com.example.calcvert

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.calcvert.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // Move isPressed to be a member variable of the class
    var isPressed = false
    var lastNumber=false
    var stateError=false
    var lastDot=false


    lateinit  var expression: Expression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn1.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn1.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }

            numberclick(it)
        }


        binding.btnAc.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnAc.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnAc.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            allclearclick(it)
        }


        binding.btnClear.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnClear.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnClear.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            clearclick(it)
        }

        binding.btnPer.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnPer.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnPer.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            operatorclick(it)
        }

        binding.btnDiv.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnDiv.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnDiv.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            operatorclick(it)

        }

        binding.btnMul.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnMul.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnMul.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            operatorclick(it)
        }

        binding.btnSub.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnSub.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnSub.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            operatorclick(it)
        }

        binding.btnAdd.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnAdd.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnAdd.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            operatorclick(it)
        }

        binding.btnEql.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnEql.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnEql.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            equalclick(it)
        }

        binding.btnDel.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnDel.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnDel.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            backclick(it)
        }

        binding.btnDot.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnDot.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnDot.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = true
            }
            operatorclick(it)
        }



        binding.btn2.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn2.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn2.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }

        binding.btn3.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn3.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn3.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }

        binding.btn4.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn4.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn4.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }

        binding.btn5.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn5.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn5.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }

        binding.btn6.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn6.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn6.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }


        binding.btn7.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn7.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn7.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }


        binding.btn8.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn8.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn8.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }


        binding.btn9.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn9.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn9.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }

        binding.btn0.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn0.setBackgroundColor(Color.parseColor("#1A1A1A")) //
                isPressed = false
            } else {
                binding.btn0.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = true
            }
            numberclick(it)
        }

        binding.nextpge.setOnClickListener {
            startActivity(Intent(this@MainActivity, Convert_page::class.java))
        }


    }

    fun numberclick(view: View) {
        if (stateError){
            binding.txtinput.text=(view as Button).text
            stateError=false
        }else{
            binding.txtinput.append((view as Button).text)
        }
        lastNumber=true
        equalclick()

    }




    fun clearclick(view: View) {
        binding.txtinput.text=""
        lastNumber=false
    }



    fun backclick(view: View) {
        binding.txtinput.text=binding.txtinput.text.toString().dropLast(1)
        try {
            val lastchar=binding.txtinput.text.toString().last()
            if(
                lastchar.isDigit()
            ){
                equalclick()
            }
        }catch (e:Exception){
            binding.txtoutput.text=""
            Log.e("Last char error",e.toString())
        }
    }


    fun operatorclick(view: View) {
        binding.txtinput.append((view as Button).text)
        lastDot=false
        lastNumber=false
        equalclick()
    }


    fun allclearclick(view: View) {
        binding.txtinput.text=""
        binding.txtoutput.text=""
        lastNumber=false
        stateError=false
        lastDot=false


    }

    fun equalclick(view: View) {

        equalclick()
        binding.txtinput.text=binding.txtoutput.text.toString().drop(1)
    }

    fun equalclick() {
        if(lastNumber && !stateError){
            val txt=binding.txtinput.text.toString()
            expression=ExpressionBuilder(txt).build()

            try {
                val output=expression.evaluate()
                binding.txtoutput.text="="+output.toString()

            }catch (ex:ArithmeticException){

                Log.e("evaluate error",ex.toString())
                binding.txtoutput.text="error"
                stateError=true
                lastNumber=false
            }

        }
    }




}
/*

User
 fun equalclick(view: View) {

        if(lastNumber && !stateError){
            val txt=binding.txtinput.text.toString()
            expression=ExpressionBuilder(txt).build()

            try {
                val output=expression.evaluate()
                binding.txtoutput.text="="+output.toString()

            }catch (ex:ArithmeticException){
                Log.0("evaluate error",ex.toString())
                binding.txtoutput.text="error"
                stateError=true
                lastNumber=false
            }

        }
    }
 */


/*
        binding.btnAc.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnAc.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnAc.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }


        binding.btnClear.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnClear.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnClear.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnPer.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnPer.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnPer.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnDiv.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnDiv.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnDiv.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnMul.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnMul.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnMul.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnSub.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnSub.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnSub.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnAdd.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnAdd.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnAdd.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnEql.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnEql.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnEql.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnDel.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnDel.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnDel.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btnDot.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btnDot.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btnDot.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btn1.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn1.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn1.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btn2.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn2.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn2.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btn3.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn3.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn3.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btn4.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn4.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn4.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btn5.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn5.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn5.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btn6.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn6.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn6.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }


        binding.btn7.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn7.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn7.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }


        binding.btn8.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn8.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn8.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }


        binding.btn9.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn9.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn9.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }

        binding.btn0.setOnClickListener {
            // Call the changecolor function when the button is clicked
            if (isPressed) {
                binding.btn0.setBackgroundColor(Color.parseColor("#272B33")) //
                isPressed = false
            } else {
                binding.btn0.setBackgroundColor(Color.parseColor("yellow")) //
                isPressed = true
            }
        }
*/
