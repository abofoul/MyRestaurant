package com.omar.restaurantapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    private String TAG = "Registration";

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        final EditText mail = findViewById(R.id.register_mail);
        final EditText password = findViewById(R.id.register_password);
        final EditText passwordConfirm = findViewById(R.id.register_password_confirmation);

        Button register = findViewById(R.id.register_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailText = mail.getText().toString();
                String passwordText = password.getText().toString();
                String passwordConfirmText = passwordConfirm.getText().toString();

                if (IsPasswordOkay(passwordText, passwordConfirmText)) {

                    mAuth.createUserWithEmailAndPassword(mailText, passwordText)
                            .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");

                                        updateUI();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegistrationActivity.this, "Registration failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            }
        });

        TextView login = findViewById(R.id.login_text_view);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateUI() {
        Intent intent = new Intent(RegistrationActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    private Boolean IsPasswordOkay(String password, String passwordConfirmation) {
        if (!password.equals("")) {
            if (password.length() >= 6) {
                if (password.equals(passwordConfirmation)) {
                    return true;
                } else {
                    Toast.makeText(this, "Password confirmation doesn't match the password ", Toast.LENGTH_LONG).show();
                    return false;
                }
            } else {
                Toast.makeText(this, "Password can't be less than 6 characters ", Toast.LENGTH_LONG).show();
                return false;
            }
        } else {
            Toast.makeText(this, "Please fill all empty fields ", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if (mAuth != null) {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                updateUI();
            }
        }
    }

}

