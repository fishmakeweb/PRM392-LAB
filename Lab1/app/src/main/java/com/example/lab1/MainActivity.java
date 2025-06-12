package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupButtonListeners();
    }

    private void setupButtonListeners() {
        Button btnLayout1 = findViewById(R.id.btn_layout1);
        btnLayout1.setOnClickListener(v -> startActivity(new Intent(this, Layout1Activity.class)));

        Button btnLayout2 = findViewById(R.id.btn_layout2);
        btnLayout2.setOnClickListener(v -> startActivity(new Intent(this, Layout2Activity.class)));

        Button btnLayout3 = findViewById(R.id.btn_layout3);
        btnLayout3.setOnClickListener(v -> startActivity(new Intent(this, Layout3Activity.class)));

        Button btnLayout4 = findViewById(R.id.btn_layout4);
        btnLayout4.setOnClickListener(v -> startActivity(new Intent(this, Layout4Activity.class)));

        Button btnLayout5 = findViewById(R.id.btn_layout5);
        btnLayout5.setOnClickListener(v -> startActivity(new Intent(this, Layout5Activity.class)));
    }
}