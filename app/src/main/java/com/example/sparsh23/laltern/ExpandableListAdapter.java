package com.example.sparsh23.laltern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sparsh23 on 06/08/16.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    ArrayList<String> headers = new ArrayList<String>();
    HashMap<String, List<String>> child = new HashMap<String, List<String>>();
    private static LayoutInflater inflater=null;
    Context context;


    public ExpandableListAdapter(HashMap<String, List<String>> Child, ArrayList<String> Headers, Context contxt) {


        context = contxt;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        child = Child;
        headers = Headers;


    }

    @Override
    public int getGroupCount() {


        return headers.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
//        int n = child.get(headers.get(groupPosition)).size();

        return child.get(headers.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return this.headers.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return child.get(headers.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        View rowView;
        rowView = inflater.inflate(R.layout.list_header, null);

        TextView category = (TextView)rowView.findViewById(R.id.list_header_text);

        category.setText(headers.get(groupPosition));





        return rowView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


        View rowView;
        rowView = inflater.inflate(R.layout.list_child, null);

        TextView category = (TextView)rowView.findViewById(R.id.list_child_text);
        category.setText(child.get(headers.get(groupPosition)).get(childPosition));

        return rowView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
