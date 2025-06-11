package com.example.lab01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class Lab4MainActivity : AppCompatActivity() {
    private lateinit var buttonChooseFood: Button
    private lateinit var buttonChooseDrink: Button
    private lateinit var buttonExit: Button
    private lateinit var textViewSelectedFood: TextView
    private lateinit var textViewSelectedDrink: TextView
    private lateinit var textViewResult: TextView
    
    private var selectedFood: String = ""
    private var selectedDrink: String = ""
    
    private val foodActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            result.data?.getStringExtra("selectedFood")?.let { food ->
                selectedFood = food
                updateDisplay()
            }
        }
    }
    
    private val drinkActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            result.data?.getStringExtra("selectedDrink")?.let { drink ->
                selectedDrink = drink
                updateDisplay()
            }
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_main)
        
        initViews()
        setupButtonListeners()
    }
    
    private fun initViews() {
        buttonChooseFood = findViewById(R.id.buttonChooseFood)
        buttonChooseDrink = findViewById(R.id.buttonChooseDrink)
        buttonExit = findViewById(R.id.buttonExit)
        textViewSelectedFood = findViewById(R.id.textViewSelectedFood)
        textViewSelectedDrink = findViewById(R.id.textViewSelectedDrink)
        textViewResult = findViewById(R.id.textViewResult)
    }
    
    private fun setupButtonListeners() {
        buttonChooseFood.setOnClickListener {
            val intent = Intent(this, FoodActivity::class.java)
            foodActivityLauncher.launch(intent)
        }
        
        buttonChooseDrink.setOnClickListener {
            val intent = Intent(this, DrinkActivity::class.java)
            drinkActivityLauncher.launch(intent)
        }
        
        buttonExit.setOnClickListener {
            finish()
        }
    }
    
    private fun updateDisplay() {
        textViewSelectedFood.text = if (selectedFood.isNotEmpty()) "Thức ăn: $selectedFood" else "Chưa chọn thức ăn"
        textViewSelectedDrink.text = if (selectedDrink.isNotEmpty()) "Đồ uống: $selectedDrink" else "Chưa chọn đồ uống"
        
        textViewResult.text = when {
            selectedFood.isNotEmpty() && selectedDrink.isNotEmpty() -> "$selectedFood - $selectedDrink"
            selectedFood.isNotEmpty() -> selectedFood
            selectedDrink.isNotEmpty() -> selectedDrink
            else -> "Hiển thị kết quả trả về của 2 activity 'Chọn thức ăn' và 'Chọn Đồ uống'"
        }
    }
}