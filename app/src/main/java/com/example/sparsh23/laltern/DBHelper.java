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
import android.provider.ContactsContract;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "laltern.db";



    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("CREATE TABLE ImageData (UID text, DES text, OWN text, PRICE float, PATH text, TYPE text, QUANTITY int, NOIMAGES int, OWNER text, TITLE text, CATEGORY text, SUBCAT text, TAGS text )");
        db.execSQL("CREATE TABLE "+Profile_Strut.Table_Name+" ( "+Profile_Strut.Uid+" text, "+Profile_Strut.Name+" text, "+Profile_Strut.Comp_Name+" text, "+Profile_Strut.Designation+" text, "+Profile_Strut.Addr+" text, "+Profile_Strut.City+" text, "+Profile_Strut.Email+" text, "+Profile_Strut.Cont+" text, "+Profile_Strut.State+" text, "+Profile_Strut.ToB+" text, "+Profile_Strut.Pan+" text, "+Profile_Strut.Web+" text)");


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



    public boolean InitProfile(){

        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM PROFILE");
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
            map.put("noimages", String.valueOf(nopic));



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


    public boolean InsertProfileData (String uid, String name, String comp, String design, String tob, String cont, String email, String addr,
                                      String city,
                                      String state, String pan, String webs)

    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Profile_Strut.Name, name);
        contentValues.put(Profile_Strut.Comp_Name, comp);
        contentValues.put(Profile_Strut.Designation, design);
        contentValues.put(Profile_Strut.ToB, tob);
        contentValues.put(Profile_Strut.Cont, cont);
        contentValues.put(Profile_Strut.Email, email);
        contentValues.put(Profile_Strut.Addr, addr);
        contentValues.put(Profile_Strut.City,city);
        contentValues.put(Profile_Strut.State,state);
        contentValues.put(Profile_Strut.Pan,pan);
        contentValues.put(Profile_Strut.Uid, uid);
        contentValues.put(Profile_Strut.Web, webs);
        long row = db.insertWithOnConflict(Profile_Strut.Table_Name,null,contentValues, SQLiteDatabase.CONFLICT_IGNORE);
        Log.d("Profile Data", String.valueOf(row)+"inserted");
        return  true;
    }


    public HashMap<String,String> GetProfile()
    {

        HashMap<String,String> map = new HashMap<String, String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+Profile_Strut.Table_Name, null);
        res.moveToFirst();
        while (!res.isAfterLast())
        {

            map.put("name",res.getString(res.getColumnIndex(Profile_Strut.Name)));
            map.put("comp",res.getString(res.getColumnIndex(Profile_Strut.Comp_Name)));
            map.put("design",res.getString(res.getColumnIndex(Profile_Strut.Designation)));
            map.put("tob",res.getString(res.getColumnIndex(Profile_Strut.ToB)));
            map.put("cont",res.getString(res.getColumnIndex(Profile_Strut.Cont)));
            map.put("email",res.getString(res.getColumnIndex(Profile_Strut.Email)));
            map.put("addr",res.getString(res.getColumnIndex(Profile_Strut.Addr)));
            map.put("city",res.getString(res.getColumnIndex(Profile_Strut.City)));
            map.put("state",res.getString(res.getColumnIndex(Profile_Strut.State)));
            map.put("pan",res.getString(res.getColumnIndex(Profile_Strut.Pan)));
            map.put("uid",res.getString(res.getColumnIndex(Profile_Strut.Uid)));
            map.put("web",res.getString(res.getColumnIndex(Profile_Strut.Web)));

            Log.d("Profile fetching uid","" +res.getString(res.getColumnIndex(Profile_Strut.Uid)));

            res.moveToNext();
        }

        return map;

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


    public ArrayList<HashMap<String,String>> GetCategoryImageData(String selectedItem) {


        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from ImageData where CATEGORY ='"+selectedItem+"';", null);

        res.moveToFirst();
        while (res.isAfterLast() == false)
        {
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
            map.put("noimages", String.valueOf(nopic));



            data.add(map);
            res.moveToNext();
        }

        return data;

    }
}
