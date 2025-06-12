package com.example.lab23;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUserName, edtPassword, edtConfirmPassword;

    private Button btnSignUp;

    private TextView txtAlready;

    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        txtAlready = findViewById(R.id.txtAlready);

        txtAlready.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signup), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(edtUserName.getText().toString())) {
            edtUserName.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(edtPassword.getText().toString())) {
            edtPassword.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(edtConfirmPassword.getText().toString())) {
            edtConfirmPassword.setError(REQUIRE);
            return false;
        }
        if (!TextUtils.equals(edtPassword.getText().toString(), edtConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void signUp() {
        if (!checkInput()) {
            return;
        }
        Intent intent = new Intent(this, SignInActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("signup_success", "Sign Up success, please login");
        intent.putExtra("myPack", bundle);
        startActivity(intent);
        finish();
    }

    private void singInForm() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtAlready) {
            singInForm();
        }
        if (v.getId() == R.id.btnSignUp) {
            signUp();
        }
    }
}