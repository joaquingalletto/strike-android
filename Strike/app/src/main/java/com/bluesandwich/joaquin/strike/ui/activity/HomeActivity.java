package com.bluesandwich.joaquin.strike.ui.activity;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.bluesandwich.joaquin.strike.R;
import com.bluesandwich.joaquin.strike.core.SKAplication;
import com.bluesandwich.joaquin.strike.data.model.SKAudioRequest;
import com.bluesandwich.joaquin.strike.data.model.SKUser;
import com.bluesandwich.joaquin.strike.ui.fragment.HomeFragment;
import com.bluesandwich.joaquin.strike.ui.fragment.MenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.List;

public class HomeActivity extends AppCompatActivity  implements HomeFragment.HomeFragmentCallback{

    private static final String TAG = "STRIKE_" + HomeActivity.class.getSimpleName();

    SlidingMenu menu;

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
        setContentView(R.layout.activity_home);

        Fragment menu = new MenuFragment();
        Bundle extras = new Bundle();
        extras.putInt("activityNum", 1);
        menu.setArguments(extras);

        //configuring the sliding menu
        cofigureSlidingMenu(SlidingMenu.LEFT, R.layout.menu_frame2, R.layout.menu_frame2, menu);
    }

    @Override
    public void onBackPressed(){
        if(menu.isMenuShowing()){
            menu.showContent();
        } else{
            super.onBackPressed();
            menu.showContent();
        }
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

    public void cofigureSlidingMenu(int mode, int res, int resId, Fragment fragment){
        menu = new SlidingMenu(this);
        menu.setMode(mode);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.50f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW, true);
        menu.setMenu(res);
        getFragmentManager().beginTransaction().replace(resId, fragment).commit();

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

    @Override
    public SKUser getCurrentUser() {
        return ((SKAplication)getApplication()).getCurrentUser();
    }

    @Override
    public void newAudioRequest() {

    }

    @Override
    public List<SKAudioRequest> getNewestAudioRequests(int top, long offsetDate) {
        return null;
    }
}
