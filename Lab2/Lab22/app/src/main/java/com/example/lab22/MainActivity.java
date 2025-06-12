package com.example.lab22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtF, edtS;

    Button btnP, btnMinus, btnMulti, btnDiv;

    TextView txtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtF = findViewById(R.id.edtFirst);
        edtS = findViewById(R.id.edtSec);
        btnP = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        txtR = findViewById(R.id.txtRes);
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(edtF.getText().toString());
                float b = Float.parseFloat(edtS.getText().toString());
                float sum = a + b;
                txtR.setText("Kết quả : " + String.format("%.2f", sum));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(edtF.getText().toString());
                float b = Float.parseFloat(edtS.getText().toString());
                float minus = a - b;
                txtR.setText("Kết quả : " + String.format("%.2f", minus));
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(edtF.getText().toString());
                float b = Float.parseFloat(edtS.getText().toString());
                float multi = a * b;
                txtR.setText("Kết quả : " + String.format("%.2f", multi));
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(edtF.getText().toString());
                float b = Float.parseFloat(edtS.getText().toString());
                if (b == 0) {
                    txtR.setText("Không chia được cho 0");
                    return;
                }
                float div = a / b;
                txtR.setText("Kết quả : " + String.format("%.2f", div));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}