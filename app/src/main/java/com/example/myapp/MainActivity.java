package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogIn;
    private Button btnfacebook;
    private Button btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        setupUi();
    }

    // Initialize UI
    private void initUi() {
        btnLogIn = findViewById(R.id.buttonLogin);
        btnfacebook = findViewById(R.id.buttonFacebook);
        btnGoogle = findViewById(R.id.buttonGoogle);
    }

    // Bind events
    private void setupUi() {
        setClickables();

        btnLogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Log In", Toast.LENGTH_SHORT).show();
            }
        });

        btnfacebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Google", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Set clickable text view
    private void setClickables() {
        TextView signUpNow = findViewById(R.id.textViewSignUp);
        String signUpText = "Don't have an account? Sign up Now !";
        SpannableString signUpTextSpannable = new SpannableString(signUpText);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#DD0096FF"));
                ds.setUnderlineText(false);
            }
        };

        signUpTextSpannable.setSpan(clickableSpan, 23, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUpNow.setText(signUpTextSpannable);
        signUpNow.setMovementMethod(LinkMovementMethod.getInstance());
    }
}