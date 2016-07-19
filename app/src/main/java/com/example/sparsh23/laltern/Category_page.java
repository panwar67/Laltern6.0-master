package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Category_page extends AppCompatActivity {

    ImageView jewelry,accessories,sarees,apparel,hometextile,homedecor,paintings,others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);


        jewelry=(ImageView)findViewById(R.id.jwelery);
        accessories=(ImageView)findViewById(R.id.accesories);
        sarees=(ImageView)findViewById(R.id.sarees);
        apparel=(ImageView)findViewById(R.id.apparel);
        hometextile=(ImageView)findViewById(R.id.hometextile);
        homedecor=(ImageView)findViewById(R.id.homedecor);
        paintings=(ImageView)findViewById(R.id.paintings);
        others=(ImageView)findViewById(R.id.others);

        jewelry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });

        accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });

        sarees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });
        apparel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });
        hometextile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });
        homedecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });
        paintings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category_page.this,Stream.class));
            }
        });
    }


}
