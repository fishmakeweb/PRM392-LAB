package com.example.lab01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class FoodActivity : AppCompatActivity() {
    private lateinit var radioGroupFood: RadioGroup
    private lateinit var buttonOrder: Button
    
    private val foodOptions = arrayOf(
        "Phở Hà Nội",
        "Bún Bò Huế", 
        "Mì Quảng",
        "Hủ Tíu Sài Gòn"
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        
        initViews()
        setupFoodOptions()
        setupOrderButton()
    }
    
    private fun initViews() {
        radioGroupFood = findViewById(R.id.radioGroupFood)
        buttonOrder = findViewById(R.id.buttonOrder)
    }
    
    private fun setupFoodOptions() {
        foodOptions.forEach { food ->
            val radioButton = RadioButton(this)
            radioButton.text = food
            radioButton.textSize = 16f
            radioButton.setPadding(0, 16, 0, 16)
            radioGroupFood.addView(radioButton)
        }
    }
    
    private fun setupOrderButton() {
        buttonOrder.setOnClickListener {
            val selectedId = radioGroupFood.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val selectedFood = selectedRadioButton.text.toString()
                
                val resultIntent = Intent()
                resultIntent.putExtra("selectedFood", selectedFood)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}