package com.example.sparsh23.laltern;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

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



        TextSliderView textSliderView = new TextSliderView(this);
        TextSliderView textSliderView1 = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones").image("http://www.whydoweplay.com/lalten/Images/20160708174522.jpeg");

        textSliderView.image("http://www.whydoweplay.com/lalten/Images/20160708174743.jpeg").description("fuck off");




        sliderShow.addSlider(new TextSliderView(this).image("http://www.whydoweplay.com/lalten/Images/20160708174743.jpeg"));
        sliderShow.addSlider(new TextSliderView(this).image("http://www.whydoweplay.com/lalten/Images/20160708174522.jpeg"));



    }

}
