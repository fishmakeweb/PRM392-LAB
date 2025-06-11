package com.example.lab45

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val buttonLab4 = findViewById<Button>(R.id.buttonLab4)
        val buttonLab5 = findViewById<Button>(R.id.buttonLab5)
        
        buttonLab4.setOnClickListener {
            startActivity(Intent(this, Lab4MainActivity::class.java))
        }
        
        buttonLab5.setOnClickListener {
            startActivity(Intent(this, Lab5MainActivity::class.java))
        }
    }
}