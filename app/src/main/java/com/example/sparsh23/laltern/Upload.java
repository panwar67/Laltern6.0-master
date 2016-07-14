package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Upload extends AppCompatActivity {


    ImageView profile;
    ImageView stream;
    ImageView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        profile=(ImageView)findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Upload.this,Profile.class));
                finish();
            }
        });

        stream=(ImageView)findViewById(R.id.feed);
        stream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Upload.this, Stream.class));
                finish();
            }
        });
        search=(ImageView)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Upload.this,Search.class));
                finish();
            }
        });

        }

}
