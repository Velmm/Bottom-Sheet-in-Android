package com.example.velmurugan.bottomsheetexample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callbacks{


    private CoordinatorLayout coordinatorLayout;
    private BottomSheetBehavior behavior;
    private View persistentbottomSheet;
    private RecyclerView recyclerView,bottomSheetRecyclerview;
    private List<Items> itemsList;
    private RecyclerviewAdapter recyclerviewAdapter;
    private List<Items> cartList;
    private CartRecyclerviewAdapter cartRecyclerviewAdapter;
    private TextView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadData();

        //Bottomsheet
        cartList = new ArrayList<>();
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);
        persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottomsheet);
        bottomSheetRecyclerview = coordinatorLayout.findViewById(R.id.recyclerview_bottom_sheet);
        cart = (TextView)coordinatorLayout.findViewById(R.id.cart);
        bottomSheetRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        cartRecyclerviewAdapter = new CartRecyclerviewAdapter(this,cartList);
        bottomSheetRecyclerview.setAdapter(cartRecyclerviewAdapter);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(persistentbottomSheet);

    }

    private void loadData(){

        Items items = new Items("Star Wars The Last Jedi",R.drawable.star_war,20);
        itemsList.add(items);
        items = new Items("Coco",R.drawable.coco,30);
        itemsList.add(items);
        items = new Items("Justice League ",R.drawable.justice_league,20);
        itemsList.add(items);
        items = new Items("Thor: Ragnarok",R.drawable.thor_ragnarok,40);
        itemsList.add(items);
        recyclerviewAdapter = new RecyclerviewAdapter(this,itemsList);
        recyclerView.setAdapter(recyclerviewAdapter);

    }

        public void ExpandBottomSheet(View view){
        if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    @Override
    public void updateCart(Items items) {
        cartList.add(items);
        cart.setText("CART ("+cartList.size()+")");
        cartRecyclerviewAdapter.addCartItems(cartList);
    }

    public void pay(View view){
        Toast.makeText(getApplicationContext(),"Start payment",Toast.LENGTH_SHORT).show();
    }
}
