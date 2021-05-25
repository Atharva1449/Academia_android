package com.theonedayapps.academiaa.ui.home;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.theonedayapps.academiaa.R;
import com.theonedayapps.academiaa.Shareddata.Firebase_verification;
import com.theonedayapps.academiaa.User_Info_Activity;
import com.theonedayapps.academiaa.Useractivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private TextView text;
    private EditText date_Add;
    private EditText sem;
    private RadioGroup radiogrp;
    private RadioButton radiobbtn;
    private RadioGroup radiogrp1;
    private  RadioButton radiobbtn1;
    private RadioGroup radiogrp2;
    private  RadioButton radiobbtn2;
    private RadioGroup radiogrp3;
    private  RadioButton radiobbtn3;
    private String status;
    private String status1;
    private String status2;
    private String status3;
    private String Degree;
    private String Year;
    private String Dept;
    private String AddYear;
    private String Sem1;
    private String Roll_No;
    private Button button;
    private TextView divi1;
    private String divi;

    DataSnapshot dataSnapshot;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final View popupView = inflater.inflate(R.layout.floating_dialog1, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            sem=root.findViewById(R.id.ais_home_semester);
                divi1=root.findViewById(R.id.ais_home_div);

                TextView a1 = popupView.findViewById(R.id.gettextviewRollnum);
                TextView a2 = popupView.findViewById(R.id.gettextviewDepartment);
                TextView a3 = popupView.findViewById(R.id.gettextviewYearofadmission);
                TextView a4 = popupView.findViewById(R.id.gettextviewYear);
                TextView a5 = popupView.findViewById(R.id.gettextviewdivision);
                completion1(a1,a2,a3,a4,a5);


            //
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("message");
// first Radio Group
                radiogrp=(RadioGroup)root.findViewById(R.id.ais_radiogroupid);
                radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        radiobbtn=(RadioButton)root.findViewById(checkedId);
                        switch(checkedId){
                            case R.id.ais_radio_zcoer: {
                                status="EN";
                                Degree="Engineering";

                            }
                            break;
                            case R.id.ais_radio_poly: {
                                status="Po";
                                Degree="Polytechnic";

                            }
                            break;
                            case R.id.ais_radio_mba: {
                                status="Mb";
                                Degree="MBA";
                            }
                            break;

                        }
                    }
                });

// Addmission year
                date_Add=root.findViewById(R.id.ais_name);



//Year Of Addmission
                radiogrp1=(RadioGroup)root.findViewById(R.id.ais_radiogroupid2);
                radiogrp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        radiobbtn1=(RadioButton)root.findViewById(checkedId);
                        switch(checkedId){
                            case R.id.ais_radio_fe: {
                                status2="FE";
                                AddYear="First Year";


                            }
                            break;
                            case R.id.ais_radio_dse: {
                                status2="DSE";
                                AddYear="Direct Second Year";

                            }
                            break;

                        }
                    }
                });
 //Department Radio Group

                radiogrp2=(RadioGroup)root.findViewById(R.id.ais_Radio_Grp_three);
                radiogrp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        radiobbtn2=(RadioButton)root.findViewById(checkedId);
                        switch(checkedId){
                            case R.id.ais_radio_cs: {
                                status3="CS";
                                Dept="Computer";

                            }
                            break;
                            case R.id.ais_radio_mech: {
                                status3="MEC";
                                Dept="Mechanical";

                            }
                            break;
                            case R.id.ais_radio_it: {
                                status3="IT";
                                Dept="IT";

                            }
                            break;
                            case R.id.ais_radio_civil: {
                                status3="CIV";
                                Dept="Civil";

                            }
                            break;
                            case R.id.ais_radio_electrical: {
                                status3="ELE";
                                Dept="Electrical";
                            }
                            break;
                            case R.id.ais_radio_Etc: {
                                status3="E&TC";
                                Dept="E&Tc";

                            }
                            break;

                        }
                    }
                });

// Roll_NO

                    //Roll_No=status3;



