package com.theonedayapps.academiaa.ui2.attendance;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.theonedayapps.academiaa.R;
import com.theonedayapps.academiaa.Shareddata.Firebase_verification;
import com.theonedayapps.academiaa.ui2.notice.NoticeViewModel;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class Attendance extends Fragment {

    private AttendanceViewModel attendanceViewModel;
    private PieChartView pieChartView1,pieChartView2,pieChartView3;
    private DatabaseReference myRef;
    private ValueEventListener eventListener;

    public String st1,st2,st3;

    protected int att,tot,grand,s1,s2,s3;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        attendanceViewModel =
                new ViewModelProvider(this).get(AttendanceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_attendance, container, false);

        attendanceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                pieChartView1 = root.findViewById(R.id.chart1);
                pieChartView2 = root.findViewById(R.id.chart2);
                pieChartView3 = root.findViewById(R.id.chart3);

                List pieData = new ArrayList<>();
                pieData.add(new SliceValue(15, Color.BLUE).setLabel("10"));

                PieChartData pieChartData = new PieChartData(pieData);
                pieChartData.setHasLabels(true).setValueLabelTextSize(14);
                pieChartData.setHasCenterCircle(true);
                pieChartView1.setPieChartData(pieChartData);
                pieChartView2.setPieChartData(pieChartData);
                pieChartView3.setPieChartData(pieChartData);




                Firebase_verification obj=new Firebase_verification();
                myRef = FirebaseDatabase.getInstance().getReference();

                eventListener = myRef.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {

                        st1= dataSnapshot.child("Users").child(obj.getFirebase_uid()).child("Attendance").getValue().toString();
                        att=Integer.valueOf(st1);
                    String a =   dataSnapshot.child("Users").child(obj.getFirebase_uid()).child("Semester").getValue().toString();

                        st2= dataSnapshot.child("Academics").child(a).child("Totallecnow").getValue().toString();
                        tot=Integer.valueOf(st2);
                        st3= dataSnapshot.child("Academics").child("Grandtotal").getValue().toString();
                        grand=Integer.valueOf(st3);

                        s1=(( att*100) /tot);

                        s2=(((grand*75)/100)-att);

                        s3=(grand-tot);


                        TextView txt1=root.findViewById(R.id.tttt1);
                        txt1.setText(String.valueOf(s1));


                        TextView txt2=root.findViewById(R.id.t2);
                        txt2.setText(String.valueOf(s2));
                        TextView txt3=root.findViewById(R.id.t3);
                        txt3.setText(String.valueOf(s3));

//                        int coloring = Color.parseColor("#00B300");
//                        coloring=Color.parseColor("E3242B");




String decide=String.valueOf(s2)+"/"+String.valueOf(s3);
String coloring="#02CCCB";

                    if(s2>s3){
                        decide="!";
                        }

                        if(s1<75){
                          coloring   ="#E85C84";
                        }
                    piechart(s1,coloring,100,"#6F57E8",String.valueOf(s1)+"%",pieChartView1);
                    piechart(s3,"#2D98FB",grand,"#796E57E8",String.valueOf(s3),pieChartView2);
                    piechart(s2, "#E85C84",s3,"#796E57E8",decide,pieChartView3);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });
                    }
        });
        return root;
    }


    void piechart(int data,String datacolor,int total,String totalolor,String settext1,PieChartView pieChartView){

        List pieData = new ArrayList<>();


            pieData.add(new SliceValue(data,Color.parseColor(datacolor)).setLabel(""));


        pieData.add(new SliceValue(total, Color.parseColor(totalolor)).setLabel(""));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1(settext1).setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);
    }
}
