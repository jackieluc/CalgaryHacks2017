package kourosh.calgaryhacks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Nasir on 2017-02-22.
 */

public class ArrayAdapter extends BaseAdapter {

    private ArrayList<Session> courseList;
    private Context context;
    public ArrayAdapter(ArrayList<Session> courseList, Context context)
    {
        this.courseList = courseList;
        this.context = context;
    }
    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int position) {
        return courseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout, parent, false);
        ((TextView)  rowView.findViewById(R.id.courseName)).setText(courseList.get(position).Date);
        return rowView;
    }
}
