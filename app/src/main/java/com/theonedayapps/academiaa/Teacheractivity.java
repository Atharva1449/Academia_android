package com.theonedayapps.academiaa;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacheractivity extends AppCompatActivity {
private String year;
private String depart;
private EditText title,content,link;
private Button attendance,logoutbutton12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacheractivity);

title=findViewById(R.id.teacher_notice_title);
content=findViewById(R.id.teacher_notice_context);
link=findViewById(R.id.teacher_notice_link);
attendance=findViewById(R.id.button_attendance);
logoutbutton12=findViewById(R.id.teacher_Logout);
        logoutbutton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp=getSharedPreferences("Teacher_Login", MODE_PRIVATE);
                SharedPreferences.Editor Ed=sp.edit();
                Ed.remove("Unm");
                Ed.remove("Psw");
                Ed.clear();
                Ed.commit();
                Intent intent = new Intent(Teacheractivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
attendance.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Teacheractivity.this, Attendance_teacher.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
});
        TextView textviewbranch=findViewById(R.id.textViewdepart);
        RadioGroup radiogrp1 = (RadioGroup) findViewById(R.id.yearteacher);
        radiogrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobbtn = (RadioButton)findViewById(checkedId);
                switch(checkedId){
                    case R.id.Fy_rbutton: {
                      year="1";

                    }
                    break;
                    case R.id.S_rbutton: {
                        year="2";

                    }
                    break;
                    case R.id.T_3: {
                        year="3";
                    }

                    break;
                    case R.id.T_4: {
                        year="4";
                    }
                    break;

                }
            }
        });
        RadioGroup radiogrp2 = (RadioGroup) findViewById(R.id.yeardepartment);
        radiogrp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobbtn = (RadioButton)findViewById(checkedId);
                switch(checkedId){
                    case R.id.Firstyear: {

                        depart="Civil";
                    }
                    break;
                    case R.id.Computer: {
                        depart="Computer";

                    }
                    break;
                    case R.id.IT: {
                        depart="IT";
                    }

                    break;
                    case R.id.Elec: {
                        depart="Electrical";
                    }
                    break;
                    case R.id.Entc: {
                        depart="E&Tc";
                    }
                    break;
                    case R.id.Mech: {
                        depart="Mechanical";
                    }
                    break;
                }
            }
        });

        Button post = findViewById(R.id.teacher_notice_post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref1 = database.getReference();



//
                DatabaseReference myRef;
                // Firebase_verification obj=new Firebase_verification();
                myRef = FirebaseDatabase.getInstance().getReference();


                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // }
if(title.getText().toString().length()>0 && content.getText().toString().length()>0) {
    int count = Integer.parseInt(dataSnapshot.child("Counter").child("Noticecounter").getValue().toString());
if(year.equals("1")){
    depart="Fy";
}
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    String currentDateandTime = sdf.format(new Date());
    myref1.child("Notice").child(year).child(depart).child(String.valueOf(count)).child("title1").setValue(title.getText().toString());
    myref1.child("Notice").child(year).child(depart).child(String.valueOf(count)).child("content1").setValue(content.getText().toString());
    myref1.child("Notice").child(year).child(depart).child(String.valueOf(count)).child("link").setValue(link.getText().toString());
    myref1.child("Notice").child(year).child(depart).child(String.valueOf(count)).child("date").setValue(currentDateandTime);

    count--;

    myref1.child("Counter").child("Noticecounter").setValue(String.valueOf(count));
    openDialog();
}
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("value check 2", "Failed to read value.", error.toException());

                    }
                });
                //
            }


        });
        //firebasefn(textviewbranch,uid);
    }

    private void openDialog() {
        final Dialog dialog = new Dialog(Teacheractivity.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.done);
        dialog.show();
    }
}

































