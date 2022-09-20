package com.firstapp.login_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SigninActivity extends AppCompatActivity {
    TextInputLayout username, mobile, mail, pass;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    String usernameStr, mobileStr, mailStr, passStr;
    String userID;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = findViewById(R.id.username1);
        mobile = findViewById(R.id.mobile1);
        mail = findViewById(R.id.signemail1);

        pass = findViewById(R.id.signinpassword1);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);


    }

    public void signup(View view) {

        progressDialog.show();
        progressDialog.setMessage("New Data created!!");

        usernameStr = username.getEditText().getText().toString();
        mobileStr = mobile.getEditText().getText().toString();
        mailStr = mail.getEditText().getText().toString();
        passStr = pass.getEditText().getText().toString();


        firebaseAuth.createUserWithEmailAndPassword(mailStr, passStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (!task.isSuccessful()) {
                    Toast.makeText(SigninActivity.this, "User Registration Successfully" + task.getException(), Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(SigninActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                    userID = firebaseAuth.getCurrentUser().getUid();
//                    DocumentReference documentReference = firebaseFirestore.collection("employee").document(userID);
//                    Map<String, Object> user = new HashMap<>();
//                    user.put("fname", usernameStr);
//                    user.put("mobile", mobileStr);
//                    user.put("email", mailStr);
//                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//                            Log.d("Tag", "User profile created for " + userID);
////                        }
//                    });
                }
            }

            public void privoupage(View view) {
                Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}




