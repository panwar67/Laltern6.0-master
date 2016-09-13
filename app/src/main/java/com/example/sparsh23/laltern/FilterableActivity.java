package com.example.sparsh23.laltern;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterableActivity extends AppCompatActivity {


    ToggleButton price, artist, priceL500, priceL1500, priceA2000, priceL5000;
    ArrayList<HashMap<String,ArrayList<String>>> filterdata = new ArrayList<HashMap<String, ArrayList<String>>>();
    ImageView back;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filterable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        button = (Button)findViewById(R.id.filterhomeapply);
        button.setVisibility(View.GONE);
        price = (ToggleButton)findViewById(R.id.productrate);
        artist = (ToggleButton)findViewById(R.id.artistrate);
        priceL500 = (ToggleButton)findViewById(R.id.below500);
        priceL1500 = (ToggleButton)findViewById(R.id.below1500);
        priceA2000 = (ToggleButton)findViewById(R.id.above2000);
        priceL5000 = (ToggleButton)findViewById(R.id.below5000);
        back = (ImageView)findViewById(R.id.backfil);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });






        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(artist.isChecked()){
                    button.setVisibility(View.VISIBLE);


                    artist.setChecked(false);

                }
            }
        });

        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(price.isChecked()){
                    button.setVisibility(View.VISIBLE);


                    price.setChecked(false);

                }

            }
        });

        priceL500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.VISIBLE);
                if(priceL1500.isChecked()){

                    priceL1500.setChecked(false);
                }

                if(priceL5000.isChecked()){

                    priceL5000.setChecked(false);
                }
                if(priceA2000.isChecked()){

                    priceA2000.setChecked(false);
                }

            }
        });

        priceL1500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.VISIBLE);
                if(priceL500.isChecked()){

                    priceL500.setChecked(false);
                }

                if(priceL5000.isChecked()){

                    priceL5000.setChecked(false);
                }
                if(priceA2000.isChecked()){

                    priceA2000.setChecked(false);
                }

            }
        });
        priceL5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.VISIBLE);
                if(priceL1500.isChecked()){

                    priceL1500.setChecked(false);
                }

                if(priceL500.isChecked()){

                    priceL500.setChecked(false);
                }
                if(priceA2000.isChecked()){

                    priceA2000.setChecked(false);
                }

            }
        });
        priceA2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.VISIBLE);
                if(priceL1500.isChecked()){

                    priceL1500.setChecked(false);
                }

                if(priceL5000.isChecked()){

                    priceL5000.setChecked(false);
                }
                if(priceL500.isChecked()){

                    priceL500.setChecked(false);
                }

            }
        });


        if(!priceL5000.isChecked()&&!price.isChecked()&&!priceL500.isChecked()&&!priceL1500.isChecked()&&!priceA2000.isChecked()&&!artist.isChecked())
        {
            button.setVisibility(View.GONE);
        }







    }

}
