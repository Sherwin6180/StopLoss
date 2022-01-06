package com.example.stoploss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {


    double initial_shares;
    double initial_amount;
    double initial_price;
    double second_amount;
    double second_purchase;
    double second_sale;
    double target;
    String ticker_name;

    Stock stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        EditText initial_shares_edittext = findViewById(R.id.editText_shares);
        EditText initial_amount_edittext = findViewById(R.id.editText_initial_amount);
        EditText initial_price_edittext = findViewById(R.id.editText_price);
        EditText second_amount_edittext = findViewById(R.id.editText_second_amount);
        EditText second_purchase_edittext = findViewById(R.id.editText_second_purchase_price);
        EditText second_sale_edittext = findViewById(R.id.editText_second_sale_price);
        EditText ticker_name_edittext = findViewById(R.id.editText_ticker_name);
        EditText target_edittext = findViewById(R.id.editText_target);
        Button confirm = findViewById(R.id.button_confirm);

        //receive choice from SelectionActivity
        Choice choice = (Choice)(getIntent().getSerializableExtra("choice"));
        if(choice.equals(Choice.purchase))
            second_sale_edittext.setEnabled(false);
        else
            second_purchase_edittext.setEnabled(false);


        //after the confirm button is pressed
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(choice.equals(Choice.purchase)){

                    initial_shares = Double.parseDouble(initial_shares_edittext.getText().toString());
                    initial_amount = Double.parseDouble(initial_amount_edittext.getText().toString());
                    initial_price = Double.parseDouble(initial_price_edittext.getText().toString());
                    second_amount = Double.parseDouble(second_amount_edittext.getText().toString());
                    second_purchase = Double.parseDouble(second_purchase_edittext.getText().toString());
                    target = Double.parseDouble(target_edittext.getText().toString());
                    ticker_name = ticker_name_edittext.getText().toString();

                    second_sale = initial_amount*(1+0.01*target)/(initial_shares-initial_amount/initial_price+second_amount/second_purchase);

                    stock = new Stock(ticker_name,initial_shares, initial_amount, initial_price, second_amount, second_purchase, second_sale, target, Choice.purchase);
                }

                else{

                    initial_shares = Double.parseDouble(initial_shares_edittext.getText().toString());
                    initial_amount = Double.parseDouble(initial_amount_edittext.getText().toString());
                    initial_price = Double.parseDouble(initial_price_edittext.getText().toString());
                    second_amount = Double.parseDouble(second_amount_edittext.getText().toString());
                    second_sale = Double.parseDouble(second_sale_edittext.getText().toString());
                    target = Double.parseDouble(target_edittext.getText().toString());
                    ticker_name = ticker_name_edittext.getText().toString();

                    second_purchase = second_amount/(initial_amount*(1+0.01*target)/second_sale-initial_shares+initial_amount/initial_price);
                    stock = new Stock(ticker_name,initial_shares, initial_amount, initial_price, second_amount, second_purchase, second_sale, target, Choice.sale);
                }

                Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                intent.putExtra("stock_info", stock);
                startActivity(intent);

            }
        });
    }
}