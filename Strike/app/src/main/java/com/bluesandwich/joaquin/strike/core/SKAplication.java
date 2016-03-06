package com.bluesandwich.joaquin.strike.core;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.bluesandwich.joaquin.strike.data.model.SKUser;

import java.security.PublicKey;

/**
 * Created by joaquin on 3/5/16.
 */
public class SKAplication extends Application {

    private static final String TAG = "STRIKE_" + SKAplication.class.getSimpleName();

    private AudioManager audioManager;

    private SKUser currentUser;

    private Activity currentActivity;

    public SKAplication(){
        super();
        Log.v(TAG, "constructor");
    }

    public AudioManager getAudioManager() { return audioManager; }

    public SKUser getCurrentUser() { return currentUser; }

    @Override
    public  void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.v(TAG, "onCreate");

        try{
            audioManager = new AudioManager(getApplicationContext());

        }catch (Exception e){
            Log.e(TAG, "Exception on init. Message: " + e.getLocalizedMessage(), e);
        }
    }

    public Activity getCurrentActivity() { return  currentActivity; }

    public void setCurrentActivity(Activity mCurrentActivity) {
        this.currentActivity = mCurrentActivity;
    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
        Log.v(TAG, "onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.v(TAG, "onTerminate");
    }
}
