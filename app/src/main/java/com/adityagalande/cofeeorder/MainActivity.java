package com.adityagalande.cofeeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity++;
        if (quantity > 100) {
            quantity = 100;
            Toast.makeText(this, "You cannot have more than 100 coffee!", Toast.LENGTH_LONG).show();
            display(quantity);
        } else {
            display(quantity);
        }
    }

    public void decrement(View view) {
        quantity--;
        if (quantity < 1) {
            quantity = 1;
            Toast.makeText(this, "You need to have atleast one coffee!", Toast.LENGTH_LONG).show();
            ;
            display(quantity);
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

        EditText customerName = (EditText) findViewById(R.id.customerName);
        String custName = customerName.getText().toString();

        CheckBox cappuccino = (CheckBox) findViewById(R.id.cappuccino);
        boolean Cappuccino = cappuccino.isChecked();

        CheckBox caffeMocha = (CheckBox) findViewById(R.id.caffeMocha);
        boolean whippedCream = caffeMocha.isChecked();

        String msg = "";
        if (quantity == 0) {
            msg = "Select coffee!";
        } else {
            if (!Cappuccino && !whippedCream) {
                msg = "Name : " + custName + "\nQuantity : " + quantity + "\nTotal : " + calculatePrice(Cappuccino, whippedCream) + "$";
            }
            if (Cappuccino) {
                msg = "Name : " + custName + "\nQuantity : " + quantity + "\nTotal : " + calculatePrice(Cappuccino, whippedCream) + "$\nTopings :\nCappuccino";
            }
            if (whippedCream) {
                msg = "Name : " + custName + "\nQuantity : " + quantity + "\nTotal : " + calculatePrice(Cappuccino, whippedCream) + "$\nTopings :\nWhippedCream";
            }
            if (Cappuccino && whippedCream) {
                msg = "Name : " + custName + "\nQuantity : " + quantity + "\nTotal : " + calculatePrice(Cappuccino, whippedCream) + "$\nTopings :\nCappuccino\nWhippedCream";
            }
        }
        String addresses = "adityagalande6@gmail.com";
        composeEmail(addresses, custName, msg);
        displayMessage(msg);
    }


    public void composeEmail(String addresses, String custName, String msg) {

        //This is Email intent function
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hey! " + custName);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice(boolean Cappuccino, boolean whippedCream) {
        int price = 5;
        if (Cappuccino) {
            price += 1;
        }
        if (whippedCream) {
            price += 2;
        }
        return quantity * price;
    }


    private void displayMessage(String message) {
        TextView xyz = findViewById(R.id.price_textView);
        xyz.setText(message);
    }
}