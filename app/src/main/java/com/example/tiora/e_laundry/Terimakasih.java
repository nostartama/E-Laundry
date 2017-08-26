package com.example.tiora.e_laundry;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Terimakasih extends AppCompatActivity {

    TextView Email;
    TextView Biaya;
    TextView hi,currently,washing;
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
        hi = (TextView) findViewById(R.id.tv_hi);
        currently = (TextView) findViewById(R.id.tv_currently);
        washing = (TextView) findViewById(R.id.tv_washing);

        Typeface face= Typeface.createFromAsset(getAssets(), "font/m-l.ttf");
        Typeface faceitalic= Typeface.createFromAsset(getAssets(), "font/m-litalic.ttf");
        Typeface facebold= Typeface.createFromAsset(getAssets(), "font/m-sb.ttf");

        Email.setTypeface(face);
        Biaya.setTypeface(face);
        hi.setTypeface(faceitalic);
        currently.setTypeface(faceitalic);
        washing.setTypeface(facebold);


        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

        Email.setText(sharedPreferences.getString(email, null));
        Biaya.setText(sharedPreferences.getString(biaya, null));

    }
}
