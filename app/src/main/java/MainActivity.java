package com.example.cgpaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity();
            }
        });

    }


    public void LoginActivity(){
        Intent intentLogin  = new Intent(this,LoginActivity.class);
        startActivity(intentLogin);
    }

    public void RegisterActivity(){
        Intent intentRegister  = new Intent(this,RegisterActivity.class);
        startActivity(intentRegister);
    }


}
