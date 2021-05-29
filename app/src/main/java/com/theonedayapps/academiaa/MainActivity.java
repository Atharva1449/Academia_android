package com.theonedayapps.academiaa;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.theonedayapps.academiaa.Shareddata.Firebase_verification;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1449;
    private Button Signin;
    private Button Signup;
    private ProgressBar progressBar;
    float x1,x2,y1,y2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Signin=findViewById(R.id.sign_in);
        Signup=findViewById(R.id.Register);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions, PERMISSION_REQUEST_CODE);
            }
        }

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 =new Intent(MainActivity.this,loginact.class);

                // set the new task and clear flags
                int1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);      //Android: Remove all the previous activities from the back stack


                startActivity(int1);

            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 =new Intent(MainActivity.this,Signup.class);
                int1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(int1);

            }
        });
boolean check=false;
        //
        File f = new File(
                "/data/data/com.theonedayapps.academiaa/shared_prefs/Login.xml");
        if (f.exists())
           // Log.d("TAG", "SharedPreferences Name_of_your_preference : exist");
            check=true;

           // Log.d("TAG", "Setup default preferences");
        //
        SharedPreferences sp1=this.getSharedPreferences("Login", MODE_PRIVATE);

        String    email=sp1.getString("Unm", null);
        String    password = sp1.getString("Psw", null);

        if(check==true){
    if(email!=null && !email.equals("")){
        loginUserAccount();

    }}



        //
        File f1 = new File(
                "/data/data/com.theonedayapps.academiaa/shared_prefs/Teacher_Login.xml");
        if (f1.exists())
            // Log.d("TAG", "SharedPreferences Name_of_your_preference : exist");
            check=true;

        // Log.d("TAG", "Setup default preferences");
        //
        SharedPreferences sp11=this.getSharedPreferences("Teacher_Login", MODE_PRIVATE);

        String    email1=sp11.getString("Unm", null);
        String    password1 = sp11.getString("Psw", null);

        if(check==true){
            if(email1!=null && !email1.equals("")){
                teacherloginUserAccount();

            }}
            }

            //


    //

    private void loginUserAccount() {
//        progressBar.setVisibility(View.VISIBLE);

        String email="q", password="q";


        SharedPreferences sp1=this.getSharedPreferences("Login", MODE_PRIVATE);

          email=sp1.getString("Unm", "");
           password = sp1.getString("Psw", "");
                //
                //
///////
        mAuth=FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);

                            String firebase_uid= FirebaseAuth.getInstance().getCurrentUser().getUid();

                            Firebase_verification obj=new Firebase_verification();
                            obj.setFirebase_uid(firebase_uid);

                            //shared prefrences

                            //

                            Intent intent = new Intent(MainActivity.this, Useractivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login failed! Check for password", Toast.LENGTH_LONG).show();
                        //    progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void teacherloginUserAccount() {
//        progressBar.setVisibility(View.VISIBLE);

        String email="q", password="q";


        SharedPreferences sp1=this.getSharedPreferences("Teacher_Login", MODE_PRIVATE);

        email=sp1.getString("Unm", "");
        password = sp1.getString("Psw", "");
        //
        //
///////
        mAuth=FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);

                            String firebase_uid= FirebaseAuth.getInstance().getCurrentUser().getUid();

                            Firebase_verification obj=new Firebase_verification();
                            obj.setFirebase_uid(firebase_uid);

                            //shared prefrences

                            //

                            Intent intent = new Intent(MainActivity.this, Teacheractivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login failed! Check for password", Toast.LENGTH_LONG).show();
                            //    progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    public boolean onTouchEvent( MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(y1>y2){
                    Intent i = new Intent(MainActivity.this, Teacher_login.class);
                    startActivity(i);
                }else if(x1>x2){

                }
                break;
        }
        return false;
    }
}