package com.example.ander.shoppingcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView mtextViewName;
    TextView mtextViewDescription;
    TextView mtextViewPrice;
    ImageButton maddToCartButton;

    public RecViewHolder(View itemView) {
        super(itemView);
        mtextViewName = (TextView) itemView.findViewById(R.id.name);
        mtextViewDescription = (TextView) itemView.findViewById(R.id.description);
        mtextViewPrice = (TextView) itemView.findViewById(R.id.price);
        maddToCartButton = (ImageButton) itemView.findViewById(R.id.add_to_cart_button);
    }

    @Override
    public void onClick(View view) {

    }
}
