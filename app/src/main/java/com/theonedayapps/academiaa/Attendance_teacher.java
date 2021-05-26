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

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Attendance_teacher extends AppCompatActivity {
private Button button,buttonlogout,buttonnotice,buttonsubmit;
private static String year,depart,subject;
private static String div;
private EditText di,sub;
   private Attendance_teacher_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_teacher);
    button=findViewById(R.id.button2);
    buttonlogout=findViewById(R.id.teacher_Logout1);
    buttonnotice=findViewById(R.id.button_notice1);
    buttonsubmit=findViewById(R.id.submit);
    di=findViewById(R.id.editTextdivision);
    sub=findViewById(R.id.editTextsubject);
        RadioGroup radiogrp1 = (RadioGroup) findViewById(R.id.yearteacher);
        radiogrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiobbtn = (RadioButton)findViewById(checkedId);
                switch(checkedId){
                    case R.id.Fy_rbutton: {
                        year="1";
                        setYear2(year);
                    }
                    break;
                    case R.id.S_rbutton: {
                        year="2";
                        setYear2(year);
                    }
                    break;
                    case R.id.T_3: {
                        year="3";
                        setYear2(year);
                    }

                    break;
                    case R.id.T_4: {
                        year="4";
                        setYear2(year);
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
                        setDepart(depart);
                    }
                    break;
                    case R.id.Computer: {
                        depart="Computer";
                        setDepart(depart);
                    }
                    break;
                    case R.id.IT: {
                        depart="IT";
                        setDepart(depart);
                    }

                    break;
                    case R.id.Elec: {
                        depart="Electrical";
                        setDepart(depart);
                    }
                    break;
                    case R.id.Entc: {
                        depart="E&Tc";
                        setDepart(depart);
                    }
                    break;
                    case R.id.Mech: {
                        depart="Mechanical";
                        setDepart(depart);
                    }
                    break;
                }
            }
        });

        buttonnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Attendance_teacher.this, Teacheractivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);}
        });
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp=getSharedPreferences("Teacher_Login", MODE_PRIVATE);
                SharedPreferences.Editor Ed=sp.edit();
                Ed.remove("Unm");
                Ed.remove("Psw");
                Ed.clear();
                Ed.commit();
                Intent intent = new Intent(Attendance_teacher.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerattendance);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        div=di.getText().toString();
        subject=sub.getText().toString();
        setDiv(div);
        setYear2(year);
        setSubject3(subject);
        if(year.equals("1")){
            depart="Fy";
            setDepart(depart);
        }else {
            setDepart(depart);
        }


            re(recyclerView);


            // To display the Recycler view linearly

//

            //

        }

    });
    buttonsubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Read from the database
            DatabaseReference myRef;
            // Firebase_verification obj=new Firebase_verification();
            myRef = FirebaseDatabase.getInstance().getReference();

            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child("Academics").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").exists()) {

        String a= dataSnapshot.child("Academics").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").getValue().toString();
        int b =Integer.parseInt(a)+1;
        Log.d("@@@&&&&value a&&&&&&&",a);
        myRef.child("Academics").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").setValue(String.valueOf(b));

        }else{
        myRef.child("Academics").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").setValue("1");

        }

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("asas", "Failed to read value.", error.toException());
                }
            });

            Intent intent = new Intent(Attendance_teacher.this, Attendance_teacher.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            openDialog();
            startActivity(intent);
        }

    });


    }

    public String getYear2() {
        return year;
    }

    public void setYear2(String year) {
        this.year = year;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    public String  getSubject3() {
        return subject;
    }

    public void setSubject3(String subject) {
        this.subject = subject;
    }






private void re(RecyclerView recyclerView){
    recyclerView.setLayoutManager(
            new LinearLayoutManager(Attendance_teacher.this));

    // It is a class provide by the FirebaseUI to make a
    // query in the database to fetch appropriate data
    FirebaseRecyclerOptions<Attendance_teacherHandle> options
            = new FirebaseRecyclerOptions.Builder<Attendance_teacherHandle>()
            .setQuery(FirebaseDatabase.getInstance().getReference().child("Classroom").child(getYear2()).child(getDepart()).child(getDiv()), Attendance_teacherHandle.class)
            .build();
    // Connecting object of required Adapter class to
    // the Adapter class itself
    adapter = new Attendance_teacher_Adapter(options);
    // Connecting Adapter class with the Recycler view
    recyclerView.setAdapter(adapter);
    adapter.startListening();
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }
}
    private void openDialog() {
        final Dialog dialog = new Dialog(Attendance_teacher.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.done);
        dialog.show();
    }
}

//
//if(dataSnapshot.child("Classroom").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").exists()) {
//
//        String a= dataSnapshot.child("Classroom").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").getValue().toString();
//        int b =Integer.parseInt(a)+1;
//        Log.d("@@@&&&&value a&&&&&&&",a);
//        myref1.child("Classroom").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").setValue(String.valueOf(b));
//
//        }else{
//        myref1.child("Classroom").child(getYear2()).child(getDepart()).child(getDiv()).child("Totallecnow").setValue(obj.getSubject3());
//
//        }