package com.example.tiora.e_laundry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int blankets;
    int cover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random kilo = new Random();
        int i = (kilo.nextInt() % 10) +1;
        if(i<0){
            i=i+9;
        }
        else {
            displayk(i);
        }
    }

    public void increaseb(View view) {
        blankets++;
        display(blankets);
    }
    public void decreaseb(View view) {
        if(blankets>0) {
            blankets--;
            display(blankets);
        }
        display(blankets);
    }
    public void increasec(View view) {
        cover++;
        displayc(cover);
    }
    public void decreasec(View view) {
        if(cover>0) {
            cover--;
            displayc(cover);
        }
        displayc(cover);
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
}