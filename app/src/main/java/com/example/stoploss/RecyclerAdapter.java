package com.example.stoploss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StockViewHolder>{
    private ArrayList<Stock> stocks;
    private Context context;

    public RecyclerAdapter(ArrayList<Stock> stocks, Context context) {
        this.stocks = stocks;
        this.context = context;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        String stock_name = stocks.get(position).ticker_name.toUpperCase();
        holder.textViewTickerName.setText(stock_name);
        if(stocks.get(position).choice.equals(Choice.purchase)){
            double price = stocks.get(position).second_sale_price;
            holder.textViewTargetInfo.setText("Sell at: " + String.format("%.3f", price));
        }

        else{
            double price = stocks.get(position).second_purchase_price;
            holder.textViewTargetInfo.setText("Buy at: " + String.format("%.3f", price));
        }



    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }

    public class StockViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTickerName, textViewTargetInfo;

        public StockViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTickerName = itemView.findViewById(R.id.textViewTickerName);
            textViewTargetInfo = itemView.findViewById(R.id.textViewTargetInfo);
        }

    }
}
