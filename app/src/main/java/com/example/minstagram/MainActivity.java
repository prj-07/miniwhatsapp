package com.example.minstagram;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textemail;
    TextInputEditText textpassword;
    TextView txtregister;
    Button btnlogin;
    Button forget;

    EditText name;
     FirebaseAuth mAuth;

     private String naam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        txtregister = (TextView)findViewById(R.id.txtregister);
        //txtregister.setOnClickListener();
        textemail = findViewById(R.id.textemail);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        forget = (Button)findViewById(R.id.foregtpass);
        textpassword = findViewById(R.id.textpassword);
        name = (EditText) findViewById(R.id.nametext);
        txtregister.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        });
        btnlogin.setOnClickListener(view -> {
            loginUser(/*new Intent(loginActivity.this,"")*/);

        });
       /* btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });*/
        forget.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,ForgetPassword.class));
        });

    }

   /* private void sendData() {
        naam = name.getText().toString();

        Intent i = new Intent(MainActivity.this,welcome.class);
        i.putExtra("name",naam);
        startActivity(i);

    }*/

    private void loginUser(){
        String email = textemail.getText().toString();
        String password = textpassword.getText().toString();
        if (TextUtils.isEmpty(email)){
            textemail.setError("Email cannot be Empty");
            textpassword.requestFocus();
        }
        else if (TextUtils.isEmpty(password)){
            textpassword.setError("Password cannot be empty");
            textpassword.requestFocus();
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "User Logged in Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,welcome.class));
                    }
                    else{
                        Toast.makeText(MainActivity.this, "log in error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}