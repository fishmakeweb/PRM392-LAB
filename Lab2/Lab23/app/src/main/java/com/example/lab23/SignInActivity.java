package com.example.lab23;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUserName, edtPassword;
    private TextView txtNotAccountYet;
    private Button btnSignIn;

    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        txtNotAccountYet = findViewById(R.id.txtNotAcount);
        btnSignIn = findViewById(R.id.btnSignIn);

        txtNotAccountYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("myPack");
        if (bundle != null) {
            String message = bundle.getString("signup_success");
            if (message != null) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signin), (v, insets) -> {
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
        return true;
    }

    private void signIn() {
        if (!checkInput()) {
            return;
        }
        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("password", password);
        // start main
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("myPackage", bundle);
        startActivity(intent);
        finish(); // close current activity
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSignIn) {
            signIn();
        } else if (v.getId() == R.id.txtNotAcount) {
            signUpForm();
        }

    }
}