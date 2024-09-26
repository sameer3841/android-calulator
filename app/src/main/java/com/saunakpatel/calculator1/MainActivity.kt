package com.saunakpatel.calculator1


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val editTextNumA = findViewById<EditText>(R.id.editTextNumA)
        val editTextNumB = findViewById<EditText>(R.id.editTextNumB)
        val textViewAns = findViewById<TextView>(R.id.textViewAns)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSub = findViewById<Button>(R.id.buttonSub)
        var firstTimeAdd = false
        var firstTimeSub = false
        var currentVal = 0.0


        if(textViewAns.text == "Answer"){
            firstTimeSub = false
            firstTimeAdd = false
        }

        buttonAdd.setOnClickListener {
            firstTimeSub = false
            val numA = parseNum(editTextNumA)
            val numB = parseNum(editTextNumB)

            if(!firstTimeAdd) {
                val ans = numA + numB
                firstTimeAdd = !firstTimeAdd
                currentVal = ans
            } else {
                currentVal += numB
            }





            textViewAns.text = currentVal.toString()
        }

        buttonSub.setOnClickListener {
            firstTimeAdd = false
            val numA = parseNum(editTextNumA)
            val numB = parseNum(editTextNumB)
            if(!firstTimeSub) {
                val ans = numA - numB
                firstTimeSub = !firstTimeSub
                currentVal = ans
            } else {
                currentVal -= numB
            }
            textViewAns.text = currentVal.toString()
        }

    }

    private fun parseNum(et: EditText): Double {
        return et.text.toString().toDouble()
    }
}
