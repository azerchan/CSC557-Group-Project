package com.example.cgpaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    Button btnCalcGPA, btnCalcCGPA, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // assign buttons
        btnCalcGPA = (Button) findViewById(R.id.btnCalcGPA);
        btnCalcCGPA = (Button) findViewById(R.id.btnCalcCGPA);
        btnLogout = (Button) findViewById(R.id.btnLogout);


        // functions
        btnCalcGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcGPAActivity();
            }
        });

        btnCalcCGPA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CalcCGPAActivity();
            }
        });


        /* btnViewAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewAccountActivity();
            }
        }); */

        btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LogoutActivity();
                Toast.makeText(DashboardActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // methods (outside of OnCreate)
    public void CalcGPAActivity(){
        Intent intentCalcGPA  = new Intent(this,CalcGPAActivity.class);
        startActivity(intentCalcGPA);
    }

    public void CalcCGPAActivity(){
        Intent intentCalcCGPA  = new Intent(this,CalcCGPAActivity.class);
        startActivity(intentCalcCGPA);
    }

    public void LogoutActivity(){
        Intent intentLogout  = new Intent(this,MainActivity.class);
        startActivity(intentLogout);
    }
}
