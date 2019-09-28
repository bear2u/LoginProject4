package com.example.login.common;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.Stetho;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRoom();
        initSteho();
    }

    private void initSteho() {
        //chrome://inspect/#devices
        Log.d("MyApp", BuildConfig.BUILD_TYPE + "");
//        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
//        }
    }

    private void initRoom() {
        AppDatabaseProvider.getINSTANCE(getApplicationContext());
    }



}
