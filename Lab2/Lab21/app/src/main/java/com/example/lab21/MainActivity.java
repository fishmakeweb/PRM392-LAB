package com.example.lab21;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button generate;
    EditText edtMin, edtMax;

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        generate = findViewById(R.id.btnGenerate);
        edtMin = findViewById(R.id.editMin);
        edtMax = findViewById(R.id.editMax);
        generate = findViewById(R.id.btnGenerate);
        edtMin = findViewById(R.id.editMin);
        edtMax = findViewById(R.id.editMax);
        txtResult = findViewById(R.id.txtResult2);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int min = Integer.parseInt(edtMin.getText().toString());
                    int max = Integer.parseInt(edtMax.getText().toString());
                    if (min > max) {
                        txtResult.setText("Min must be <= Max");
                        return;
                    }
                    int result = new Random().nextInt(max - min + 1) + min;
                    txtResult.setText(result + "");
                } catch (NumberFormatException e) {
                    txtResult.setText("Invalid input!");
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}