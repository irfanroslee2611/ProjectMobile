package com.dev.androideasyfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.androideasyfood.Common.Common;
import com.dev.androideasyfood.ViewHolder.OrderDetailAdapter;

import java.text.NumberFormat;
import java.util.Locale;

import info.hoang8f.widget.FButton;

public class OrderDetailCashier extends AppCompatActivity {

    TextView order_id, order_phone, order_address, order_total, order_comment, order_amt, refund;
    EditText insert_amt;
    String order_id_value="";
    RecyclerView lstFoods;
    RecyclerView.LayoutManager layoutManager;

    FButton btnPayNow;
    double refundA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail_cashier);

        order_id = (TextView)findViewById(R.id.order_id);
        order_phone = (TextView)findViewById(R.id.order_phone);
        order_address = (TextView)findViewById(R.id.order_address);
        order_total = (TextView)findViewById(R.id.order_total);
        order_comment = (TextView)findViewById(R.id.order_comment);
        order_amt = (TextView)findViewById(R.id.totalA);
        refund = (TextView)findViewById(R.id.refund);
        insert_amt = (EditText)findViewById(R.id.insertamt);

        btnPayNow = (FButton) findViewById(R.id.btnPayNow);

        lstFoods = (RecyclerView)findViewById(R.id.lstFoods);
        lstFoods.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstFoods.setLayoutManager(layoutManager);

        if (getIntent()!=null)
            order_id_value = getIntent().getStringExtra("OrderId");

        //Set Value
        order_id.setText(order_id_value);
        order_phone.setText(Common.currentRequest.getPhone());
        order_total.setText(Common.currentRequest.getTotal());
        order_address.setText(Common.currentRequest.getAddress());
        order_comment.setText(Common.currentRequest.getComment());
        order_amt.setText(Common.currentRequest.getTotal());

        OrderDetailAdapter adapter = new OrderDetailAdapter(Common.currentRequest.getFoods());
        adapter.notifyDataSetChanged();
        lstFoods.setAdapter(adapter);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Double.parseDouble(insert_amt.getText().toString())) < (Common.currentRequest.getTotalA()))
                {
                    Toast.makeText(OrderDetailCashier.this, "Insufficient Amount inserted!", Toast.LENGTH_SHORT).show();
                }else {
                    refundA = (Double.parseDouble(insert_amt.getText().toString())) - (Common.currentRequest.getTotalA());
                    Locale locale = new Locale("ms", "MY");
                    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

                    refund.setText(fmt.format(refundA));
                }
            }
        });

    }
}
