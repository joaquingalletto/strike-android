package com.bluesandwich.joaquin.strike.data.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joaquin on 3/6/16.
 */
public class SKAudioRequest implements JSONInterface {

    public enum SKAudioRequestGenre {
        SKAudioRequestGenreRock(1),
        SKAudioRequestGenreJazz(2);
        private int value;

        public int getValue() {
            return this.value;
        }

        public static SKAudioRequestGenre fromInt(int i) {
            for (SKAudioRequestGenre g : SKAudioRequestGenre.values()) {
                if (g.getValue() == i){
                    return g;
                }

            }
            return null;
        }

        private SKAudioRequestGenre(int value){
            this.value = value;
        }

    }

    public String identifier;
    public String title;                // title needed??
    public String createdDate;
    public String createdBy;
    public String createdByName;
    public int status;
    public SKAudioRequestGenre genre;
    public String description;
    public ArrayList<String> tags;



    @Override
    public void fromJSON(JSONObject jObj, boolean lightNotation) throws JSONException {

    }

    @Override
    public JSONObject toJSON(boolean lightNotation) throws JSONException {
        return null;
    }
}
