package com.example.login.login.model.datasources.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("select * from user where id = :id and pwd = :pwd")
    UserEntity login(String id, String pwd);
    @Insert
    void addUser(UserEntity user);
}
