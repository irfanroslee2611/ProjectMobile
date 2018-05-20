package com.dev.androideasyfood;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.androideasyfood.Common.Common;
import com.dev.androideasyfood.Database.Database;
import com.dev.androideasyfood.Model.Order;
import com.dev.androideasyfood.Model.Request;
import com.dev.androideasyfood.ViewHolder.CartAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

import info.hoang8f.widget.FButton;

public class Cart extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Spinner tableSpinner;

    FirebaseDatabase database;
    DatabaseReference requests;

    TextView txtTotalPrice;
    FButton btnPlace;

    List<Order> cart = new ArrayList<>();
    CartAdapter adapter;
    String text;
    double total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //Firebase
        database = FirebaseDatabase.getInstance();
        requests=database.getReference("Requests");

        //Init
        recyclerView = (RecyclerView)findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tableSpinner = (Spinner) findViewById(R.id.table) ;

        txtTotalPrice = (TextView)findViewById(R.id.total);
        btnPlace = (FButton) findViewById(R.id.btnPlaceOrder);

        final ArrayAdapter<String> adapterTable = new ArrayAdapter<String>(Cart.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        adapterTable.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tableSpinner.setAdapter(adapterTable);

        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cart.size()>0)
                    showAlertDialog();
                else
                    Toast.makeText(Cart.this, "Your cart is empty!", Toast.LENGTH_SHORT).show();
            }
        });
        loadListFood();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Cart.this);

        LayoutInflater inflater = this.getLayoutInflater();
        View order_address_comment = inflater.inflate(R.layout.order_address_comment,null);

        final MaterialEditText edtComment = (MaterialEditText)order_address_comment.findViewById(R.id.edtComment);

        text = tableSpinner.getSelectedItem().toString();

        alertDialog.setView(order_address_comment);
        alertDialog.setIcon(R.drawable.ic_shopping_cart_black_24dp);

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //Create new Request
                Request request = new Request(Common.currentUser.getPhone(), Common.currentUser.getName(), txtTotalPrice.getText().toString(), "0", edtComment.getText().toString(), cart, text, total);
                //Submit to Firebase
                //We will using System.CurrentMilli to key(FIFO)
                requests.child(String.valueOf(System.currentTimeMillis())).setValue(request);
                //Delete cart
                new Database(getBaseContext()).cleanCart();
                Toast.makeText(Cart.this, "Thank You, Order Place", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }

    private void loadListFood(){
        Runnable run = new Runnable() {
            @Override
            public void run() {

                cart = new Database(Cart.this).getCarts();
                adapter = new CartAdapter(cart,Cart.this);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

                //Calculate total price
                double total = 0;
                for (Order order : cart)
                    total+=(Double.parseDouble(order.getPrice()))*(Integer.parseInt(order.getQuantity()));
                Locale locale = new Locale("ms","MY");
                NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

                txtTotalPrice.setText(fmt.format(total));
            }
        };
        Thread thrPlace = new Thread(run);
        thrPlace.start();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals(Common.DELETE))
            deleteCart(item.getOrder());
        return true;
    }

    private void deleteCart(int order) {
        //Remove item at List<Order> by position
        cart.remove(order);
        //After that, delete all old data from SQLite
        new Database(this).cleanCart();
        //And final, update new data from List<Order> to SQLite
        for(Order item:cart)
            new Database(this).addToCart(item);
        //Refresh
        loadListFood();
    }

}
