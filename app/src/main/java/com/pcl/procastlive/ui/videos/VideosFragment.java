package com.pcl.procastlive.ui.videos;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pcl.procastlive.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment {




    public VideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_vedios, container, false);


        return root;
    }

}
