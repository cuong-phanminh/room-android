package com.example.roomandroid;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    String name;
    public User(String name){
        this.name = name;
    }
}
