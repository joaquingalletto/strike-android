package com.bluesandwich.joaquin.strike.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.bluesandwich.joaquin.strike.R;
import com.bluesandwich.joaquin.strike.data.model.SKAudioRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.crypto.KeyAgreement;

/**
 * Created by joaquin on 3/6/16.
 */
public class HomeArrayAdapter extends ArrayAdapter<SKAudioRequest> {

    private String currentUserId;

    private List<SKAudioRequest> audioRequests = new ArrayList<SKAudioRequest>();

    public HomeArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public SKAudioRequest getItem(int index) { return audioRequests.get(index); }

    public void add(SKAudioRequest item){
        audioRequests.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<SKAudioRequest> items){
        Collections.reverse(items);
        audioRequests.addAll(items);
        notifyDataSetChanged();
    }

    public void setCurrentUserId(String userId){ currentUserId = userId; }

    public int getCount(){ return audioRequests.size(); }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SKAudioRequest currentAudioRequest = getItem(position);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.fragment_home_audio_req_listitem, parent, false);
        }

        return convertView;

    }


}
