package com.example.ander.shoppingcart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

public class SQLRecycleAdapter extends RecyclerView.Adapter<RecViewHolder> {

    public Animation animation;
    public ImageButton mButton;

    public static SQLRecycleAdapter instance;
    List<ItemObject> mitemObjects;
    int mitemXML;

    public SQLRecycleAdapter(List<ItemObject> objectInput, int itemLayout) {
        mitemObjects = objectInput;
        mitemXML = itemLayout;
    }

    public static SQLRecycleAdapter getInstance(List<ItemObject> objectInput, int itemLayout) {
        if (instance == null) {
            // Create the instance
            instance = new SQLRecycleAdapter(objectInput, itemLayout);
        }
        return instance;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//          get the layout inflater the parent
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//          inflate to each row with the information from the viewholder
        View view = inflater.inflate(R.layout.recycle_view_items, parent, false);
//          associate each Recycler View Holder to an individual view
        RecViewHolder recViewHolder = new RecViewHolder(view);

//          return the view's instantiation
        return recViewHolder;
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {

        ItemObject itemObject = mitemObjects.get(position);

//        ArrayList dbName = DBHelper.getInstance(mContext).getNames();
        holder.mtextViewName.setText(itemObject.getmName());
        CharSequence name = holder.mtextViewName.getText();


//        ArrayList dbDescription = DBHelper.getInstance(mContext).getDescriptions();
        holder.mtextViewDescription.setText(itemObject.getmDescription());
        CharSequence description = holder.mtextViewDescription.getText();

//        ArrayList dbPrice = DBHelper.getInstance(mContext).getPrices();
        holder.mtextViewPrice.setText(String.valueOf(itemObject.getmPrice()));
        CharSequence price = holder.mtextViewPrice.getText();

        final String finalName = name.toString();
        final String finalDescription = description.toString();
        final String finalPrice = price.toString();

        holder.maddToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.scale);
                view.startAnimation(animation);

                Toast.makeText(view.getContext(), "Added " + finalName + " to cart", Toast.LENGTH_SHORT).show();

                if ((finalName != null) && (finalDescription != null) && (finalPrice != null)) {
                    DBHelper.getInstance(view.getContext()).addItemsFromClick(finalName, finalDescription, finalPrice);
                }
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "" + finalName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), ItemDisplayActivity.class);
                intent.putExtra("name_key", finalName);
                intent.putExtra("desc_key", finalDescription);
                intent.putExtra("price_key", finalPrice);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mitemObjects.size();
    }

    public void updateRecViewItems(List<ItemObject> list) {
        mitemObjects = list;
        notifyDataSetChanged();
    }

    public void addAdapterItems(List<ItemObject> objectInput) {
        mitemObjects = objectInput;
    }

}
