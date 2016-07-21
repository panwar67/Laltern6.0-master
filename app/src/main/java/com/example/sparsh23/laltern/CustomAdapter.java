package com.example.sparsh23.laltern;

/**
 * Created by Sparsh23 on 08/07/16.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter extends BaseAdapter{

    Context context;

    ImageLoader imageLoader;
    DisplayImageOptions options;

    ArrayList<HashMap<String,String>> result = new ArrayList<HashMap<String, String>>();
    private static LayoutInflater inflater=null;
    public CustomAdapter(Stream mainActivity, ArrayList<HashMap<String,String>> imagesdata) {
        // TODO Auto-generated constructor stub
        result=imagesdata;
        context=mainActivity;

        //imageLoader.destroy();
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


       options = new DisplayImageOptions.Builder().cacheOnDisk(true).cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).build();
        ImageLoaderConfiguration.Builder config1 = new ImageLoaderConfiguration.Builder(context);
        config1.defaultDisplayImageOptions(options);
        config1.threadPriority(Thread.NORM_PRIORITY - 2);
        config1.denyCacheImageMultipleSizesInMemory();
        config1.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config1.diskCacheSize(100 * 1024 * 1024); // 50 MiB
        config1.tasksProcessingOrder(QueueProcessingType.LIFO);
        config1.writeDebugLogs();





            imageLoader = ImageLoader.getInstance();
//        imageLoader.destroy();
            imageLoader.init(config1.build());









    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView tv1;
        ImageView img;
        TextView price;
        TextView quantity;
        TextView title;
        TextView description;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.stream_row, null);
        holder.price=(TextView) rowView.findViewById(R.id.price);
        holder.quantity = (TextView) rowView.findViewById(R.id.quantity);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);
        holder.description = (TextView)rowView.findViewById(R.id.descriptionpart);
        holder.title = (TextView)rowView.findViewById(R.id.header);

        holder.price.setText(result.get(position).get("price"));
        holder.description.setText(result.get(position).get("des"));
        holder.quantity.setText(result.get(position).get("quantity"));
        holder.title.setText(result.get(position).get("title"));



        imageLoader.displayImage(result.get(position).get("path"), holder.img);

        return rowView;
    }

}
