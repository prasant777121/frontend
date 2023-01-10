package com.example.frontend_insta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frontend_insta.databinding.ActivitySignupBinding;
import com.example.frontend_insta.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    Button btn;
    ActivitySignupBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        btn=findViewById(R.id.signupbtn);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        String email=binding.email.getText().toString();
        String password=binding.pwd.getText().toString();
        String name=binding.Name.getText().toString();
        String profession=binding.profession.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.email.getText().toString();
                String password=binding.pwd.getText().toString();
                auth.createUserWithEmailAndPassword(email,password).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(signup.this, "signup successfully", Toast.LENGTH_SHORT).show();
                                if(task.isSuccessful()){
                                    user User=new user(name,binding.profession.getText().toString(),email,password);
                                    String id=task.getResult().getUser().getUid();
                                    database.getReference().child("users").child(id).setValue(User);
                                    Toast.makeText(signup.this, "signup successfully", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(signup.this, "failed", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });


    }
}