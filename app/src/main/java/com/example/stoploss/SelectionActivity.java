package com.example.stoploss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SelectionActivity extends AppCompatActivity {
    Choice choice = Choice.purchase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Button buttonConfirmChoice = findViewById(R.id.buttonConfirmChoice);
        CheckBox purchaseCheck = findViewById(R.id.checkBoxPurchase);
        CheckBox saleCheck = findViewById(R.id.checkBoxSale);



        purchaseCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(purchaseCheck.isChecked()){
                    choice = Choice.purchase;
                    saleCheck.setChecked(false);
                }
                else
                    choice = Choice.sale;
            }
        });

        saleCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(saleCheck.isChecked()){
                    choice = Choice.sale;
                    purchaseCheck.setChecked(false);
                }
                else
                    choice = Choice.purchase;
            }
        });

        buttonConfirmChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionActivity.this, CreateActivity.class);
                intent.putExtra("choice", choice);
                startActivity(intent);
            }
        });
    }
}