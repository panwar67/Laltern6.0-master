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

public class Sarees_Category extends AppCompatActivity {
    ImageView woven,printed,embroidery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarees__category);



        woven=(ImageView)findViewById(R.id.woven);
        printed=(ImageView)findViewById(R.id.printed);
        embroidery=(ImageView)findViewById(R.id.embriodery);

        woven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","sarees");
                map.put("subcat","woven");
                Intent intent = new Intent(Sarees_Category.this,Stream.class);

                intent.putExtra("map", map);

                startActivity(intent);


            }
        });

      printed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","sarees");
                map.put("subcat","printed");
                Intent intent = new Intent(Sarees_Category.this,Stream.class);
                intent.putExtra("map", map);

                startActivity(intent);

            }
        });

   embroidery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put("category","sarees");
                map.put("subcat","embroidery");
                Intent intent = new Intent(Sarees_Category.this,Stream.class);
                intent.putExtra("map", map);

                startActivity(intent);
            }
        });
}
}