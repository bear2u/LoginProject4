package com.example.login.common;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.login.login.model.datasources.local.UserDao;
import com.example.login.login.model.datasources.local.UserEntity;

@Database(entities = {UserEntity.class},
        version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
