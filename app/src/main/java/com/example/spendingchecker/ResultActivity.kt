package com.example.spendingchecker

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvDisplayResults = findViewById<TextView>(R.id.tvDisplayResults)

        // Get the data sent from MainActivity
        val total = intent.getDoubleExtra("TOTAL", 0.0)
        val average = intent.getDoubleExtra("AVERAGE", 0.0)
        val message = intent.getStringExtra("MESSAGE")

        // Format and display the results
        val finalText = "Total: $total\nAverage: $average\n$message"
        tvDisplayResults.text = finalText
    }
}