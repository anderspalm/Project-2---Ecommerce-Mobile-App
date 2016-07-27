package com.example.ander.shoppingcart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class SQLRecycleAdapter extends RecyclerView.Adapter<RecViewHolder> {

    List<ItemObject> mitemObjects;
    int mitemXML;
    Context mContext;

    public SQLRecycleAdapter(List<ItemObject> objectInput, int itemLayout) {
        mitemObjects = objectInput;
        mitemXML = itemLayout;
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
        holder.textViewName.setText(itemObject.getmName());

//        ArrayList dbDescription = DBHelper.getInstance(mContext).getDescriptions();
        holder.textViewDescription.setText(itemObject.getmDescription());

//        ArrayList dbPrice = DBHelper.getInstance(mContext).getPrices();
        holder.textViewPrice.setText(String.valueOf(itemObject.getmPrice()));



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "You clicked a tab", Toast.LENGTH_SHORT).show();
//                String name =
            }
        });

    }

    @Override
    public int getItemCount() {
        return mitemObjects.size();
    }
}
