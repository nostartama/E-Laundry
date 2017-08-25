package com.example.tiora.e_laundry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    String Invoice;
    SharedPreferences sharedPreferences;
    public static final String myPreferences = "myPref";
    TextView totall;
    public static final String biaya = "payKEY";
    boolean kilat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totall = (TextView) findViewById(R.id.total);
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(biaya))
        {
            totall.setText(sharedPreferences.getString(biaya, ""));


        randomWeight();
    }}

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
    public void cekKilat(View view) {
        CheckBox BesokJadiBox = (CheckBox) findViewById(R.id.BesokJadi);
        kilat  = BesokJadiBox.isChecked();
        calculate();
   }
    public void calculate() {

        if (kilat) {
            total = (blanket * 10000) + (bedcover * 8000) + (weight*2 * 4000) + jadi;
        } else {
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