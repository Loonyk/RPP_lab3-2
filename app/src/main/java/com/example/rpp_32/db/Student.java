package com.example.rpp_32.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.sql.Date;

@Entity
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true) int id;
    String Surname;
    String FirstName;
    String LastName;
    Date time_add;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getTime_add() {
        return time_add;
    }

    public void setTime_add(Date time_add) {
        this.time_add = time_add;
    }
}
