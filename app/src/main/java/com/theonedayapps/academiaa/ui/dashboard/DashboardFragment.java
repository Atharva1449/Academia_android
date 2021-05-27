package com.theonedayapps.academiaa.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private EditText name;
    private EditText dob;
    private EditText address;
    private EditText mobileno;
    private EditText addharno;
    private EditText father_name;
    private EditText mother_name;
    private EditText guardian;
    private EditText panno;
    private EditText caste;
    private EditText category;
    private EditText bloodgrp;
    private EditText gender;

    private Button button;
    private String Name;
    private String Address;
    private String MobileNo;
    private String AddharNo;
    private String Dob;

    private String Father_Name;
    private String Mother_Name;
    private String Caste;
    private String Category;
    private String BloodGrp;
    private String Gender;
    private String PANNo;
    private String Guardian;
    private RadioGroup  radiogrp;
    private RadioButton radiobbtn;
    private String Category_one;

    private  TextView a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                a1=root.findViewById(R.id.textdashboardname);
                a2=root.findViewById(R.id.textdashboarddob);
                a3=root.findViewById(R.id.textdashboarfathername);
                a4=root.findViewById(R.id.textdashboardmothersname);
                a5=root.findViewById(R.id.textdashboardgaurdians);
                a6=root.findViewById(R.id.textdashboardgender);
                a7=root.findViewById(R.id.textdashboardbloodgroup);
                a8=root.findViewById(R.id.textdashboardcaste);
                a9=root.findViewById(R.id.textdashboardCategory);
                a10=root.findViewById(R.id.textdashboardAdhar);
                a11=root.findViewById(R.id.textdashboardpan);
                LinearLayout scrollView1=root.findViewById(R.id.scrollviewdashboardmain);
                LinearLayout scrollView2=root.findViewById(R.id.scrollviewdashboard1);
completion1(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,scrollView1,scrollView2);

                name=root.findViewById(R.id.ais_name);
                dob=root.findViewById(R.id.ais_Date_of_Birth);
                mobileno=root.findViewById(R.id.ais_Mobileno);
                addharno=root.findViewById(R.id.ais_dashboar_adharno);
                father_name=root.findViewById(R.id.ais_fathername);
                mother_name=root.findViewById(R.id.ais_mothername);
                guardian=root.findViewById(R.id.ais_guardianname);
                bloodgrp=root.findViewById(R.id.ais_bloodgrp);
                caste=root.findViewById(R.id.ais_dashboard_caste);
                panno=root.findViewById(R.id.ais_dshboard_panno);
bloodgrp=root.findViewById(R.id.ais_bloodgrp);
                gender=root.findViewById(R.id.ais_gender);

                radiogrp=(RadioGroup)root.findViewById(R.id.ais_dashboard_radiogroupid);
                radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        radiobbtn=(RadioButton)root.findViewById(checkedId);
                        switch(checkedId){
                            case R.id.ais_radio_open: {
                                Category_one="OPEN";
                            }
                            break;
                            case R.id.ais_radio_obc: {
                                Category_one="OBC";

                            }
                            break;
                            case R.id.ais_radio_sc: {
                                Category_one="SC";
                            }
                            break;
                            case R.id.ais_radio_st: {
                                Category_one="ST";
                            }
                            break;

                        }
                    }
                });

                button=root.findViewById(R.id.ais_save_dashboard);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Name=name.getText().toString().trim();
                        Dob=dob.getText().toString().trim();
                        MobileNo=mobileno.getText().toString().trim();
                        Father_Name=father_name.getText().toString().trim();
                        Mother_Name=mother_name.getText().toString().trim();
                        Guardian=guardian.getText().toString().trim();
                        //Address=address.getText().toString().trim();
                        Gender=gender.getText().toString().trim();
                        Caste=caste.getText().toString().trim();
                  //      Category=category.getText().toString().trim();
                        AddharNo=addharno.getText().toString().trim();
                        PANNo=panno.getText().toString().trim();

                        Intent intent=new Intent(getActivity(), User_Info_Activity.class);

                        Firebase_verification ver1=new Firebase_verification();
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myref1 = database.getReference();

                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Name").setValue(Name);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Dob").setValue(Dob);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Father_name").setValue(Father_Name);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Mother_name").setValue(Mother_Name);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Guardian_name").setValue(Guardian);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Gender").setValue(Gender);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Blood").setValue(bloodgrp.getText().toString().trim());

                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Caste").setValue(Caste);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("category").setValue(Category_one);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("Adhar_no").setValue(AddharNo);
                        myref1.child("Users").child(ver1.getFirebase_uid()).child("PAN_no").setValue(PANNo);

                        //myref1.child("Users").child(ver.getFirebase_uid()).child("").setValue();







                    }
                });


               // textView.setText(s);
            }
        });
        return root;
    }

    public void completion1(TextView a1, TextView a2, TextView a3, TextView a4, TextView a5, TextView a6,TextView a7,TextView a8,TextView a9,TextView a10,TextView a11, LinearLayout scrollView1, LinearLayout scrollView2){
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
                if (dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Name").exists() && dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Adhar_no").exists() && dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Caste").exists() ){
                    //   View popupView = getLayoutInflater().inflate(R.layout.floating_dialog1,container, null);

                    //
                    ;
                    //
                    scrollView1.setVisibility(View.GONE);
                    scrollView2.setVisibility(View.VISIBLE);
                    a1.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Name").getValue().toString());
                    a2.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Dob").getValue().toString());
                    a3.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Father_name").getValue().toString());
                    a4.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Mother_name").getValue().toString());
                    a5.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Guardian_name").getValue().toString());
                    a6.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Gender").getValue().toString());
                    a7.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Blood").getValue().toString());
                    a8.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Caste").getValue().toString());
                    a9.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("category").getValue().toString());
                    a10.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Adhar_no").getValue().toString());
                    a11.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("PAN_no").getValue().toString());

                    //  openDialog();
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
}