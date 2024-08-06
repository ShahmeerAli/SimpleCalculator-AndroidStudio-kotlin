package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var EqualsBt: Button
    private lateinit var inputtext: TextView
    private lateinit var resulttext: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /*
          Making TextViews for input and result
         */


        inputtext = findViewById<TextView>(R.id.inputTxt)
        resulttext = findViewById<TextView>(R.id.resultTxt)


        /*
          Making Operation Buttons
         */

        val AdditonBt = findViewById<Button>(R.id.Addittion)
        val SubtractBt = findViewById<Button>(R.id.Subtract)
        val MultiplyBt = findViewById<Button>(R.id.Multiply)
        val DivideBt = findViewById<Button>(R.id.Divide)
        val ModulusBt = findViewById<Button>(R.id.Modulus)
        EqualsBt = findViewById<Button>(R.id.Equals)
        val ClearBt = findViewById<Button>(R.id.Clear)
        val AllClearBt = findViewById<Button>(R.id.AllClear)

        /*
           Making Clear & All-Clear buttons
         */
        val zero = findViewById<Button>(R.id.zero)
        val one = findViewById<Button>(R.id.one)
        val two = findViewById<Button>(R.id.two)
        val three = findViewById<Button>(R.id.three)
        val four = findViewById<Button>(R.id.four)
        val five = findViewById<Button>(R.id.five)
        val six = findViewById<Button>(R.id.six)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine = findViewById<Button>(R.id.nine)
        val dot = findViewById<Button>(R.id.dot)

        /*
        The Logic parts Comes Here
         Making Action listeners for all buttons
         */


        /*
         IMP:
           we are appending the digits because
           if we simply add the digits to the
           text view the new coming digit
           will overwrite the previous one

         */

        zero.setOnClickListener {
            inputtext.append("0")
        }


        one.setOnClickListener {
            inputtext.append("1")
        }

        two.setOnClickListener {
            inputtext.append("2")
        }

        three.setOnClickListener {
            inputtext.append("3")
        }

        four.setOnClickListener {
            inputtext.append("4")
        }

        five.setOnClickListener {
            inputtext.append("5")
        }


        six.setOnClickListener {
            inputtext.append("6")
        }


        seven.setOnClickListener {
            inputtext.append("7")
        }

        eight.setOnClickListener {
            inputtext.append("8")
        }

        nine.setOnClickListener {
            inputtext.append("9")
        }

        dot.setOnClickListener {
            inputtext.append(".")
        }


        AdditonBt.setOnClickListener {
            inputtext.append("+")
        }


        SubtractBt.setOnClickListener {
            inputtext.append("-")
        }


        MultiplyBt.setOnClickListener {
            inputtext.append("*")
        }

        DivideBt.setOnClickListener {
            inputtext.append("/")
        }


        ModulusBt.setOnClickListener {
            inputtext.append("%")
        }


        ClearBt.setOnClickListener {

            inputtext.text = inputtext.text.dropLast(1)


        }
        AllClearBt.setOnClickListener {
            inputtext.text = ""
            resulttext.text = ""
        }


        OnEquals()


    }

    /*
      The Main Logic applies here

      First we need to have a dependency in the Gradle :app module
        implementation("net.objecthunter:exp4j:0.4.8")
          We will make an Expression Builder Class .

     */
    private fun OnEquals() {

        EqualsBt.setOnClickListener {

            /*
              The Expression class will evalaute the
              expression written
              then simply add those results to
              your result TextView
             */

            /*
             Try catch is used to handle the exceptions
             The First one handles when a digit is divided by 0
             The Second one handles all illegal arguments
             Exception Handling is very important
             without this your app will crash

             */

            try {

                val expression = ExpressionBuilder(inputtext.text.toString()).build()

                val result = expression.evaluate()

                resulttext.text = "=" + result.toString()

            } catch (e: ArithmeticException) {
                Log.e("Error", e.toString())
                resulttext.text = "Error"

            } catch (e: IllegalArgumentException) {
                Log.e("Error", e.toString())
                resulttext.text = "Error"
            }
        }

    }
}