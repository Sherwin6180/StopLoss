package com.example.stoploss;

import java.io.Serializable;

public class Stock implements Serializable {
    String ticker_name;
    double initial_shares;
    double initial_amount;
    double initial_price;
    double second_amount;
    double second_purchase_price;
    double second_sale_price;
    double target;
    Choice choice;

    public Stock(String ticker_name, double initial_shares, double initial_amount, double initial_price, double second_amount, double second_purchase_price, double second_sale_price, double target, Choice choice) {
        this.ticker_name = ticker_name;
        this.initial_shares = initial_shares;
        this.initial_amount = initial_amount;
        this.initial_price = initial_price;
        this.second_amount = second_amount;
        this.second_purchase_price = second_purchase_price;
        this.second_sale_price = second_sale_price;
        this.target = target;
        this.choice = choice;
    }
}

enum Choice{
    purchase,
    sale;
}