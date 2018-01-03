package com.example.velmurugan.bottomsheetexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CartRecyclerviewAdapter extends RecyclerView.Adapter<CartRecyclerviewAdapter.MyViewHolder> {

    private List<Items> cartList;
    CartRecyclerviewAdapter(Context context, List<Items> cartList){
        this.cartList = cartList;
    }

    public void addCartItems(List<Items> cartList){
        this.cartList = cartList;
        notifyDataSetChanged();
    }

    @Override
    public CartRecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartRecyclerviewAdapter.MyViewHolder holder, int position) {
        holder.itemTitle.setText(cartList.get(position).getTitle());
        holder.itemPrice.setText("Rs "+cartList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle,itemPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemTitle = (TextView)itemView.findViewById(R.id.itemTitle);
            itemPrice = (TextView)itemView.findViewById(R.id.itemPrice);
        }
    }
}
