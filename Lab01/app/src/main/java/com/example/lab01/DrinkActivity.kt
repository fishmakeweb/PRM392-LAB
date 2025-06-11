package com.example.lab01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class DrinkActivity : AppCompatActivity() {
    private lateinit var radioGroupDrink: RadioGroup
    private lateinit var buttonOrder: Button
    
    private val drinkOptions = arrayOf(
        "Pepsi",
        "Heineken",
        "Tiger",
        "Sài gòn Đỏ"
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)
        
        initViews()
        setupDrinkOptions()
        setupOrderButton()
    }
    
    private fun initViews() {
        radioGroupDrink = findViewById(R.id.radioGroupDrink)
        buttonOrder = findViewById(R.id.buttonOrder)
    }
    
    private fun setupDrinkOptions() {
        drinkOptions.forEach { drink ->
            val radioButton = RadioButton(this)
            radioButton.text = drink
            radioButton.textSize = 16f
            radioButton.setPadding(0, 16, 0, 16)
            radioGroupDrink.addView(radioButton)
        }
    }
    
    private fun setupOrderButton() {
        buttonOrder.setOnClickListener {
            val selectedId = radioGroupDrink.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val selectedDrink = selectedRadioButton.text.toString()
                
                val resultIntent = Intent()
                resultIntent.putExtra("selectedDrink", selectedDrink)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}