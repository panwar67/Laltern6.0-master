package com.example.sparsh23.laltern;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Update extends AppCompatActivity {

    DBHelper dbHelper;
    String DOWN_URL = "http://www.whydoweplay.com/lalten/GetImages.php";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbHelper = new DBHelper(getApplicationContext());
        sessionManager = new SessionManager(getApplicationContext());

        setUpStream();
        ProfileSetup();




    }


    public boolean ProfileSetup(){





        return true;
    }


















    public boolean setUpStream(){

        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Getting Image Data...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, DOWN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {


                        if (s!=null)
                        {



                            try {
                                JSONObject profile = new JSONObject(s);
                                JSONArray data = profile.getJSONArray("ImageData");

                                dbHelper.InitImg();
                                for(int i=0;i<data.length();i++)
                                {
                                    JSONObject details = data.getJSONObject(i);

                                    String uid = details.getString("UID");
                                    String des = details.getString("DESCRIPTION");
                                    String path = details.getString("PATH");
                                    String own = details.getString("OWNER");
                                    String price = details.getString("PRICE");
                                    String quantity = details.getString("QUANTITY");
                                    String title = details.getString("TITLE");
                                    String noimage = details.getString("NOIMAGE");
                                    String type = details.getString("TYPE");
                                    String category = details.getString("CATEGORY");


                                    dbHelper.InsertImageData(uid,des,own,path,price,quantity,title,noimage,type,category);

                                }
                                Log.d("Image data", s);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            startActivity(new Intent( Update.this,Stream.class));
                            finish();


                        }





                        //Disimissing the progress dialog
                        loading.dismiss();
                        //Showing toast message of the response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(Update.this, "Error In Connectivity", Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Converting Bitmap to String


                HashMap<String,String> Keyvalue = new HashMap<String,String>();


                //returning parameters
                return Keyvalue;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        //Adding request to the queue
        requestQueue.add(stringRequest);
        return false;
    }



}
