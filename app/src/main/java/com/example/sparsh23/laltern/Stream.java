package com.example.sparsh23.laltern;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Stream extends AppCompatActivity {



    Spinner spinner;
    ImageView search;
    ImageView upload;
    ImageView profile;
    DBHelper dbHelper;
    ListView listView;
     ArrayList<HashMap<String,String>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        dbHelper = new DBHelper(getApplicationContext());

        spinner = (Spinner)findViewById(R.id.catspin);

        search = (ImageView)findViewById(R.id.search);
        data = dbHelper.getimageData();
        listView = (ListView)findViewById(R.id.listView);
       // listView.setAdapter(new CustomAdapter(this,data));

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Stream.this, Search.class));
                finish();


            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                HashMap<String, String> preview = new HashMap<String, String>();
                preview = data.get(position);
                Toast.makeText(getApplication(), "" + preview.get("title"), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Stream.this,ProductView.class);
                intent.putExtra("map",preview);
                startActivity(intent);



            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {





                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),selectedItem,Toast.LENGTH_SHORT).show();


                if(selectedItem.equals("All")){

                    SetcatAdapter(data);

                }else {


                    ArrayList<HashMap<String, String>> catdata = dbHelper.GetCategoryImageData(selectedItem);
                    // listView.setAdapter(new CustomAdapter(this,catdata));
                    SetcatAdapter(catdata);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    upload=(ImageView)findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (Stream.this, Upload.class) );
                finish();
            }
        });
    profile=(ImageView)findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Stream.this,Profile.class));
                finish();
            }
        });


    }


    public void SetcatAdapter(ArrayList<HashMap<String,String>> cat){


        listView.setAdapter(new CustomAdapter(this,cat));


    }

}
