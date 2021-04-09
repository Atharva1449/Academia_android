package com.theonedayapps.academiaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Useractivity extends AppCompatActivity {
    private Button move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useractivity);
        move=findViewById(R.id.ais_move);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Useractivity.this,User_Info_Activity.class);
                startActivity(intent);
            }
        });
    }
}