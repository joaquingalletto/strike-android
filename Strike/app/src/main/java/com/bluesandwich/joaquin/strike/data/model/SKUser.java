package com.bluesandwich.joaquin.strike.data.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.PublicKey;

/**
 * Created by joaquin on 3/5/16.
 */
public class SKUser implements JSONInterface {

    public static final String USER_DATA_PREFERENCES_FILE_KEY = "STRIKE_USER_PROFILE";


    public String identifier;
    public String name;
    public String nickname;


    public SKUser(){
        this.identifier = java.util.UUID.randomUUID().toString();
    }

    @Override
    public void fromJSON(JSONObject jObj, boolean lightNotation) throws JSONException {
        if(lightNotation){
            this.identifier = jObj.getString("id");
            this.name = jObj.getString("na");
            if(jObj.has("ni")){
                this.nickname = jObj.getString("ni");
            }else{
                this.nickname = this.name.toLowerCase().replace(" ", "");
            }
        }else {
            this.identifier = jObj.getString("id");
            this.name = jObj.getString("name");
            if (jObj.has("nickname")) {
                this.nickname = jObj.getString("nickname");
            } else {
                this.nickname = this.name.toLowerCase().replace(" ", "");
            }
        }
    }

    @Override
    public JSONObject toJSON(boolean lightNotation) throws JSONException {
        JSONObject jObj = new JSONObject();
        if(lightNotation){
            jObj.put("id", this.identifier);
            jObj.put("na", this.name);
            jObj.put("ni", this.nickname);
        }else{
            jObj.put("id", this.identifier);
            jObj.put("name", this.name);
            jObj.put("nickname", this.nickname);
        }
        return jObj;
    }
}
