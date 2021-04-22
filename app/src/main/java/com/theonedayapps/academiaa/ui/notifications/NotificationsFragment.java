package com.theonedayapps.academiaa.ui.notifications;

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

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private EditText mobileno;
    private EditText parentno;
    private EditText address;
    private EditText state;
    private EditText city;
    private EditText pincode;

    private Button button;
    private String Add;
    private String Adress;
    private String State;
    private String City;
    private String Pincode;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                address=root.findViewById(R.id.ais_navigation_Addresa);
                city=root.findViewById(R.id.ais_navigation_City);
                state=root.findViewById(R.id.ais_navigation_state);
                pincode=root.findViewById(R.id.ais_navigation_pincode);
                mobileno=root.findViewById(R.id.ais_navigation_student_no);
                parentno=root.findViewById(R.id.ais_navigation_parentno);

                button=root.findViewById(R.id.ais_notification_save);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Add=address.getText().toString().trim()+city.getText().toString().trim()+pincode.getText().toString().trim()+state.getText().toString().trim();
                            /*
                            Intent intent=new Intent(getActivity(), User_Info_Activity.class);
                            intent.putExtra("Roll_No",Roll_No);
                            intent.putExtra("Degree",Degree);
                            intent.putExtra("Year",Year);
                            intent.putExtra("Dept",Dept);
                            intent.putExtra("AddYear",AddYear);
                            startActivity(intent);*/


                    }
                });

                textView.setText(s);
            }
        });
        return root;
    }
}