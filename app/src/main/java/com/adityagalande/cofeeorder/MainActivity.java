package com.adityagalande.cofeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity ++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity --;
        if(quantity < 0){
            quantity=0;
            display(0);
        }else{
            display(quantity);
        }

    }

    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantity_textViews = findViewById(R.id.quantity_textView);
        quantity_textViews.setText(""+number);
    }

    public void order(View view) {
        int quantitys = quantity;
        //String msg = (quantitys*5)+"$"+" Thank you!";
        String msg;
        if(quantitys < 1){
            msg = "Select coffee!";
        }else{
            msg = (quantitys*5)+"$"+" Thanks!";
        }
        //String price = Integer.toString(quantitys*5);
        //displayMessage(quantity+" Cup of coffee "+(quantitys*5)+"$ "+msg);
        displayMessage(msg);
        //displayprice(quantitys *10);
    }
    //DisplayPrice method for integers
    private void displayprice(int number) {
        TextView price_textViews = findViewById(R.id.price_textView);
        price_textViews.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message){
        TextView xyz = findViewById(R.id.price_textView);
        xyz.setText(message);
    }
}