package com.theonedayapps.academiaa.ui2.time_table;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
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
import com.theonedayapps.academiaa.Useractivity;
import com.theonedayapps.academiaa.ui2.notice.NoticeViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Time_table extends Fragment {

    private Time_tableViewModel time_tableViewModel;
private TextView timetable_date,timetable_lecture,rollnumber;
private PieChartView pieChartView;
private CalendarView calendarView;
private String selected_date;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        time_tableViewModel =
                new ViewModelProvider(this).get(Time_tableViewModel.class);
        View root = inflater.inflate(R.layout.fragment_time_table, container, false);

        time_tableViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                timetable_date=root.findViewById(R.id.date_timetable);
                timetable_lecture=root.findViewById(R.id.lectures_timetable);
                pieChartView=root.findViewById(R.id.chart_timetable);
                calendarView=root.findViewById(R.id.calendarView);
                rollnumber=root.findViewById(R.id.textViewroll);
                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month,
                                                    int dayOfMonth) {
                        selected_date = String.valueOf(dayOfMonth)+String.valueOf(month+1)+String.valueOf(year);
                        Log.d("##############date", selected_date);
                        timetable_date.setText(selected_date);
                        firebasefn((String) rollnumber.getText(),"1","A",selected_date,timetable_lecture,pieChartView);
                    }
                });


            }
        });
        return root;
    }

    void piechartfun(int data,int total,String settext1,PieChartView pieChartView){

        List pieData = new ArrayList<>();


        pieData.add(new SliceValue(data, Color.parseColor("#2D98FB")).setLabel(""));


        pieData.add(new SliceValue(6, Color.parseColor("#796E57E8")).setLabel(""));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1(settext1).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
    }


    void firebasefn(String roll,String year,String division,String date,TextView a,PieChartView pie){
        DatabaseReference myRef;
        // Firebase_verification obj=new Firebase_verification();
        myRef = FirebaseDatabase.getInstance().getReference();
        Useractivity obj3=new Useractivity();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String str = dataSnapshot.child("Classroom").child(roll).child(year).child(division).child(date).getValue().toString();
                //roll_no=value;
                List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
                String app="";
                for (int i = 0; i < items.size(); i++) {

                    app=app+System.lineSeparator()+items.get(i);
                }
                piechartfun(items.size(), 2,String.valueOf(items.size())+"/8",pie);
                a.setText(app);
                Log.d("#####value check", "Value is: " + app);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("value check 2", "Failed to read value.", error.toException());

            }
        });



    }
}
