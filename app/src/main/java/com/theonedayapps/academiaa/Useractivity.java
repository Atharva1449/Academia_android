package com.theonedayapps.academiaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Useractivity extends AppCompatActivity {
    private Button move;
    private TextView textuidtemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useractivity);
        move=findViewById(R.id.ais_move);
        textuidtemp=findViewById(R.id.textView7);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Firebase_verification obj1=new Firebase_verification();
        textuidtemp.setText(obj1.getFirebase_uid());
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Useractivity.this,User_Info_Activity.class);
                startActivity(intent);
            }
        });
    }
}