package com.bauet.learningproject.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bauet.learningproject.models.User;

@Database(entities = {User.class}, version = 1)
public abstract class MyRoomDB extends RoomDatabase {

    public abstract UserDao userDao();

}
