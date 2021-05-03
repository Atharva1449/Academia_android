package com.theonedayapps.academiaa;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

public class User_Info_Activity extends AppCompatActivity {
ProgressBar progressbar;
 private  static int counter=0;
 private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__info_);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,0);

         BottomNavigationView navView = findViewById(R.id.nav_view);

//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        /*sample*/
        /* sample2*/
    back=findViewById(R.id.back_button_to_Useractivity);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(User_Info_Activity.this, Useractivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    });
    }

    public int getCounter(int counter){
        return counter;
    }
    public void setCounter(int counter1){
        counter=counter1;
    }

//    public class SendRequest extends AsyncTask<String, Void, String> {
//
//        Intent intent=getIntent();
//        String abc=intent.getStringExtra("Roll_No");
//        String degree=intent.getStringExtra("Degree");
//        String year=intent.getStringExtra("Year");
//        String dept=intent.getStringExtra("Dept");
//        String addyear=intent.getStringExtra("AddYear");
//        String name1=intent.getStringExtra("Name");
//        String dob1=intent.getStringExtra("Dob");
//        String address1=intent.getStringExtra("Address");
//        String mobileno1=intent.getStringExtra("MobileNo");
//        String addharno1=intent.getStringExtra("AddharNo");
//
////        protected void onPreExecute(){}
//
////        protected String doInBackground(String... arg0) {
////
////            try{
////
////                URL url = new URL("https://script.google.com/macros/s/AKfycbx-HG3OgDuC55ZcYklBLW_m7-jGeZZma3hzrpagHbmqpSB0tjb-VJVYAuU1AlFb5RmCqA/exec");
////
////                JSONObject postDataParams = new JSONObject();
////
////
////
////                postDataParams.put("rollno",abc);
////                postDataParams.put("degree",degree);
////                postDataParams.put("year",year);
////                postDataParams.put("department",dept);
////                postDataParams.put("addyear",addyear);
////                postDataParams.put("name",name1);
////                postDataParams.put("dob",dob1);
////                postDataParams.put("address",address1);
////                postDataParams.put("mobileno",mobileno1);
////                postDataParams.put("addharno",addharno1);
////
////
////                Log.e("params",postDataParams.toString());
////
////                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////                conn.setReadTimeout(15000 /* milliseconds */);
////                conn.setConnectTimeout(15000 /* milliseconds */);
////                conn.setRequestMethod("POST");
////                conn.setDoInput(true);
////                conn.setDoOutput(true);
////
////                OutputStream os = conn.getOutputStream();
////                BufferedWriter writer = new BufferedWriter(
////                        new OutputStreamWriter(os, "UTF-8"));
////                writer.write(getPostDataString(postDataParams));
////
////                writer.flush();
////                writer.close();
////                os.close();
////
////                int responseCode=conn.getResponseCode();
////
////                if (responseCode == HttpsURLConnection.HTTP_OK) {
////
////                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
////                    StringBuffer sb = new StringBuffer("");
////                    String line="";
////
////                    while((line = in.readLine()) != null) {
////
////                        sb.append(line);
////                        break;
////                    }
////
////                    in.close();
////                    return sb.toString();
////
////                }
////                else {
////                    return new String("false : "+responseCode);
////                }
////            }
////            catch(Exception e){
////                return new String("Exception: " + e.getMessage());
////            }
////        }
////
////        @Override
////        protected void onPostExecute(String result) {
////            Log.d("message1","#######################done");
////
////        }
////    }
////
////    public String getPostDataString(JSONObject params) throws Exception {
////
////        StringBuilder result = new StringBuilder();
////        boolean first = true;
////
////        Iterator<String> itr = params.keys();
////
////        while(itr.hasNext()){
////
////            String key= itr.next();
////            Object value = params.get(key);
////
////            if (first)
////                first = false;
////            else
////                result.append("&");
////
////            result.append(URLEncoder.encode(key, "UTF-8"));
////            result.append("=");
////            result.append(URLEncoder.encode(value.toString(), "UTF-8"));
////
////        }
////        return result.toString();
////    }
//
//}

}