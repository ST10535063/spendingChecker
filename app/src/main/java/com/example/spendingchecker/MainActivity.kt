package com.example.spendingchecker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the views
        val etDay1 = findViewById<EditText>(R.id.etDay1)
        val etDay2 = findViewById<EditText>(R.id.etDay2)
        val etDay3 = findViewById<EditText>(R.id.etDay3)
        val etDay4 = findViewById<EditText>(R.id.etDay4)
        val etDay5 = findViewById<EditText>(R.id.etDay5)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            // Get values from EditTexts (default to 0.0 if empty)
            val day1 = etDay1.text.toString().toDoubleOrNull() ?: 0.0
            val day2 = etDay2.text.toString().toDoubleOrNull() ?: 0.0
            val day3 = etDay3.text.toString().toDoubleOrNull() ?: 0.0
            val day4 = etDay4.text.toString().toDoubleOrNull() ?: 0.0
            val day5 = etDay5.text.toString().toDoubleOrNull() ?: 0.0

            // Store values in an array
            val spendingArray = arrayOf(day1, day2, day3, day4, day5)

            // Use a loop to calculate total spending
            var totalSpending = 0.0
            for (i in 0..4) {
                totalSpending = totalSpending + spendingArray[i]
            }

            // Calculate average
            val averageSpending = totalSpending / 5

            // Use an If statement for the message
            var message = ""
            if (averageSpending > 100) {
                message = "You are spending too much!"
            } else {
                message = "Your spending is under control."
            }

            // Send to ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("TOTAL", totalSpending)
            intent.putExtra("AVERAGE", averageSpending)
            intent.putExtra("MESSAGE", message)
            startActivity(intent)
        }
    }
}