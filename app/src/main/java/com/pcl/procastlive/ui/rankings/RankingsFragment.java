package com.pcl.procastlive.ui.rankings;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pcl.procastlive.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RankingsFragment extends Fragment {


    public RankingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rankings, container, false);
    }

}
