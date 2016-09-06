package com.example.sparsh23.laltern;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FilterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Spinner cat, subcat, sizeall, color, producttype;
    DBHelper dbHelper;
    ArrayList<String> catitems = new ArrayList<String>();

    HashMap<String,String> map = new HashMap<String, String>();
    ArrayList< HashMap<String,ArrayList<String>>> spinnerdata = new ArrayList<HashMap<String, ArrayList<String>>>();



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FilterFragment()

    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilterFragment newInstance(String param1, String param2) {
        FilterFragment fragment = new FilterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_filter, container, false);



        dbHelper = new DBHelper(getContext());




        spinnerdata = dbHelper.GetCategories();




        for (int i = 0;i<spinnerdata.size();i++)
        {
            catitems.add(String.valueOf(spinnerdata.get(i).entrySet().iterator().next().getKey()));
            Log.d("cat spin item",""+spinnerdata.get(i).entrySet().iterator().next().getKey());

        }












        producttype = (Spinner)root.findViewById(R.id.producttypespinner);
        sizeall = (Spinner)root.findViewById(R.id.sizespinner);
        color = (Spinner)root.findViewById(R.id.colorspinner);

        cat = (Spinner)root.findViewById(R.id.catspin);
        subcat = (Spinner)root.findViewById(R.id.subcatspin);




        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,catitems);
        cat.setAdapter(arrayAdapter);
        cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<String> subcatslist = new ArrayList<String>();
                for(int i = 0;i<spinnerdata.size();i++)
                {

                    Log.d("spinner size",""+spinnerdata.size());



                    if(spinnerdata.get(i).entrySet().iterator().next().getKey().equals(catitems.get(position)))
                    {


                        subcat.setAdapter(new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,spinnerdata.get(i).get(catitems.get(position))));


                    }





                }





            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        subcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Log.d("subcatselect",""+subcat.getSelectedItem());

                sizeall.setAdapter(new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,dbHelper.GetSizes(cat.getSelectedItem().toString(),subcat.getSelectedItem().toString())));
                color.setAdapter(new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,dbHelper.GetColor(String.valueOf(cat.getSelectedItem()),String.valueOf(subcat.getSelectedItem()))));


                producttype.setAdapter( new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,dbHelper.GetProType(String.valueOf(cat.getSelectedItem()),String.valueOf(subcat.getSelectedItem()))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });










        // Inflate the layout for this fragment
        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
