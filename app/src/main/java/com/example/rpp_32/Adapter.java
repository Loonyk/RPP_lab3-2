package com.example.rpp_32;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rpp_32.db.Student;

import java.util.List;

public class Adapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<Student> list;
    TextView studentTV;

    public Adapter(Context context, List<Student> listSt){
        this.context = context;
        this.list = listSt;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list, parent,false);

        studentTV = (TextView)view.findViewById(R.id.stud_item);
        studentTV.setText(list.get(position).getSurname()
                + " | " + list.get(position).getFirstName()
                + " | " + list.get(position).getLastName()
                + " | " + list.get(position).getTime_add().toString());

        return view;
    }

}
