package com.example.sparsh23.laltern;

/**
 * Created by Sparsh23 on 08/07/16.
 */

import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteDatabase;
        import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "coach.db";



    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("CREATE TABLE ImageData (UID text, DES text, OWN text, PRICE float, PATH text, TYPE text, QUANTITY int, NOIMAGES int, OWNER text, TITLE text, CATEGORY text  )");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS ImageData");
        onCreate(db);
    }




    public boolean InitImg()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM ImageData");
        Log.d("sql","Deleted");




        return true;
    }

    public ArrayList<HashMap<String,String>> GetSearchImageData(String query) {

        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from ImageData where TITLE LIKE '%"+query+"%';", null);

        res.moveToFirst();
         while (res.isAfterLast() == false) {
            HashMap<String, String> map = new HashMap<String, String>();
            String path = res.getString(res.getColumnIndex("PATH"));


            String uid = res.getString(res.getColumnIndex("UID"));


             String des = res.getString(res.getColumnIndex("DES"));
             String title = res.getString(res.getColumnIndex("TITLE"));
             String price = res.getString(res.getColumnIndex("PRICE"));
             String quantity = res.getString(res.getColumnIndex("QUANTITY"));
             int nopic = res.getInt(res.getColumnIndex("NOIMAGES"));

             map.put("uid",uid);
             map.put("path",path);
             map.put("des",des);
             map.put("title", title);
             map.put("price",price);
             map.put("quantity",quantity);
             map.put("NOIMAGES", String.valueOf(nopic));



             data.add(map);
             res.moveToNext();
        }

        return data;
    }



    public boolean InsertImageData  (String uid,String des, String own, String path, String price, String quantity, String title, String noimages, String type, String category)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UID", uid);
        contentValues.put("PRICE",price);
        contentValues.put("QUANTITY", quantity);
        contentValues.put("NOIMAGES", noimages);
        contentValues.put("TITLE", title);
        contentValues.put("TYPE",type);
        contentValues.put("CATEGORY",category);
        contentValues.put("DES", des);
        contentValues.put("OWN", own);
        contentValues.put("PATH", path);
        long row = db.insertWithOnConflict("ImageData", null, contentValues, SQLiteDatabase.CONFLICT_IGNORE);
        Log.d("ImageData", String.valueOf(row)+"inserted");
        return true;
    }




    public ArrayList<HashMap<String,String>> getimageData()
    {

        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from ImageData ", null);
        res.moveToFirst();
        String pass = null;
        while (res.isAfterLast() == false)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            String path = res.getString(res.getColumnIndex("PATH"));
            String uid = res.getString(res.getColumnIndex("UID"));
            String own = res.getString(res.getColumnIndex("OWN"));
            String des = res.getString(res.getColumnIndex("DES"));
            String title = res.getString(res.getColumnIndex("TITLE"));
            String category = res.getString(res.getColumnIndex("CATEGORY"));
            String quantity = res.getString(res.getColumnIndex("QUANTITY"));
            String price = res.getString(res.getColumnIndex("PRICE"));
            String noimages = res.getString(res.getColumnIndex("NOIMAGES"));
            String type = res.getString(res.getColumnIndex("TYPE"));

            map.put("uid",uid);
            map.put("path",path);
            map.put("own",own);
            map.put("des",des);
            map.put("title",title);
            map.put("category", category);
            map.put("quantity", quantity);
            map.put("price", price);
            map.put("noimages",noimages);
            map.put("type",type);
            data.add(map);
            res.moveToNext();
        }
        return data;
    }



    public Cursor Getprofiledata(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from PROFILE", null);

        res.moveToFirst();
//        cursor.moveToFirst();
        return  res;
    }


}
