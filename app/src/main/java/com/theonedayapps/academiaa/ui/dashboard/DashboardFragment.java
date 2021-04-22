package com.theonedayapps.academiaa.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.theonedayapps.academiaa.R;
import com.theonedayapps.academiaa.User_Info_Activity;

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


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                name=root.findViewById(R.id.ais_name);
                dob=root.findViewById(R.id.ais_Date_of_Birth);
                mobileno=root.findViewById(R.id.ais_Mobileno);
                addharno=root.findViewById(R.id.ais_dashboar_adharno);
                father_name=root.findViewById(R.id.ais_fathername);
                mother_name=root.findViewById(R.id.ais_mothername);
                guardian=root.findViewById(R.id.ais_guardianname);
                bloodgrp=root.findViewById(R.id.ais_bloodgrp);


                gender=root.findViewById(R.id.ais_gender);

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
                        Address=address.getText().toString().trim();
                        Gender=gender.getText().toString().trim();
                        Caste=caste.getText().toString().trim();
                        Category=category.getText().toString().trim();
                        AddharNo=addharno.getText().toString().trim();
                        PANNo=panno.getText().toString().trim();

                            /*Intent intent=new Intent(getActivity(), User_Info_Activity.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Dob",Dob);
                            intent.putExtra("Address",Address);
                            intent.putExtra("MobileNo",MobileNo);
                            intent.putExtra("AddharNo",AddharNo);
                            startActivity(intent);*/

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


                    }
                });


               // textView.setText(s);
            }
        });
        return root;
    }
}