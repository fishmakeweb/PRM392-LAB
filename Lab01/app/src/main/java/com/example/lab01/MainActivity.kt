package com.example.lab01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        findViewById<Button>(R.id.btn_layout1).setOnClickListener {
            startActivity(Intent(this, Layout1Activity::class.java))
        }

        findViewById<Button>(R.id.btn_layout2).setOnClickListener {
            startActivity(Intent(this, Layout2Activity::class.java))
        }

        findViewById<Button>(R.id.btn_layout3).setOnClickListener {
            startActivity(Intent(this, Layout3Activity::class.java))
        }

        findViewById<Button>(R.id.btn_layout4).setOnClickListener {
            startActivity(Intent(this, Layout4Activity::class.java))
        }

        findViewById<Button>(R.id.btn_layout5).setOnClickListener {
            startActivity(Intent(this, Layout5Activity::class.java))
        }
        
        findViewById<Button>(R.id.btn_lab4).setOnClickListener {
            startActivity(Intent(this, Lab4MainActivity::class.java))
        }
        
        findViewById<Button>(R.id.btn_lab5).setOnClickListener {
            startActivity(Intent(this, Lab5MainActivity::class.java))
        }
    }
}