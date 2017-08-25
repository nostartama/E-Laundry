package com.example.tiora.e_laundry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int blankets;
    int cover;
    int total;
    int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random kilo = new Random();
        int i = (kilo.nextInt() % 10) + 1;
        if (i < 0) {
            i = i + 9;
        }
        weight = i;
        displayk(weight);
        calculate();
    }

    public void increaseb(View view) {
        blankets++;
        display(blankets);
        calculate();
    }

    public void calculate() {
        total = (blankets * 10000) + (cover * 8000) + (weight * 4000);
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
        quantityTextView.setText("" + number);
    }
}