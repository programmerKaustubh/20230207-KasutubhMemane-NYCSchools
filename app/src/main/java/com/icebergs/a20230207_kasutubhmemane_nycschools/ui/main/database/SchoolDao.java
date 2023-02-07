package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;


import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SchoolDTOEntity;

import java.util.List;


@Dao
public interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SchoolDTOEntity schoolInfo);

    @Transaction
    @Query("SELECT * FROM SCHOOL_DATABASE_TABLE ORDER BY dbn ASC")
    LiveData<List<SchoolDTOEntity>> getAllSchools();

    @Query("SELECT * FROM SCHOOL_DATABASE_TABLE WHERE dbn = :dbn")
    LiveData<SchoolDTOEntity> getSchoolByDbn(String dbn);

}