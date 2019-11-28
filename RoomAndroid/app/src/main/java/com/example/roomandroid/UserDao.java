package com.example.roomandroid;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * from user")
    List<User>getAll();

    @Insert
    void insert(User user);
}
