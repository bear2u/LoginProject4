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
        Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db").build();
    }
}
