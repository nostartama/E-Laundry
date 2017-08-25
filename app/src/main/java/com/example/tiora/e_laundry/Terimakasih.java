package com.example.tiora.e_laundry;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Terimakasih extends AppCompatActivity {

    TextView Email;
    TextView Biaya;
    SharedPreferences sharedPreferences;
    public static final String myPreferences = "myPref";
    public static final String email= "emailKEY";
    public static final String biaya = "payKEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terimakasih);

        Email = (TextView) findViewById(R.id.email_thx);
        Biaya = (TextView) findViewById(R.id.biaya_thx);
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

        Email.setText(sharedPreferences.getString(email, null));
        Biaya.setText(sharedPreferences.getString(biaya, null));

    }
}
