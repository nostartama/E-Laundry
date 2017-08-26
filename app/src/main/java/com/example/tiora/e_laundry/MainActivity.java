package com.example.tiora.e_laundry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Random;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    int blanket;
    int bedcover;
    int total;
    int weight;
    int jadi=0;
    TextView Ekspress,kilo,kg,bedcovers,selimut,bedcoverQty,blanketQty,kilat,normal;
    Button maju;
    String Invoice;
    SharedPreferences sharedPreferences;
    public static final String myPreferences = "myPref";
    TextView totall;
    public static final String biaya = "payKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totall = (TextView) findViewById(R.id.total);
        kilo = (TextView) findViewById(R.id.kilo);
        kg = (TextView) findViewById(R.id.tv_kg);
        bedcovers = (TextView) findViewById(R.id.tv_bedcover);
        selimut = (TextView) findViewById(R.id.tv_selimut);
        bedcoverQty = (TextView) findViewById(R.id.bedcoverQty);
        blanketQty = (TextView) findViewById(R.id.blanketQty);
        kilat = (TextView) findViewById(R.id.kilat);
        normal = (TextView) findViewById(R.id.normal);
        maju = (Button) findViewById(R.id.maju);
        Ekspress = (TextView) findViewById(R.id.ekspressClick);

        Typeface face= Typeface.createFromAsset(getAssets(), "font/m-l.ttf");
        Typeface facebold= Typeface.createFromAsset(getAssets(), "font/m-sb.ttf");

        kilo.setTypeface(facebold);
        kg.setTypeface(face);
        bedcovers.setTypeface(face);
        selimut.setTypeface(face);
        bedcoverQty.setTypeface(facebold);
        blanketQty.setTypeface(facebold);
        kilat.setTypeface(face);
        totall.setTypeface(facebold);
        normal.setTypeface(face);
        maju.setTypeface(face);
        Ekspress.setTypeface(face);

        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(biaya))
        {
            totall.setText(sharedPreferences.getString(biaya, ""));
        randomWeight();


        }}

    public void onClick(View v) {
        // do something when the button is clicked
        // Yes we will handle click here but which button clicked??? We don't know

        // So we will make
        switch (v.getId() /*to get clicked view id**/) {
            case R.id.ekspressClick:
                TextView textView = (TextView)findViewById( R.id.ekspressClick);
                Spannable spannable = (Spannable)textView.getText();
                StyleSpan boldSpan = new StyleSpan( Typeface.BOLD );
                spannable.setSpan( boldSpan, 0, 8, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                break;

            case R.id.kilat:
                TextView textView1 = (TextView) findViewById(R.id.kilat);
                Spannable spannable1 = (Spannable)textView1.getText();
                StyleSpan boldSpan1 = new StyleSpan( Typeface.BOLD );
                spannable1.setSpan( boldSpan1, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                break;

            case R.id.normal:
                TextView textView2 = (TextView) findViewById(R.id.normal);
                Spannable spannable2 = (Spannable)textView2.getText();
                StyleSpan boldSpan2 = new StyleSpan( Typeface.BOLD );
                spannable2.setSpan( boldSpan2, 0, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                break;

            default:
                break;
        }
    }


    public void randomWeight () {
        Random random = new Random();
        weight = random.nextInt(10) + 1;

        displayKilo(weight);
        calculate();
    }

    public void randomWeightonClick (View view) {
        randomWeight();
    }
    public void increaseBlanket(View view) {
        blanket++;
        displayBlanket(blanket);
        calculate();
    }

    public void calculate() {

        {
            total = (blanket * 10000) + (bedcover * 8000) + (weight * 4000) + jadi;
        }
        displayTotal(total);
    }

    public void decreaseBlanket(View view) {
        if (blanket > 0) {
            blanket--;
            displayBlanket(blanket);
            calculate();
        }
        displayBlanket(blanket);
        calculate();
    }

    public void increaseBedcover(View view) {
        bedcover++;
        displayBedcover(bedcover);
        calculate();
    }

    public void decreaseBedcover(View view) {
        if (bedcover > 0) {
            bedcover--;
            displayBedcover(bedcover);

            calculate();
        }
        displayBedcover(bedcover);

        calculate();
    }

    public void Order (View view)
    {
        String t = totall.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(biaya, t);
        editor.commit();
        Intent intent = new Intent(MainActivity.this, Terimakasih.class);
        startActivity(intent);
    }

    private String createInvoice() {
        Invoice = "Email dan phone piye carane";
        Invoice += "\n" + getString(weight);
        Invoice += "\n" + getString(bedcover);
        Invoice += "\n" + getString(blanket);
        Invoice += "\n Total : " + getString(total);
        return Invoice;
    }



    private void displayBedcover(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.bedcoverQty);
        quantityTextView.setText("" + number);
    }

    private void displayBlanket(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.blanketQty);
        quantityTextView.setText("" + number);
    }

    private void displayKilo(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.kilo);
        quantityTextView.setText("" + number);
    }

    private void displayTotal(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.total);
        quantityTextView.setText("" +"Rp." + number);

    }
}