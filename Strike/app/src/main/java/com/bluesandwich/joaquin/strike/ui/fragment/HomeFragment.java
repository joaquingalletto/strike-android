package com.bluesandwich.joaquin.strike.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bluesandwich.joaquin.strike.R;
import com.bluesandwich.joaquin.strike.data.model.SKUser;
import com.bluesandwich.joaquin.strike.ui.adapter.HomeArrayAdapter;

/**
 * Created by joaquin on 3/6/16.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "STRIKE_" + HomeFragment.class.getSimpleName();

    private HomeArrayAdapter adapter;
    private ListView listView;

    private String currentUserId;
    private String currentUserName;
    private SKUser currentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;

    }

}
