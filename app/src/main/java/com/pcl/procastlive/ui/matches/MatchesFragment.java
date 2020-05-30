package com.pcl.procastlive.ui.matches;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pcl.procastlive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchesFragment extends Fragment {


  List<PlayerModel> productList;
  RecyclerView recyclerView;


  public MatchesFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root =  inflater.inflate(R.layout.fragment_matches, container, false);

    recyclerView = (RecyclerView)root.findViewById(R.id.recy1);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

    productList = new ArrayList<>();

    productList.add(new PlayerModel(R.drawable.img1));
    productList.add(new PlayerModel(R.drawable.img1));
    productList.add(new PlayerModel(R.drawable.img1));
    productList.add(new PlayerModel(R.drawable.img1));
    productList.add(new PlayerModel(R.drawable.img1));
    productList.add(new PlayerModel(R.drawable.img1));
    productList.add(new PlayerModel(R.drawable.img1));
    productList.add(new PlayerModel(R.drawable.img1));


    PlayerAdapter adapter = new PlayerAdapter(getContext(), productList);

    //setting adapter to recyclerview
    recyclerView.setAdapter(adapter);

    return root;
  }

}
