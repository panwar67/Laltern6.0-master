package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;

public class Accessories_Category extends AppCompatActivity {

    ImageView footwear,bagandbelt,tribal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories__category);



        footwear=(ImageView)findViewById(R.id.footwear);
        bagandbelt=(ImageView)findViewById(R.id.bag_belts);
        tribal=(ImageView)findViewById(R.id.tribal);

        footwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","accessories");
                map.put("subcat","footwear");
                Intent intent = new Intent(Accessories_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

        bagandbelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","accessories");
                map.put("subcat","bagandbelt");
                Intent intent = new Intent(Accessories_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

        tribal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","accessories");
                map.put("subcat","tribal");
                Intent intent = new Intent(Accessories_Category.this,Stream.class) ;
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Accessories_Category.this,Category_page.class));
        finish();
    }
}
