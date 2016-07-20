package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Home_Texile_Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__texile__category);
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
        ImageView cushioncovers,rugsanddhurries,quilts,bedlinen,tableinen;

        cushioncovers=(ImageView)findViewById(R.id.cushioncover);
        rugsanddhurries=(ImageView)findViewById(R.id.rugsanddhurries);
        quilts=(ImageView)findViewById(R.id.quilts);
        bedlinen=(ImageView)findViewById(R.id.bedlilen);
        tableinen=(ImageView)findViewById(R.id.tablelinen);

        cushioncovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Texile_Category.this,Stream.class));
            }
        });

        rugsanddhurries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Texile_Category.this,Stream.class));
            }
        });

        quilts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Texile_Category.this,Stream.class));
            }
        });

        bedlinen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Texile_Category.this,Stream.class));
            }
        });

        tableinen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Texile_Category.this,Stream.class));
            }
        });
    }

}
