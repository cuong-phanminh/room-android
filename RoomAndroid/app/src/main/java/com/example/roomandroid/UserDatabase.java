package com.example.roomandroid;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 4)
public abstract class UserDatabase extends RoomDatabase {
    abstract UserDao userDao();

}
