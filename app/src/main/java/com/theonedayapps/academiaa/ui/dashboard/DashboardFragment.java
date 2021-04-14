package com.theonedayapps.academiaa.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText address;
    private EditText mobileno;
    private EditText addharno;
    private Button button;
    private String Name;
    private String Address;
    private String MobileNo;
    private String AddharNo;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                name=root.findViewById(R.id.ais_name);
                address=root.findViewById(R.id.ais_address);
                mobileno=root.findViewById(R.id.ais_mobile_number);
                addharno=root.findViewById(R.id.ais_Addhar);

                button=root.findViewById(R.id.ais_button_save);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Name=name.getText().toString().trim();
                        Address=address.getText().toString().trim();
                        MobileNo=mobileno.getText().toString().trim();
                        AddharNo=addharno.getText().toString().trim();


                            Intent intent=new Intent(getActivity(), User_Info_Activity.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Address",Address);
                            intent.putExtra("MobileNo",MobileNo);
                            intent.putExtra("AddharNo",AddharNo);
                            startActivity(intent);


                    }
                });


                textView.setText(s);
            }
        });
        return root;
    }
}