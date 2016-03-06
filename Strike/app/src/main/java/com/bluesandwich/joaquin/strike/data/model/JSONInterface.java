package com.bluesandwich.joaquin.strike.data.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joaquin on 3/5/16.
 */
public interface JSONInterface {

    void fromJSON(JSONObject jObj, boolean lightNotation) throws JSONException;
    JSONObject toJSON(boolean lightNotation) throws JSONException;
}
