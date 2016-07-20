package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Apparel_Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apparel__category);
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

        ImageView kurta,topsanddresses,pantsandskirts,jackets,fabrics,dupatta,stole,shawls;

        kurta=(ImageView)findViewById(R.id.kurta);
        topsanddresses=(ImageView)findViewById(R.id.topsanddresses);
        pantsandskirts=(ImageView)findViewById(R.id.pantsandskirts);
        jackets=(ImageView)findViewById(R.id.jackets);
        fabrics=(ImageView)findViewById(R.id.fabrics);
        dupatta=(ImageView)findViewById(R.id.dupatta);
        stole=(ImageView)findViewById(R.id.stole);
        shawls=(ImageView)findViewById(R.id.shawls);

        kurta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });

        topsanddresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });

        pantsandskirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });

        jackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });

        fabrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });

        dupatta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });

        stole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });

        shawls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Apparel_Category.this,Stream.class));
            }
        });



    }

}
