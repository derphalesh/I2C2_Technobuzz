package com.example.parkingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainDashboard extends AppCompatActivity {
    TextView textView19;
    TextView editTextTextPersonName6;
    EditText counter_number;
    Button check_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        Intent int1 = getIntent();
        String unique_key2 =int1.getStringExtra(MainActivity.MSG);

        editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName6);
        counter_number = findViewById(R.id.counter_number);
        check_button = findViewById(R.id.check_button);
        textView19 = findViewById(R.id.textView19);

        textView19.setText(unique_key2);





        editTextTextPersonName6.setText("Empty Slots: 1, 2, 3, 4");

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                editTextTextPersonName6.setText("Empty Slots: 1, 2");
            }
        }, 5000);


        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextTextPersonName6.setText("Empty Slots: 2");
                Toast.makeText(MainDashboard.this, "Park slot 1 Reserved for 5 minutes", Toast.LENGTH_SHORT).show();
            }
        });

    }
}