package com.adityagalande.cofeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        if (quantity < 0) {
            quantity = 0;
            display(0);
        } else {
            display(quantity);
        }

    }

    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantity_textViews = findViewById(R.id.quantity_textView);
        quantity_textViews.setText("" + number);
    }

    public void order(View view) {
        int quantitys = quantity;

        EditText customerName = (EditText) findViewById(R.id.customerName);
        String custName = customerName.getText().toString();

        CheckBox cappuccino = (CheckBox) findViewById(R.id.cappuccino);
        boolean Cappuccino = cappuccino.isChecked();

        CheckBox caffeMocha = (CheckBox) findViewById(R.id.caffeMocha);
        boolean CaffeMocha = caffeMocha.isChecked();

        String msg = "";
        if (quantitys < 1 ) {
            msg = "Select coffee!";
        } else {
           if(Cappuccino){
               quantitys =quantity*5;
               msg = "Name : " + custName + "\nQuantity : " + quantity + "\nSub Total : " + (quantitys) + "$" + "\nExtra : "+"Cappuccino";
           }else if(CaffeMocha){
               quantitys =quantity*7;
                msg = "Name : " + custName + "\nQuantity : " + quantity + "\nSub Total : " + (quantitys) + "$" + "\nExtra : "+"CaffeMocha";
            }
        }
        displayMessage(msg);
    }

    @SuppressLint("ShowToast")
    private void displayMessage(String message) {
        TextView xyz = findViewById(R.id.price_textView);
        xyz.setText(message);
    }
}