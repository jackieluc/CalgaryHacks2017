package kourosh.calgaryhacks.Prof;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kourosh.calgaryhacks.R;
import kourosh.calgaryhacks.Session;
import kourosh.calgaryhacks.SessionAdapter;

public class ProfCourse extends AppCompatActivity {

    private ArrayList<Session> sessionList;
    private int courseid;
    private ListView lv;
    private SessionAdapter sessionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSessionList();

        sessionAdapter = new SessionAdapter(this,sessionList);
        lv = (ListView) findViewById(R.id.profCourseListview);
        lv.setAdapter(sessionAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(view.getContext(),ProfCourse.class);
//                intent.putExtra("Day",sessionList.get(i).day);
//                startActivity(intent);
            }
        });
    }


    private void getSessionList(){

        //Access database for courses based on prof's email

        sessionList= new ArrayList<Session>();
        sessionList.add(new Session(60));


    }



    public void openCourseAdding(View view){

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Update the database

        sessionAdapter.update();
        lv.setAdapter(sessionAdapter);

    }
}
