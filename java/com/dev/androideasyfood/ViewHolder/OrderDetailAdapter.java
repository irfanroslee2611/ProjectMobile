package com.dev.androideasyfood.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.androideasyfood.Model.Order;
import com.dev.androideasyfood.R;

import java.util.List;

/**
 * Created by IRFAN on 4/12/2017.
 */

class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView name,quantity,price,discount;;

    public MyViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.product_name);
        quantity = (TextView)itemView.findViewById(R.id.product_quantity);
        price = (TextView)itemView.findViewById(R.id.product_price);
        discount = (TextView)itemView.findViewById(R.id.product_discount);

    }
}

public class OrderDetailAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Order> myOrders;

    public OrderDetailAdapter(List<Order> myOrders){
        this.myOrders = myOrders;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.order_detail_layout,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Order order = myOrders.get(i);
        myViewHolder.name.setText(String.format("Name : %s",order.getProductName()));
        myViewHolder.quantity.setText(String.format("Quantity : %s",order.getQuantity()));
        myViewHolder.price.setText(String.format("Price : %s",order.getPrice()));
        myViewHolder.discount.setText(String.format("Discount : %s",order.getDiscount()));

    }

    @Override
    public int getItemCount() {
        return myOrders.size();
    }
}
