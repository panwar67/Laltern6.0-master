package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class ProductView extends AppCompatActivity {

    TextView title , des, quan, price;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        button= (Button)findViewById(R.id.submitreq);


        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);



        Intent intent = getIntent();
        final HashMap<String,String> data = (HashMap<String,String>)intent.getSerializableExtra("promap");

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

        title = (TextView)findViewById(R.id.headerpro);
        des = (TextView)findViewById(R.id.descriptionpartpro);
        quan = (TextView)findViewById(R.id.quantitypro);
        price = (TextView)findViewById(R.id.pricepro);

        price.setText(data.get("price"));
        des.setText(data.get("des"));
        quan.setText(data.get("quantity"));
        title.setText(data.get("title"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(ProductView.this,SubmitRequest.class);
                intent1.putExtra("map",data);
                startActivity(intent1);


            }
        });











    }

}
