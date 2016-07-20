package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Home_Decor_Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__decor__category);
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

        ImageView lamps,woodendecor,marbledecor,stonedecor,ceramic,boneandhorn,papermache,decormisc;

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
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });

        woodendecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });
        marbledecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });

        stonedecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });

        ceramic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });

        boneandhorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });

        papermache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });

        decormisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Decor_Category.this,Stream.class));
            }
        });

    }

}
