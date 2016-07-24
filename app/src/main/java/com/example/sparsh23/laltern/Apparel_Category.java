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

public class Apparel_Category extends AppCompatActivity {

    ImageView kurta,topsanddresses,pantsandskirts,jackets,fabrics,dupatta,stole,shawls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apparel__category);


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
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","kurta");
                Intent intent = new Intent(Apparel_Category.this,Stream.class);
                intent.putExtra("map",map);
                startActivity(intent);
            }
        });

        topsanddresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","topsanddresses");

                Intent intent = new Intent(Apparel_Category.this,Stream.class);
                intent.putExtra("map",map);
                startActivity(intent);
            }
        });

        pantsandskirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","pantsandskirts");

                Intent intent = new Intent(Apparel_Category.this,Stream.class);

                intent.putExtra("map",map);
                startActivity(intent);
            }
        });

        jackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","jackets");
                Intent intent = new Intent(Apparel_Category.this,Stream.class);
                intent.putExtra("map",map);
                startActivity(intent);

            }
        });

        fabrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","fabrics");
                Intent intent = new Intent(Apparel_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        dupatta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","dupatta");
                Intent intent = new Intent(Apparel_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

        stole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","stole");
                Intent intent = new Intent(Apparel_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        shawls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","apparel");
                map.put("subcat","shawls");
                Intent intent = new Intent(Apparel_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Apparel_Category.this,Category_page.class));
        finish();
    }

}
