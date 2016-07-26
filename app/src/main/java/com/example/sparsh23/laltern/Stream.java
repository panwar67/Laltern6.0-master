package com.example.sparsh23.laltern;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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



    ImageView search;
    ImageView upload;
    ImageView profile;
    DBHelper dbHelper;
    ListView listView;
    HashMap<String,String> map = new HashMap<String, String>();
     ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        dbHelper = new DBHelper(getApplicationContext());
        search = (ImageView)findViewById(R.id.search);

        Intent intent = getIntent();
        map = (HashMap<String, String>)intent.getSerializableExtra("map");
        data = dbHelper.GetSubCategoryImageData(map);
       // Log.d("artist UID Stream",data.get("artuid"));
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(this,data));
       // listView.setAdapter(new CustomAdapter(this,data));

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Stream.this, Search.class).putExtra("map",map));
                finish();


            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                HashMap<String, String> preview = new HashMap<String, String>();
                preview = data.get(position);
                Log.d("art uid stream",preview.get("artuid"));
                Toast.makeText(getApplication(), "" + preview.get("title"), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Stream.this,ProductView.class);
                intent.putExtra("promap",preview);
                startActivity(intent);



            }
        });




    upload=(ImageView)findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (Stream.this, Upload.class).putExtra("map",map) );
                finish();
            }
        });
    profile=(ImageView)findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Stream.this,Profile.class).putExtra("map",map));
                finish();
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Stream.this,Category_page.class));
        finish();
    }
}
