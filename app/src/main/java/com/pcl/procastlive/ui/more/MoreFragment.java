package com.pcl.procastlive.ui.more;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pcl.procastlive.LoginActivity;
import com.pcl.procastlive.R;
import static com.pcl.procastlive.LoginActivity.booltype;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

  TextView logouttxt, notifitxt, logintxt;
  String playername;


  public MoreFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root = inflater.inflate(R.layout.fragment_more, container, false);

    SharedPreferences pref = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    booltype=pref.getBoolean("Booltype", Boolean.parseBoolean(""));
    playername = pref.getString("name","");

    logouttxt = (TextView)root.findViewById(R.id.text10);
    notifitxt = (TextView)root.findViewById(R.id.textnoti);
    logintxt = (TextView)root.findViewById(R.id.textlgn);
    logintxt.setText(playername);

    logouttxt.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        booltype=false;
        SharedPreferences pref = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putBoolean("Booltype",booltype);
        edit.apply();
        startActivity(new Intent(getActivity(), LoginActivity.class));

      }
    });

    return root;
  }

}
