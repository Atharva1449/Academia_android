package com.theonedayapps.academiaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.theonedayapps.academiaa.Shareddata.User;

public class Signup extends AppCompatActivity {
private Button back;
private Button signup;
private String email;
private String password;
private String copassword;
private EditText emailid;
private EditText password1;
private EditText confirmpassword;
private TextView statustext;
private ProgressBar progressBar;


    private FirebaseAuth mAuth;
    private static final String TAG = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        emailid=(EditText) findViewById(R.id.editTextEmailsignup);
        password1=(EditText) findViewById(R.id.editTextTextPasswordsignup);
        confirmpassword=(EditText) findViewById(R.id.confirmpassword);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        back =findViewById(R.id.backbutton);
        signup =findViewById(R.id.signup_button);
        statustext=findViewById(R.id.statustext);
////////////////////////////////////////////////////////////////////////

 email=emailid.getText().toString().trim();
 password=password1.getText().toString().trim();;





        ////////////////////////////////////////////////////////////////
        back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent int1 =new Intent(Signup.this,MainActivity.class);

        // set the new task and clear flags
        int1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);      //Android: Remove all the previous activities from the back stack


        startActivity(int1);
    }
});

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=emailid.getText().toString().trim();
                password=password1.getText().toString().trim();
                copassword=confirmpassword.getText().toString().trim();

                if(email.length() <= 0 || password.length() <= 0  || copassword.length() <= 0 ){
                statustext.setText("*Some of the contents are empty");
                }
                else{
                    if(password.equals(copassword)){

                        createAccount(email,password);

                    }else {
                        statustext.setText("*Passwords don't match");

                    }
                }


            }
        });

       // createAccount("abc1@atha.com", "password");
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void createAccount(String email, String password) {
        progressBar.setVisibility(View.VISIBLE);
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Signup.this, "Authentication successful",
                                    Toast.LENGTH_SHORT).show();
                            //
//                            User user1=new User("","","","","","","","","","","","","","","","","","","","","");
//
//                            FirebaseDatabase.getInstance().getReference("Users")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                    .setValue(user1).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    progressBar.setVisibility(View.GONE);
//                                    if (task.isSuccessful()) {
//                                       Toast.makeText(Signup.this, "done", Toast.LENGTH_LONG).show();
//                                    } else {
//                                        //display a failure message
//                                    }
//                                }
//                            });
                            //

                            Intent intent=new Intent(Signup.this,loginact.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }
    private void reload() { }
    private void updateUI(FirebaseUser user) {

    }
}