package com.example.login.common;

import android.content.Context;

import androidx.room.Room;

// AppDatabase return;
public class AppDatabaseProvider {

    private volatile static AppDatabase INSTANCE = null;

    private AppDatabaseProvider(){}

    public static AppDatabase getINSTANCE() throws Exception {
        if(INSTANCE == null) {
            throw new Exception("INSTANCE MUST BE NOT NULL");
        }
        return INSTANCE;
    }

    public static AppDatabase getINSTANCE(Context context) {

        if(INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context,
                        AppDatabase.class, "db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }

        return INSTANCE;
    }
}
