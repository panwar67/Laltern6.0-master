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

public class Paintings_Category extends AppCompatActivity {

    ImageView murals,madhubani,gond,sanjhi,mud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintings__category);



        murals=(ImageView)findViewById(R.id.murals);
        madhubani=(ImageView)findViewById(R.id.madhubani);
        gond=(ImageView)findViewById(R.id.gond);
        sanjhi=(ImageView)findViewById(R.id.sanji);
        mud=(ImageView)findViewById(R.id.mudpaintings);

        murals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","paintings");
                map.put("subcat","murals");
                Intent intent = new Intent(Paintings_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        madhubani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","paintings");
                map.put("subcat","madhubani");
                Intent intent = new Intent(Paintings_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        gond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","paintings");
                map.put("subcat","gond");
                Intent intent = new Intent(Paintings_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

                     }
        });

        sanjhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","paintings");
                map.put("subcat","sanjhi");
                Intent intent = new Intent(Paintings_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        mud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","paintings");
                map.put("subcat","mud");
                Intent intent = new Intent(Paintings_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Paintings_Category.this,Category_page.class));
        finish();
    }


    }