// button
                button=root.findViewById(R.id.ais_button_save);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        status1=date_Add.getText().toString().trim();
                        Year=20+date_Add.getText().toString().trim();
                        if(status.length()>0 || status1.length()>0 || status2.length()>0 || status3.length()>0)
                        {
                            Roll_No=status+status1+status2+status3;
                            Sem1=sem.getText().toString().trim();
                            divi=divi1.getText().toString().trim();
                        Intent intent=new Intent(getActivity(), User_Info_Activity.class);

                            final Firebase_verification ver=new Firebase_verification();
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            final DatabaseReference myref1 = database.getReference();
//



                            DatabaseReference ref=FirebaseDatabase.getInstance().getReference();
                            DatabaseReference userNameRef = ref.child("Counter").child(Year).child(Dept);

                            ValueEventListener eventListener = new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot){
                                    if(dataSnapshot.exists()) {
                                        Toast.makeText(getContext(),"Exists",Toast.LENGTH_LONG).show();
                                        //=dataSnapshot.child(Year).child(Dept).getValue().toString();
                                        String value=new String();
                                                value= dataSnapshot.getValue().toString();
                                        myref1.child("Users").child(ver.getFirebase_uid()).child("Roll_no").setValue(Roll_No+value);
                                        int tempint=0;
                                    tempint=Integer.parseInt(value);
                                    tempint++;
                                        value=Integer.toString(tempint);

                                    myref1.child("Counter").child(Year).child(Dept).setValue(value);
                                        Log.d("####rollno2##########",value);

                                    //    break;
                                    }else {
                                        myref1.child("Counter").child(Year).child(Dept).setValue("2");
                                        //temp="1";

                                        myref1.child("Users").child(ver.getFirebase_uid()).child("Roll_no").setValue(Roll_No+"1");
                                        Log.d("#####rollno####",Roll_No);
                                      //  break;
                                    }
                                }


                                @Override
                                public void onCancelled(DatabaseError error) {
                                    // Failed to read value
                                 //   Log.w(TAG, "Failed to read value.", error.toException());
                                }
                                };
                            userNameRef.addListenerForSingleValueEvent(eventListener);
                          //  Log.d("#####################################rollno1###################",Roll_No);
//
                            //myref1.child("Users").child(ver.getFirebase_uid()).child("Roll_no","Degree","Year_admission","Department").setValue(Roll_No,Degree,Year,Dept);
                            myref1.child("Users").child(ver.getFirebase_uid()).child("Degree").setValue(Degree);
                            myref1.child("Users").child(ver.getFirebase_uid()).child("Year_admission").setValue(Year);
                            myref1.child("Users").child(ver.getFirebase_uid()).child("Department").setValue(Dept);
                            myref1.child("Users").child(ver.getFirebase_uid()).child("Semester").setValue(Sem1);
                            myref1.child("Users").child(ver.getFirebase_uid()).child("Attendance").setValue("100");

//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//
//                                    if (task.isSuccessful()) {
//                                        Log.d("*****************message******************","PaSSED");
//                                    } else {
//                                        //display a failure message
//                                    }
//                                }
//                            });
                            //

                        }

                    }
                });

               /* next=root.findViewById(R.id.ais_button_next);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });*/


                textView.setText(s);
            }
        });
        return root;
    }

    private void openDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.floating_dialog1);
        dialog.show();
    }




    public void completion1(TextView a1, TextView a2, TextView a3, TextView a4, TextView a5){
        DatabaseReference myRef;
        // Firebase_verification obj=new Firebase_verification();
        myRef = FirebaseDatabase.getInstance().getReference();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Firebase_verification obj1=new Firebase_verification();
                Useractivity obj=new Useractivity();
                //if(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("check").exists()) {
//                    String check = dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("check").getValue().toString();
                 //   if((Integer.parseInt(check)<3)) {
                        if (dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Roll_no").exists()){
                         //   View popupView = getLayoutInflater().inflate(R.layout.floating_dialog1,container, null);

                        //
                           ;
                            //
                        a1.setText("sddsd");
//                       a2.setText();
//                        a3.setText();
//                        a4.setText();
//                        a5.setText();

                            openDialog();
Log.d("@@@@@@@@@@@@@@@",a2.getText().toString());
                    }

                 //   }
               // }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("value check 2", "Failed to read value.", error.toException());

            }
        });
    }
//    void setval(){
//        View popupView = getLayoutInflater().inflate(R.layout.floating_dialog1, null);
//    TextView a1=popupView.findViewById(R.id.gettextviewRollnum);
//        TextView a2=popupView.findViewById(R.id.gettextviewDepartment);
//        TextView a3=popupView.findViewById(R.id.gettextviewYearofadmission);
//        TextView a4=popupView.findViewById(R.id.gettextviewYear);
//        TextView a5=popupView.findViewById(R.id.gettextviewdivision);
//
//    a1.setText(roll);
//    a2.setText(depart);
//    a3.setText(yoa);
//    a4.setText(yearr);
//    a5.setText(div);
//    }

}