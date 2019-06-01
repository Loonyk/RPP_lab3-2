package com.example.rpp_32;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.rpp_32.db.Student;

import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {

    ListView listView;
    Adapter adapter;
    ArrayList<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        list = (ArrayList<Student>)getIntent().getExtras().getSerializable("list");
        listView = (ListView)findViewById(R.id.listStud);
        adapter = new Adapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
