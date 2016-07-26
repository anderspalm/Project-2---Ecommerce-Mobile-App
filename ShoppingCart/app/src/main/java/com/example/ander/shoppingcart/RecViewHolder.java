package com.example.ander.shoppingcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecViewHolder extends RecyclerView.ViewHolder {

    TextView textViewName;
    TextView textViewDescription;
    TextView textViewPrice;

    public RecViewHolder(View itemView) {
        super(itemView);

        textViewName = (TextView) itemView.findViewById(R.id.name);
        textViewDescription = (TextView) itemView.findViewById(R.id.description);
        textViewPrice = (TextView) itemView.findViewById(R.id.price);
    }
}
