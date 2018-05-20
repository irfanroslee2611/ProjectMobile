package com.dev.androideasyfood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.androideasyfood.Common.Common;
import com.dev.androideasyfood.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    Button Waiter, Kitchen, Cashier;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Waiter = (Button) findViewById(R.id.Waiter);
        Kitchen = (Button) findViewById(R.id.Kitchen);
        Cashier = (Button) findViewById(R.id.Cashier);


        txtSlogan = (TextView) findViewById(R.id.txtSlogan);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/NABILA.TTF");
        txtSlogan.setTypeface(face);

        Waiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Waiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent waiter = new Intent(MainActivity.this,PrePage.class);
                startActivity(waiter);
            }
        });

       Kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kitchen = new Intent(MainActivity.this,PrePage1.class);
                startActivity(kitchen);
            }
        });

        Cashier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cashier = new Intent(MainActivity.this,PrePage2.class);
                startActivity(cashier);
            }
        });

    }
}
