package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.constants.ApplicationConstants;
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SchoolDTOEntity;


@Database(entities = {SchoolDTOEntity.class}, version = 2, exportSchema = false)
public abstract class SchoolDatabase extends RoomDatabase {
    private static SchoolDatabase instance;

    public abstract SchoolDao schoolDao();

    public static synchronized SchoolDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            SchoolDatabase.class, ApplicationConstants.SCHOOL_DATABASE)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}