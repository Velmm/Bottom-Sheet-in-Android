package com.example.velmurugan.bottomsheetexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private List<Items> itemsList;
    private Callbacks callbacks;

    RecyclerviewAdapter(Context context,List<Items> itemsList){
        this.itemsList = itemsList;
        this.callbacks = (Callbacks) context;
    }
    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(itemsList.get(position).getTitle());
        holder.image.setBackgroundResource(itemsList.get(position).getImage());
        holder.price.setText("Price : Rs "+itemsList.get(position).getPrice());
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callbacks.updateCart(itemsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private TextView price;
        private ImageView addToCart;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            image = (ImageView)itemView.findViewById(R.id.image);
            price = (TextView)itemView.findViewById(R.id.price);
            addToCart = (ImageView)itemView.findViewById(R.id.addToCart);
        }
    }
}
