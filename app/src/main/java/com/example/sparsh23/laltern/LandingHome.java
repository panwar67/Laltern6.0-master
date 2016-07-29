package com.example.sparsh23.laltern;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LandingHome.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LandingHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LandingHome extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageLoader imageLoader;
    DisplayImageOptions options;
    ArrayList<HashMap<String,String>> artistdata = new ArrayList<HashMap<String, String>>();


    private OnFragmentInteractionListener mListener;
    DBHelper dbHelper;
    ArrayList<HashMap<String,String>> map = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String,String>> finaldata = new ArrayList<HashMap<String, String>>();


    public LandingHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LandingHome.
     */
    // TODO: Rename and change types and number of parameters
    public static LandingHome newInstance() {
        LandingHome fragment = new LandingHome();
        Bundle args = new Bundle();
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

        options = new DisplayImageOptions.Builder().cacheOnDisk(true).cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565).imageScaleType(ImageScaleType.EXACTLY).resetViewBeforeLoading(true).build();
        ImageLoaderConfiguration.Builder config1 = new ImageLoaderConfiguration.Builder(getContext());
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


        dbHelper = new DBHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        ArrayList<HashMap<String,String>> statedata = new ArrayList<HashMap<String, String>>();

        ArrayList<HashMap<String,String>> craft = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String,String>> sponc = new ArrayList<HashMap<String, String>>();

        View rootView = inflater.inflate(R.layout.fragment_landing_home, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.landinglist);



        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.sliderlayout, listView,false);

        listView.addHeaderView(header,null,true);









        SliderLayout sliderShow = (SliderLayout) header.findViewById(R.id.sliderlandingtrending);
        final SliderLayout artistslider = (SliderLayout)header.findViewById(R.id.sliderlandingartist);
        artistslider.setPresetTransformer(SliderLayout.Transformer.Fade);
        artistslider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
        sliderShow.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
        sliderShow.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);


        artistdata = dbHelper.getimageDatatype("landingartist");
        finaldata = dbHelper.getimageDatatype("landing");







        for(int i =0; i<artistdata.size();i++)
        {

            Log.d("slider artist size",""+artistdata.size());
                artistslider.addSlider(new DefaultSliderView(getContext()).image(artistdata.get(i).get("path")).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(getContext(),""+artistdata.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("type", artistdata.get(0).get("meta"));
                        DealsFragment nextFrag= new DealsFragment();
                        nextFrag.setArguments(bundle);
                        getFragmentManager().beginTransaction()
                                .replace(R.id.navrep, nextFrag,null)
                                .addToBackStack(null)
                                .commit();

                    }
                }));

        }






        map = dbHelper.getimageData();
       // finaldata = dbHelper.getimageDatatype("deals");


        for(int i =0; i<map.size();i++)
        {



            if(map.get(i).get("type").equals("trending"))

            {

                sliderShow.addSlider(new DefaultSliderView(getContext()).image(map.get(i).get("path")));


            }


        }

        Log.d("final deals size", ""+finaldata.size());



        LandingHomeListAdapter landingHomeListAdapter = new LandingHomeListAdapter(getContext(),finaldata);
        listView.setAdapter(landingHomeListAdapter);
        landingHomeListAdapter.notifyDataSetChanged();



        header.findViewById(R.id.sliderlandingartist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),""+artistdata.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("type", artistdata.get(0).get("meta"));
                DealsFragment nextFrag= new DealsFragment();
                nextFrag.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .replace(R.id.navrep, nextFrag,null)
                        .addToBackStack(null)
                        .commit();

            }
        });

        artistslider.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();
                switch (eventaction) {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(getContext(),""+artistdata.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("type", artistdata.get(0).get("meta"));
                        DealsFragment nextFrag= new DealsFragment();
                        nextFrag.setArguments(bundle);
                        getFragmentManager().beginTransaction()
                                .replace(R.id.navrep, nextFrag,null)
                                .addToBackStack(null)
                                .commit();
                        //transition.startTransition(duration);
                        //Tell Android that you can handle this MotionEvent, and you
                        //want to keep informed of further events of this touch
                        return true;
                    //break;
                    case MotionEvent.ACTION_UP:
                        //transition.reverseTransition(duration);
                        break;
                }
                // tell the system that we handled the event but a further processing is required
                return false;
            }



        });



        artistslider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),""+artistdata.get(0).get("meta"),Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("type", artistdata.get(0).get("meta"));
                DealsFragment nextFrag= new DealsFragment();
                nextFrag.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .replace(R.id.navrep, nextFrag,null)
                        .addToBackStack(null)
                        .commit();


            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){

                    Toast.makeText(getContext(),"header clicked",Toast.LENGTH_LONG).show();
                }

                Toast.makeText(getContext(),""+id,Toast.LENGTH_SHORT).show();

                HashMap<String, String> preview = new HashMap<String, String>();
                preview = finaldata.get(position-1);
                Log.d("landing selected",preview.toString());
                Toast.makeText(getContext(), "" + preview.get("meta"), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("type", preview.get("meta"));

                if (preview.get("type").equals("landing"))
                {



                    DealsFragment nextFrag= new DealsFragment();
                    nextFrag.setArguments(bundle);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.navrep, nextFrag,null)
                            .addToBackStack(null)
                            .commit();



                }
            }
        });




        // Inflate the layout for this fragment
        return rootView;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {





        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onResume()
    {

        super.onResume();
    }
}
