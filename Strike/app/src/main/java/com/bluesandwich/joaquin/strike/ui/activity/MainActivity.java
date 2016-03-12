package com.bluesandwich.joaquin.strike.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.bluesandwich.joaquin.strike.R;
import com.bluesandwich.joaquin.strike.core.SKAplication;
import com.bluesandwich.joaquin.strike.data.model.SKUser;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "STRIKE_" + MainActivity.class.getSimpleName();

    SKUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean firstTime = prefs.getBoolean("firstTime", false);                       // THIS SHOULD BE SET TO TRUE BY DEFAULT
        currentUser = ((SKAplication) getApplication()).getCurrentUser();
        if(firstTime){
            showProductTour();
        }else{
            loadHome();
        }

    }

    @Override
    public void onResume() { super.onResume(); }

    private void showProductTour(){
        Intent targetActivity = new Intent(getApplicationContext(), Walkthrough.class);

        //TODO: IMPLEMENT THE PRODUCT TOUR WALKTHROUGH ACTIVITY, NOW IS EMPTY

        targetActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(targetActivity);
    }

    private void loadHome(){
        // setting content view
        Intent targetActivity = new Intent(getApplicationContext(), HomeActivity.class);

        //TODO: IMPLEMENT THE PRODUCT TOUR WALKTHROUGH ACTIVITY, NOW IS EMPTY

        targetActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(targetActivity);

        //configuring the sliding menu
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
