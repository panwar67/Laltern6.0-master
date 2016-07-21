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

public class Home_Decor_Category extends AppCompatActivity {

    ImageView lamps,woodendecor,marbledecor,stonedecor,ceramic,boneandhorn,papermache,decormisc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__decor__category);


        lamps=(ImageView)findViewById(R.id.lamps);
        woodendecor=(ImageView)findViewById(R.id.woodendecor);
        marbledecor=(ImageView)findViewById(R.id.marbeldecor);
        stonedecor=(ImageView)findViewById(R.id.stonedecor);
        ceramic=(ImageView)findViewById(R.id.ceramic);
        boneandhorn=(ImageView)findViewById(R.id.boneandhorn);
        papermache=(ImageView)findViewById(R.id.papermache);
        decormisc=(ImageView)findViewById(R.id.decormics);

        lamps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","lamps");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);
                startActivity(intent);
            }
        });

        woodendecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","woodendecor");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });
        marbledecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","marbledecor");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

        stonedecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","stonedecor");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

        ceramic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","ceramic");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        boneandhorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","boneandhorn");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

        papermache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","papermache");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

        decormisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","homedecor");
                map.put("subcat","decormics");

                Intent intent = new Intent(Home_Decor_Category.this,Stream.class);

                intent.putExtra("map", map);
                startActivity(intent);

            }
        });

    }

}
