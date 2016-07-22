package com.example.sparsh23.laltern;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SubmitRequest extends AppCompatActivity {

    String DOWN_URL = "http://www.whydoweplay.com/lalten/InsertReq.php";
    SessionManager sessionManager;
    DBHelper dbHelper;
    HashMap<String, String> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_request);
        dbHelper = new DBHelper(getApplicationContext());
        sessionManager = new SessionManager(getApplicationContext());

        Intent intent = getIntent();
         hashMap = (HashMap<String, String>)intent.getSerializableExtra("map");
        final EditText editText = (EditText)findViewById(R.id.desreq);
        final HashMap<String,String> map = sessionManager.getUserDetails();
        dbHelper.GetProfile().get("uid");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String des = editText.getText().toString();
                String prouid = hashMap.get("uid");
                String useruid = dbHelper.GetProfile().get("uid");
                Log.d("Request data ", ""+des+" pro "+prouid+"user "+useruid);

                upload_data(prouid,useruid,des,hashMap.get("path"));
         }
        });
    }



    public void upload_data(final String prouid, final String buyuid, final String des, final String path)

    {
        final ProgressDialog loading = ProgressDialog.show(this,"Registering User...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, DOWN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        Toast.makeText(getApplicationContext(),s.toString(),Toast.LENGTH_SHORT).show();

                        loading.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();


                        //Showing toast
                        Toast.makeText(SubmitRequest.this, "Error In Connectivity"+volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Converting Bitmap to String



                String uid=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

                HashMap<String,String> Keyvalue = new HashMap<String,String>();
                Keyvalue.put("prouid",prouid);
                Keyvalue.put("buyuid",buyuid);
                Keyvalue.put("des",des);
                Keyvalue.put("requid",uid);
                Keyvalue.put("path",path);



                return Keyvalue;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(SubmitRequest.this,ProductView.class).putExtra("promap",hashMap));
        finish();


    }
}
