package com.example.sparsh23.laltern;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.sparsh23.laltern.dummy.DummyContent;
import com.example.sparsh23.laltern.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class categoryFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    String type;
    // TODO: Customize parameters
    private int mColumnCount = 2;
    DBHelper dbHelper;
    ArrayList<HashMap<String,String>> category = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String,String>> viewall = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String,String>> jewelec = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String,String>> jewelcs = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String,String>> jewelpa = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String,String>> jeweltp = new ArrayList<HashMap<String, String>>();
    private OnListFragmentInteractionListener mListener1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public categoryFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static categoryFragment newInstance() {
        categoryFragment fragment = new categoryFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            type = getArguments().getString("type");


        }

        dbHelper = new DBHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        viewall = dbHelper.getimageDatatype("jewelcatall");
        jewelpa = dbHelper.getimageDatatype("jewelcatpa");
        jewelcs = dbHelper.getimageDatatype("jewelcatcs");
        jewelec = dbHelper.getimageDatatype("jewelcatec");
        jeweltp = dbHelper.getimageDatatype("jewelcatpt");


        category = dbHelper.getimageDatatype("jewelcat");
        View view = inflater.inflate(R.layout.fragment_deals, container, false);

        ListView listView = (ListView) view.findViewById(R.id.dealslist);

        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.categoryslider, listView,false);



        listView.addHeaderView(header,null,true);
        listView.setAdapter(new DealsAdapter(getContext(),category));



        SliderLayout sliderShow = (SliderLayout) header.findViewById(R.id.sliderviewall);
        final SliderLayout ecslider = (SliderLayout)header.findViewById(R.id.sliderec);
        ecslider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        ecslider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
        final SliderLayout paslider = (SliderLayout)header.findViewById(R.id.sliderpa);
        paslider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        paslider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);


        final SliderLayout ptslider = (SliderLayout)header.findViewById(R.id.slidertp);
        ptslider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        ptslider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);

        final SliderLayout csslider = (SliderLayout)header.findViewById(R.id.slidercs);
        csslider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        csslider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);






        sliderShow.setPresetTransformer(SliderLayout.Transformer.Fade
        );
        sliderShow.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);

        for(int i =0; i<viewall.size();i++)
        {

            Log.d("slider jewel all size",""+viewall.size());
            sliderShow.addSlider(new DefaultSliderView(getContext()).image(viewall.get(i).get("path")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getContext(),""+viewall.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                   // Bundle bundle = new Bundle();bundle.putString("type", artistdata.get(0).get("meta"));DealsFragment nextFrag= new DealsFragment();nextFrag.setArguments(bundle);getFragmentManager().beginTransaction().replace(R.id.navrep, nextFrag,null).addToBackStack(null).commit();

                }
            }));

        }



        for(int i =0; i<jewelpa.size();i++)
        {

            Log.d("slider jewel all size",""+viewall.size());
            paslider.addSlider(new DefaultSliderView(getContext()).image(jewelpa.get(i).get("path")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getContext(),""+viewall.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                    // Bundle bundle = new Bundle();bundle.putString("type", artistdata.get(0).get("meta"));DealsFragment nextFrag= new DealsFragment();nextFrag.setArguments(bundle);getFragmentManager().beginTransaction().replace(R.id.navrep, nextFrag,null).addToBackStack(null).commit();

                }
            }));

        }


        for(int i =0; i<jeweltp.size();i++)
        {

            Log.d("slider jewel all size",""+viewall.size());
            ptslider.addSlider(new DefaultSliderView(getContext()).image(jeweltp.get(i).get("path")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getContext(),""+viewall.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                    // Bundle bundle = new Bundle();bundle.putString("type", artistdata.get(0).get("meta"));DealsFragment nextFrag= new DealsFragment();nextFrag.setArguments(bundle);getFragmentManager().beginTransaction().replace(R.id.navrep, nextFrag,null).addToBackStack(null).commit();

                }
            }));

        }


        for(int i =0; i<jewelcs.size();i++)
        {

            Log.d("slider jewel all size",""+viewall.size());
            csslider.addSlider(new DefaultSliderView(getContext()).image(jewelcs.get(i).get("path")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getContext(),""+viewall.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                    // Bundle bundle = new Bundle();bundle.putString("type", artistdata.get(0).get("meta"));DealsFragment nextFrag= new DealsFragment();nextFrag.setArguments(bundle);getFragmentManager().beginTransaction().replace(R.id.navrep, nextFrag,null).addToBackStack(null).commit();

                }
            }));

        }


        for(int i =0; i<jewelec.size();i++)
        {

            Log.d("slider jewel all size",""+viewall.size());
            ecslider.addSlider(new DefaultSliderView(getContext()).image(jewelec.get(i).get("path")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getContext(),""+viewall.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                    // Bundle bundle = new Bundle();bundle.putString("type", artistdata.get(0).get("meta"));DealsFragment nextFrag= new DealsFragment();nextFrag.setArguments(bundle);getFragmentManager().beginTransaction().replace(R.id.navrep, nextFrag,null).addToBackStack(null).commit();

                }
            }));

        }























        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }


            recyclerView.setAdapter(new MycategoryRecyclerViewAdapter(DummyContent.ITEMS, mListener1));

        }


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener1 = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener1 = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

}
