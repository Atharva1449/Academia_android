package com.theonedayapps.academiaa.Shareddata;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Firebase_verification {
private static String firebase_uid;
private static String roll_no;

    private static SharedPreferences sharedpreferences;
 //   SharedPreferences sharedpreferences;

    public static String getFirebase_uid()

    {

             return firebase_uid;
    }

    public static void setFirebase_uid(String firebase_uid) {

        Firebase_verification.firebase_uid = firebase_uid;
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.putString("Uid_key", firebase_uid1);
//        editor.commit();

//set_rollno(firebase_uid);

    }




}
