package com.theonedayapps.academiaa.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.theonedayapps.academiaa.Useractivity;

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

                TextView a1 = root.findViewById(R.id.textnotificationaddress);
                TextView a2 = root.findViewById(R.id.textnotificationmob1);
                TextView a3 = root.findViewById(R.id.textnotificationmob2);
                LinearLayout scrollView1=root.findViewById(R.id.scrollviewnotificationmain1);
                LinearLayout scrollView2=root.findViewById(R.id.scrollviewnotification1);
                completion1(a1,a2,a3,scrollView1,scrollView2);
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

                        Add=address.getText().toString().trim()+" "+city.getText().toString().trim()+" "+pincode.getText().toString().trim()+" "+state.getText().toString().trim();


                            /*
                            Intent intent=new Intent(getActivity(), User_Info_Activity.class);
                            intent.putExtra("Roll_No",Roll_No);
                            intent.putExtra("Degree",Degree);
                            intent.putExtra("Year",Year);
                            intent.putExtra("Dept",Dept);
                            intent.putExtra("AddYear",AddYear);
                            startActivity(intent);*/
                        Firebase_verification ver=new Firebase_verification();
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myref1 = database.getReference();


                        myref1.child("Users").child(ver.getFirebase_uid()).child("Phone_no1").setValue(mobileno.getText().toString());
                        myref1.child("Users").child(ver.getFirebase_uid()).child("Phone_no2").setValue(parentno.getText().toString());
                        myref1.child("Users").child(ver.getFirebase_uid()).child("Address").setValue(Add);
                    }
                });

                textView.setText(s);
            }
        });
        return root;
    }


    public void completion1(TextView a1, TextView a2, TextView a3, LinearLayout scrollView1, LinearLayout scrollView2){
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
                if (dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Address").exists() && dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Phone_no1").exists() && dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Phone_no2").exists()){
                    //   View popupView = getLayoutInflater().inflate(R.layout.floating_dialog1,container, null);

                    //
                    ;
                    //
                    scrollView1.setVisibility(View.GONE);
                    scrollView2.setVisibility(View.VISIBLE);
                    a1.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Address").getValue().toString());
                    a2.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Phone_no1").getValue().toString());
                    a3.append(dataSnapshot.child("Users").child(obj1.getFirebase_uid()).child("Phone_no2").getValue().toString());

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