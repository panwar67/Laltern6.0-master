package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Jewelry_Category extends AppCompatActivity {

    ImageView terracotta,silver,metal,cane,jute,contemporary,dokra,wooden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jewelry__category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });

        silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });

        metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });

        cane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });

        jute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });
        contemporary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });

        dokra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });

        wooden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Jewelry_Category.this,Stream.class));
            }
        });
    }


}
