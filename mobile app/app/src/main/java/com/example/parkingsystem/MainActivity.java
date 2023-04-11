package com.example.parkingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "order";

    private EditText emailTxt;
    private EditText passTxt;
    private Button loginUser;
    private TextView signupRedirectText ;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTxt = findViewById(R.id.emaillogin);
        passTxt = findViewById(R.id.passwordlogin);
        loginUser = findViewById(R.id.loginbutton);
        signupRedirectText = findViewById(R.id.signUpRedirectText);

        auth = FirebaseAuth.getInstance();

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = emailTxt.getText().toString();
                String txt_password = passTxt.getText().toString();
                if (txt_email.isEmpty() || txt_password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill all the details", Toast.LENGTH_SHORT).show();
                }
                else{
                    loginUser(txt_email,txt_password);
                }

            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                finish();
            }
        });



    }


    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Login Successfully..", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MainDashboard.class);
                    intent.putExtra(MSG,emailTxt.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Failed !", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}