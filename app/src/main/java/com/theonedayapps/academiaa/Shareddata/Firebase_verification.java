package com.theonedayapps.academiaa.Shareddata;

import android.content.Context;
import android.content.SharedPreferences;

public class Firebase_verification {
private static String firebase_uid;
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



    }
}
