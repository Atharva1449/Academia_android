package com.theonedayapps.academiaa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Attendance_teacher_Adapter  extends FirebaseRecyclerAdapter<
        Attendance_teacherHandle, Attendance_teacher_Adapter.AttendanceViewholder> {

    public Attendance_teacher_Adapter(
            @NonNull FirebaseRecyclerOptions<Attendance_teacherHandle> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull Attendance_teacher_Adapter.AttendanceViewholder holder,
                     int position, @NonNull Attendance_teacherHandle model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.Roll.setText(model.getRollno());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.name_1.setText(model.getNameteacherhandle());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
    //
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref1 = database.getReference();
        Attendance_teacher obj=new Attendance_teacher();
        //Set a CheckedChange Listener for Switch Button
        holder.sButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean on){
                if(on)
                {
                    //obj.getDepart()
                    //obj.getDiv()
                    // obj.getYear2()
                    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                    String currentDateandTime = sdf.format(new Date());

                    myref1.child("Classroom").child(obj.getYear2()).child(obj.getDepart()).child(obj.getDiv()).child(model.getRollno()).child("Ttattendance").child(currentDateandTime).setValue(obj.getSubject3());
                    //Do something when Switch button is on/checked
                }
                else
                {
                    //Do something when Switch is off/unchecked
                }
            }
        });

        //
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public AttendanceViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardattendance, parent, false);
        return new Attendance_teacher_Adapter.AttendanceViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class AttendanceViewholder
            extends RecyclerView.ViewHolder {
        TextView Roll,name_1;
        Switch sButton;
        public AttendanceViewholder(@NonNull View itemView)
        {
            super(itemView);

            Roll  = itemView.findViewById(R.id.Roll_card);
            name_1 = itemView.findViewById(R.id.Name_card);
             sButton = (Switch) itemView.findViewById(R.id.switch1);

        }
    }

}
