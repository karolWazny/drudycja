package com.drudycja.drudycjaEngine;

import android.app.Application;
import android.content.res.Resources;

public class App extends Application {

    private static Resources resources;

    public static Resources getRes() {
        return resources;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        resources = getResources();
    }
}
