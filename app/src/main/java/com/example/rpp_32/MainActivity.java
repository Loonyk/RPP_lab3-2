package com.example.rpp_32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rpp_32.AsyncTask.AsyncStudent;
import com.example.rpp_32.db.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Button newActOpen;
    public Button addRecord;
    public Button addToIvan;
    private int choiceBtn = 0;
    private AsyncStudent asyncStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncStudent = new AsyncStudent();
        asyncStudent.execute(this);

        newActOpen = (Button)findViewById(R.id.new_act_bt);
        addRecord = (Button)findViewById(R.id.add_record);
        addToIvan = (Button)findViewById(R.id.addToIvan);

        newActOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChoiceBtn(1);
                asyncStudent = new AsyncStudent();
                asyncStudent.execute(MainActivity.this);
            }
        });

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChoiceBtn(2);
                asyncStudent = new AsyncStudent();
                asyncStudent.execute(MainActivity.this);
            }
        });

        addToIvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChoiceBtn(3);
                asyncStudent = new AsyncStudent();
                asyncStudent.execute(MainActivity.this);
            }
        });
    }

    public void openScndAct(List<Student> list){
        Intent intent = new Intent(MainActivity.this, ListStudentActivity.class);
        intent.putExtra("list",(ArrayList) list);
        startActivity(intent);
    }

    public int getChoiceBtn() {
        return choiceBtn;
    }

    public void setChoiceBtn(int choiceBtn) {
        this.choiceBtn = choiceBtn;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
