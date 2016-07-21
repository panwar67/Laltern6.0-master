package com.example.sparsh23.laltern;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Search extends AppCompatActivity {

    ImageView upload;
    ImageView profile;
    ImageView stream;

    ArrayList<HashMap<String, String>> piddi = new ArrayList<HashMap<String, String>>();
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        dbHelper = new DBHelper(getApplicationContext());




        final ListView listView = (ListView)findViewById(R.id.listView);





        final TextView searchtext=(TextView)findViewById(R.id.textsearch);
        Button b=(Button)findViewById(R.id.searchbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchstg= String.valueOf(searchtext.getText());
                piddi=dbHelper.GetSearchImageData(searchstg);

                listView.setAdapter(new SearchAdapter(Search.this,piddi)                );


            }
        });


        upload=(ImageView)findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (Search.this, Upload.class) );
                finish();
            }
        });
        profile=(ImageView)findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this,Profile.class));
                finish();
            }
        });

       stream=(ImageView)findViewById(R.id.feed);
        stream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Search.this, Stream.class));
                finish();
            }
        });


    }

}
