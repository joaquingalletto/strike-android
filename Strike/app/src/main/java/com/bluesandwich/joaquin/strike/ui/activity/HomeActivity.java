package com.bluesandwich.joaquin.strike.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.bluesandwich.joaquin.strike.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by joaquin on 3/11/16.
 */
public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.attach);
        // set the content view
        setContentView(R.layout.activity_home);
        // configure the SlidingMenu
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.fragment_menu);
    }
}
