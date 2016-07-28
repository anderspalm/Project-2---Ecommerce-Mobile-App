package com.example.ander.shoppingcart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

public class SQLRecycleAdapter extends RecyclerView.Adapter<RecViewHolder> {

    public static SQLRecycleAdapter instance;
    List<ItemObject> mitemObjects;
    int mitemXML;

    public SQLRecycleAdapter(List<ItemObject> objectInput, int itemLayout) {
        mitemObjects = objectInput;
        mitemXML = itemLayout;
    }

    public static SQLRecycleAdapter getInstance(List<ItemObject> objectInput, int itemLayout)
    {
        if (instance == null)
        {
            // Create the instance
            instance = new SQLRecycleAdapter(objectInput, itemLayout);
        }
        return instance;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//          get the layout inflater from the parent
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
        final CharSequence name = holder.mtextViewName.getText();


//        ArrayList dbDescription = DBHelper.getInstance(mContext).getDescriptions();
        holder.mtextViewDescription.setText(itemObject.getmDescription());
        final CharSequence description = holder.mtextViewDescription.getText();

//        ArrayList dbPrice = DBHelper.getInstance(mContext).getPrices();
        holder.mtextViewPrice.setText(String.valueOf(itemObject.getmPrice()));
        final CharSequence price = holder.mtextViewPrice.getText();



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "You clicked a tab " + name , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), ShoppingCart.class);
                intent.putExtra("name_key", name);
                intent.putExtra("desc_key", description);
                intent.putExtra("price_key", price);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mitemObjects.size();
    }

    public void updateRecViewItems(List<ItemObject> list){
        mitemObjects = list;
        notifyDataSetChanged();
    }

//    public void removeAllAdapterItems(List<ItemObject> itemObjects) {
//        mitemObjects.removeAll(itemObjects);
//        notifyDataSetChanged();
//    }

    public void addAdapterItems(List<ItemObject> objectInput){
        mitemObjects = objectInput;
    }

}
