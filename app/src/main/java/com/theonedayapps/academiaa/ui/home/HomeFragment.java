package com.theonedayapps.academiaa.ui.home;

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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private TextView text;
    private EditText date_Add;
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
    private String Roll_No;
    private Button button;
    private Button next;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {



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
                        Intent intent=new Intent(getActivity(), User_Info_Activity.class);
                        intent.putExtra("Roll_No",Roll_No);
                        intent.putExtra("Degree",Degree);
                        intent.putExtra("Year",Year);
                        intent.putExtra("Dept",Dept);
                        intent.putExtra("AddYear",AddYear);
                        startActivity(intent);
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



}