package com.example.rpp_32.AsyncTask;

import android.os.AsyncTask;

import com.example.rpp_32.MainActivity;
import com.example.rpp_32.db.AppDatabase;
import com.example.rpp_32.db.Student;

import java.sql.Date;
import java.util.List;

public class AsyncStudent extends AsyncTask<MainActivity, Void, Void> {

    private final static String[] studName = {
            "Тюрина Валерия Сергеевна",
            "Синицкий Валерий Юрьевич",
            "Карташова Валерия Валерьевна",
            "Сорочан Ирина Олеговна",
            "Абрамов Олег Александрович"
    };

    @Override
    protected Void doInBackground(MainActivity... mainActivities) {
        MainActivity mainAct = mainActivities[0];
        AppDatabase database = AppDatabase.getDatabace(mainAct);


        switch (mainAct.getChoiceBtn())
        {

            case 1:
                List<Student> list=database.getStudentDao().getAllStudents();
                mainAct.openScndAct(list);
                break;

            case 2:
                Student student=new Student();
                String[] str=(getStudName()[(int)(Math.random()*5)]).split(" ");
                student.setSurname(str[0]);
                student.setFirstName(str[1]);
                student.setLastName(str[2]);
                student.setTime_add(new java.sql.Date(System.currentTimeMillis()));
                database.getStudentDao().insertALL(student);
                break;

            case 3:
                database.getStudTransaction().ChangeToIvan();
                break;
        }
        return null;
    }

    public static String[] getStudName() {
        return studName;
    }
}
