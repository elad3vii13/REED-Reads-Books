package com.minhalreads.androidenglishreadingtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public String fullName = "Default Name";
    private static final int SPLASH_TIME_OUT = 1200;
    TextView welcome_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        welcome_tv = findViewById(R.id.welcome_tv);

        SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
        fullName = sharedPreferences.getString("FULL_NAME", "Default Name");

        if (fullName != "Default Name") {
            welcome_tv.setText("Welcome Back, " + fullName);
            waitToAcitivity();
        }
        else {
            popupFunction();
        }
    }

    public void waitToAcitivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(LoginActivity.this, Timer.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    public void popupFunction() {
        AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
        alert.setTitle("Enter Your Full Name");
        alert.setCancelable(false);

        // Set an EditText view to get user input
        final EditText input = new EditText(LoginActivity.this);
        alert.setView(input);
        input.setText("");

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                if(input.getText().toString().matches("")) {
                    Toast.makeText(LoginActivity.this, "You can change your name in the 'about' page", Toast.LENGTH_SHORT).show();
                    fullName = input.getText().toString();
                    //FULL_NAME = input.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FULL_NAME", "Default Name");
                    editor.apply();
                    waitToAcitivity();
                }
                else{
                    fullName = input.getText().toString();
                    Toast.makeText(LoginActivity.this, "Welcome, " + fullName, Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("shared preference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FULL_NAME", fullName);
                    editor.apply();
                    waitToAcitivity();
                }
            }
        });
        alert.show();
    }
}