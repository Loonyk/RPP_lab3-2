package com.example.rpp_32.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public abstract class StudentTransaction {
    @Query("SELECT * FROM Student WHERE id = (SELECT MAX(id) FROM Student)")
    public abstract List<Student> getLastPosition();

    @Update
    public abstract void update(Student student);

    @Transaction
    public void ChangeToIvan(){
        Student student = getLastPosition().get(0);
        student.setSurname("Иванов");
        student.setFirstName("Иван");
        student.setLastName("Иванович");
        update(student);
    }

}
