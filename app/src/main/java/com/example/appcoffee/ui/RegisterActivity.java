package com.example.appcoffee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appcoffee.R;
import com.example.appcoffee.data.DatabaseHelper;
import com.example.appcoffee.util.InputValidator;

public class RegisterActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private Button btnRegister;
    private TextView tvLoginLink;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editEmail = findViewById(R.id.edit_email);
        editPassword = findViewById(R.id.edit_password);
        btnRegister = findViewById(R.id.btn_register);
        tvLoginLink = findViewById(R.id.tv_login_link);
        dbHelper = new DatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (InputValidator.validateLogin(email, password, editEmail, editPassword)) {
                if (dbHelper.addUser(email, password)) {
                    Toast.makeText(this, "Registrasi berhasil! Silakan login.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Registrasi gagal. Email mungkin sudah terdaftar.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvLoginLink.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

}
