package com.bluesandwich.joaquin.strike.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluesandwich.joaquin.strike.R;

/**
 * Created by joaquin on 3/6/16.
 */
public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View currentView = inflater.inflate(R.layout.fragment_menu, container, false);

        return currentView;
    }
}
