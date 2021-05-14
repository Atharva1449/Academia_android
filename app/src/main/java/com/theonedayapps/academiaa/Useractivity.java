package com.theonedayapps.academiaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.theonedayapps.academiaa.Shareddata.Firebase_verification;

public class Useractivity extends AppCompatActivity {
    private Button move;
    private TextView textuidtemp;
    private String roll_no;
   private TextView textroll,textrollget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useractivity);



        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,0);

        BottomNavigationView navView = findViewById(R.id.nav_view2);

//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment2);
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



        move=findViewById(R.id.ais_move);
        textuidtemp=findViewById(R.id.textView7);
        textroll=(TextView) findViewById(R.id.textViewroll);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Firebase_verification obj1=new Firebase_verification();
        Useractivity obj=new Useractivity();
        set_rollno(obj1.getFirebase_uid(),textroll);
        textuidtemp.setText(obj1.getFirebase_uid());
        gettextview();
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Useractivity.this,User_Info_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
    public static void set_rollno(String uid,TextView a){

        DatabaseReference myRef;
       // Firebase_verification obj=new Firebase_verification();
        myRef = FirebaseDatabase.getInstance().getReference();
        Useractivity obj3=new Useractivity();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.child("Users").child(uid).child("Roll_no").getValue().toString();
                //roll_no=value;
                a.setText(value);
                Log.d("#####value check", "Value is: " + value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("value check 2", "Failed to read value.", error.toException());

            }
        });


    }
    public String gettextview(){
        textrollget=findViewById(R.id.textViewroll);
        return textrollget.getText().toString();
    }


}