package com.example.rpp_32.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertALL(Student... students);

    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();
}
