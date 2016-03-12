package com.bluesandwich.joaquin.strike.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bluesandwich.joaquin.strike.R;
import com.bluesandwich.joaquin.strike.data.model.SKAudioRequest;
import com.bluesandwich.joaquin.strike.data.model.SKUser;
import com.bluesandwich.joaquin.strike.ui.adapter.HomeArrayAdapter;

import java.util.List;

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

    public interface HomeFragmentCallback{
        SKUser getCurrentUser();
        void newAudioRequest();
        List<SKAudioRequest> getNewestAudioRequests(int top, long offsetDate);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //this.currentUserId = ((HomeFragmentCallback)getActivity()).getCurrentUser().identifier;
        //this.currentUserName = ((HomeFragmentCallback)getActivity()).getCurrentUser().name;
        //this.currentUser = ((HomeFragmentCallback)getActivity()).getCurrentUser();

        final View currentView = inflater.inflate(R.layout.fragment_home, container, false);

        //listView = (ListView) currentView.findViewById(R.id.home_listview);

        adapter = new HomeArrayAdapter(getActivity().getApplicationContext(), R.layout.fragment_home_audio_req_listitem);
        adapter.setCurrentUserId(currentUserId);

        listView.setAdapter(adapter);

        // just for example

        SKAudioRequest ar1 = new SKAudioRequest();
        SKAudioRequest ar2 = new SKAudioRequest();
        SKAudioRequest ar3 = new SKAudioRequest();
        adapter.add(ar1);
        adapter.add(ar2);
        adapter.add(ar3);

        return currentView;
    }

}
