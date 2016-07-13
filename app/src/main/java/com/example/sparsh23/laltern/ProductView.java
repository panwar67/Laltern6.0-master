package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class ProductView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

        Intent intent = getIntent();
        HashMap<String,String> data = (HashMap<String,String>)intent.getSerializableExtra("map");

        int noimg = Integer.parseInt(data.get("noimages"));

        Log.d("No Images", ""+noimg);


        if(noimg>0){

            sliderShow.addSlider(new TextSliderView(this).image( data.get("path")));


            for(int i=1;i<noimg;i++){


                String n =  "http://www.whydoweplay.com/lalten/Images/"+data.get("uid")+"_"+i+".jpeg";

                Log.d("path", n);

                sliderShow.addSlider(new TextSliderView(this).image(n));


            }


        }





    }

}
