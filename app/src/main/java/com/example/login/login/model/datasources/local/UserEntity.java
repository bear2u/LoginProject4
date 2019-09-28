package com.example.login.login.model.datasources.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey
    int no;
    String id;
    String pwd;
}
