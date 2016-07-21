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

public class Others_Category extends AppCompatActivity {

    ImageView miscellaneous,wastepaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        miscellaneous=(ImageView)findViewById(R.id.miscellaneouscrafts);
        wastepaper=(ImageView)findViewById(R.id.wastepaperproducts);

        miscellaneous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","others");
                map.put("subcat","miscellaneous");
                Intent intent = new Intent(Others_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });

        wastepaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","others");
                map.put("subcat","wastepaper");
                Intent intent = new Intent(Others_Category.this,Stream.class);
                intent.putExtra("map", map);
                startActivity(intent);
            }
        });
    }

}
