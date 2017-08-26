package com.example.tiora.e_laundry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText Email,PhoneNumber;
    Button button;
    SharedPreferences sharedPreferences;
    public static final String myPreferences = "myPref";
    public static final String email= "emailKEY";
    public static final String phonenumber = "pnKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.email);
        PhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        button = (Button) findViewById(R.id.NextButton);

        Typeface face= Typeface.createFromAsset(getAssets(), "font/m-l.ttf");
        Email.setTypeface(face);
        PhoneNumber.setTypeface(face);
        button.setTypeface(face);

        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(email))
        {
            Email.setText(sharedPreferences.getString(email, ""));
        }if (sharedPreferences.contains(phonenumber))
        {
            Email.setText(sharedPreferences.getString(phonenumber, ""));
        }}

    public void NextButton (View view)
    {
        String e = Email.getText().toString();
        String p = PhoneNumber.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(email, e);
        editor.putString(phonenumber, p);
        editor.commit();
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

}
