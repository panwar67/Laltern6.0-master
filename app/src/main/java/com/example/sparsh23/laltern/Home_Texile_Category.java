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

public class Home_Texile_Category extends AppCompatActivity {


    ImageView cushioncovers,rugsanddhurries,quilts,bedlinen,tableinen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__texile__category);

        cushioncovers=(ImageView)findViewById(R.id.cushioncover);
        rugsanddhurries=(ImageView)findViewById(R.id.rugsanddhurries);
        quilts=(ImageView)findViewById(R.id.quilts);
        bedlinen=(ImageView)findViewById(R.id.bedlilen);
        tableinen=(ImageView)findViewById(R.id.tablelinen);

        cushioncovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","hometextiles");
                map.put("subcat","cushioncovers");
                Intent intent = new Intent(Home_Texile_Category.this,Stream.class) ;
                startActivity(intent);

            }
        });

        rugsanddhurries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","hometextiles");
                map.put("subcat","rugsanddhurries");
                Intent intent = new Intent(Home_Texile_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);    }
        });

        quilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","hometextiles");
                map.put("subcat","quilts");
                Intent intent = new Intent(Home_Texile_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        bedlinen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","hometextiles");
                map.put("subcat","bedlinen");
                Intent intent = new Intent(Home_Texile_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        tableinen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","hometextiles");
                map.put("subcat","tableinen");
                Intent intent = new Intent(Home_Texile_Category.this,Stream.class);

                intent.putExtra("map", map);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Home_Texile_Category.this,Category_page.class));
        finish();
    }

}
