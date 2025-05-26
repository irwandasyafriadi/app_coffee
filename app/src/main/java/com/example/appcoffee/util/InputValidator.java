package com.example.appcoffee.util;

import android.text.TextUtils;
import android.widget.EditText;

public class InputValidator {
    public static boolean validateLogin(String email, String password, EditText editEmail, EditText editPassword) {
        if (TextUtils.isEmpty(email)) {
            editEmail.setError("Email tidak boleh kosong");
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Format email salah");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            editPassword.setError("Password tidak boleh kosong");
            return false;
        }
        if (password.length() < 6) {
            editPassword.setError("Password minimal 6 karakter");
            return false;
        }
        return true;
    }
}
