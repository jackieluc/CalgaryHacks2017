package kourosh.calgaryhacks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kourosh on 2017-02-21.
 */

public class SessionAdapter extends BaseAdapter {

    private ArrayList<Session> sessionList;
    Context context;

    public SessionAdapter(Context context, ArrayList<Session> sessionList){
        this.sessionList = sessionList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sessionList.size();
    }

    @Override
    public Object getItem(int i) {
        return sessionList.get(i);
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
        View rowView = inflater.inflate(R.layout.session_row_layout,viewGroup,false);

        TextView courseName = (TextView) rowView.findViewById(R.id.courseName);
        courseName.setText(sessionList.get(i).day.toString());

        return rowView;
    }
}
