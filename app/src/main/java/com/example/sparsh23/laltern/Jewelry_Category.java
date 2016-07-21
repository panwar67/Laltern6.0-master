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

public class Jewelry_Category extends AppCompatActivity {

    ImageView terracotta,silver,metal,cane,jute,contemporary,dokra,wooden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewelry__category);


        terracotta=(ImageView)findViewById(R.id.Terracotta);
        silver=(ImageView)findViewById(R.id.Silver);
        metal=(ImageView)findViewById(R.id.Metal);
        cane=(ImageView)findViewById(R.id.Cane);
        jute=(ImageView)findViewById(R.id.Jute);
        contemporary=(ImageView)findViewById(R.id.Contemporary);
        dokra=(ImageView)findViewById(R.id.Dokra);
        wooden=(ImageView)findViewById(R.id.Wooden);

        terracotta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Jewelry_Category.this,Stream.class);

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","jewelry");
                map.put("subcat","terracotta");
                intent.putExtra("map", map);


                startActivity(intent);
                finish();
            }
        });

        silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(Jewelry_Category.this,Stream.class);
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","jewelry");
                map.put("subcat","silver");
                intent.putExtra("map", map);

                startActivity(intent);
                finish();
            }
        });

        metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jewelry_Category.this,Stream.class);
                HashMap<String,String> map = new HashMap<String, String>();

                map.put("category","jewelry");
                map.put("subcat","metal");
                intent.putExtra("map", map);
                startActivity(intent);
                finish();
            }
        });

        cane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jewelry_Category.this,Stream.class);
                HashMap<String,String> map = new HashMap<String, String>();

                map.put("category","jewelry");
                map.put("subcat","cane");
                intent.putExtra("map", map);
                startActivity(intent);
                finish();
            }
        });

        jute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jewelry_Category.this,Stream.class);
                HashMap<String,String> map = new HashMap<String, String>();

                map.put("category","jewelry");
                map.put("subcat","jute");
                intent.putExtra("map", map);
                startActivity(intent);
                finish();
            }
        });
        contemporary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jewelry_Category.this,Stream.class);
                HashMap<String,String> map = new HashMap<String, String>();

                map.put("category","jewelry");
                map.put("subcat","contemporary");
                intent.putExtra("map", map);
                startActivity(intent);
                finish();
            }
        });

        dokra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jewelry_Category.this,Stream.class);
                HashMap<String,String> map = new HashMap<String, String>();

                map.put("category","jewelry");
                map.put("subcat","dokra");
                intent.putExtra("map", map);
                startActivity(intent);
                finish();
            }
        });

        wooden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Jewelry_Category.this,Stream.class);


                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","jewelry");
                map.put("subcat","wooden");
                intent.putExtra("map", map);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Jewelry_Category.this,Category_page.class));
        finish();
    }
}
