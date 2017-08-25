package com.example.tiora.e_laundry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int blankets;
    int cover;
    int total;
    int weight;
    int jadi=0;
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


        Random kilo = new Random();
        int i = (kilo.nextInt() % 10) + 1;
        if (i < 0) {
            i = i + 9;
        }
        weight = i;
        displayk(weight);
        calculate();
    }}

    public void increaseb(View view) {
        blankets++;
        display(blankets);
        calculate();
    }
    public void cekKilat(View view) {
        CheckBox BesokJadiBox = (CheckBox) findViewById(R.id.BesokJadi);
        kilat  = BesokJadiBox.isChecked();
        calculate();

    }
    public void calculate() {

        if (kilat) {
            total = (blankets * 10000) + (cover * 8000) + (weight*2 * 4000) + jadi;
        } else {
            total = (blankets * 10000) + (cover * 8000) + (weight * 4000) + jadi;
        }
       // total = (blankets * 10000) + (cover * 8000) + (weight * 4000) + jadi;
        displayt(total);
    }

    public void decreaseb(View view) {
        if (blankets > 0) {
            blankets--;
            display(blankets);
            calculate();
        }
        display(blankets);
        calculate();
    }

    public void increasec(View view) {
        cover++;
        displayc(cover);
        calculate();
    }

    public void decreasec(View view) {
        if (cover > 0) {
            cover--;
            displayc(cover);

            calculate();
        }
        displayc(cover);

        calculate();
    }

    void Order (View view)
    {
        String t = totall.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(biaya, t);
        editor.commit();
        Intent intent = new Intent(MainActivity.this, Terimakasih.class);
        startActivity(intent);
    }




    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayc(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantitys_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayk(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.kilo);
        quantityTextView.setText("" + number);
    }

    private void displayt(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.total);
        quantityTextView.setText("" +"Rp." + number);

    }
}