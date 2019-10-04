package com.example.login.login.model.datasources.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {
    @Query("select * from user where id = :id and pwd = :pwd")
    Single<List<UserEntity>> login(String id, String pwd);

    @Insert
    void addUser(UserEntity user);
}
