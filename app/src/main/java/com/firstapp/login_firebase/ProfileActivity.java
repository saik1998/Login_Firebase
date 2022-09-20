package com.firstapp.login_firebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    TextView firstname,lastname,email;
    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//
//        firstname=findViewById(R.id.profilefirst);
//        lastname=findViewById(R.id.profilelastname);
//        email=findViewById(R.id.profileemail);

        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();

        userId=firebaseAuth.getCurrentUser().getUid();

//
//        DocumentReference documentReference=firebaseFirestore.collection("users").document(userId);
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                firstname.setText(value.getString("fname"));
//                lastname.setText(value.getString("lname"));
//                email.setText(value.getString("email"));
//            }
//        });





    }


    public void signout(View view) {
        Toast.makeText(this, "user signout successfully", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void privoupage(View view) {
        Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
        startActivity(intent);
    }
}