package com.example.login.common;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRoom();
    }

    private void initRoom() {
        AppDatabaseProvider.getINSTANCE(getApplicationContext());
    }

}
