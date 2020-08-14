package com.drudycja.drudycjaEngine;

import android.app.Activity;
import android.os.Bundle;

import com.drudycja.R;

public class SplashScreen extends Activity {
    private final int SPLASH_SCREEN_DURATION = 2000;
    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.splash_screen);
    }
}
