package com.firstapp.login_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextInputLayout email,pass;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    String mailStr,passStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.Email1);
        pass=findViewById(R.id.Password1);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
    }

    public void login(View view) {

        progressDialog.show();
        progressDialog.setMessage("Verifying User!!");

//
        mailStr=email.getEditText().getText().toString();
        passStr=pass.getEditText().getText().toString();
//
        firebaseAuth.signInWithEmailAndPassword(mailStr,passStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(!task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,ProfileActivity.class));


                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();



            }
        });


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (firebaseAuth.getCurrentUser()!=null)
//        {
//            Toast.makeText(this, "Already User Logged In "+firebaseAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(MainActivity.this,SigninActivity.class));
//
//
//            finish();
//        }
//
//
//
//
//        else
//        {
//            Toast.makeText(this, "New User can Login Now", Toast.LENGTH_SHORT).show();
//            //startActivity(new Intent(MainActivity.this,MainActivity.class));
//        }
//    }

    public void newsignup(View view) {
        Intent intent=new Intent(MainActivity.this,SigninActivity.class);
        startActivity(intent);
    }
}