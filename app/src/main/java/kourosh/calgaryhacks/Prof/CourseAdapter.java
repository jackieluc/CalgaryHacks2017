package kourosh.calgaryhacks.Prof;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kourosh.calgaryhacks.R;

/**
 * Created by kourosh on 2017-02-21.
 */

public class CourseAdapter extends BaseAdapter {

    private ArrayList<Course> courseList;
    Context context;

    public CourseAdapter (Context context,ArrayList<Course> courseList){
        this.courseList = courseList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void update(){
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.course_row_layout,viewGroup,false);

        TextView courseName = (TextView) rowView.findViewById(R.id.courseName);
        courseName.setText(courseList.get(i).name);

        return rowView;
    }
}
