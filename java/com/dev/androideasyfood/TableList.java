package com.dev.androideasyfood;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TableList extends AppCompatActivity {

    Button btnTable1, btnTable2,btnTable3,btnTable4,btnTable5,btnTable6;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        btnTable1 = (Button) findViewById(R.id.btnTable1);
        btnTable2 = (Button) findViewById(R.id.btnTable2);
        btnTable3 = (Button) findViewById(R.id.btnTable3);
        btnTable4 = (Button) findViewById(R.id.btnTable4);
        btnTable5 = (Button) findViewById(R.id.btnTable5);
        btnTable6 = (Button) findViewById(R.id.btnTable6);

        btnTable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent pay = new Intent(TableList.this,TablePayment22.class);
//                startActivity(pay);
            }
        });

        btnTable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent signIn = new Intent(TableList.this,TablePayment2.class);
//                startActivity(signIn);
            }
        });

        btnTable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent signIn = new Intent(TableList.this,TablePayment2.class);
//                startActivity(signIn);
            }
        });

        btnTable4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent signIn = new Intent(TableList.this,TablePayment2.class);
//                startActivity(signIn);
            }
        });

        btnTable5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent signIn = new Intent(TableList.this,TablePayment2.class);
//                startActivity(signIn);
            }
        });

        btnTable6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent signIn = new Intent(TableList.this,TablePayment2.class);
//                startActivity(signIn);
            }
        });

    }
}
