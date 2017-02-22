package kourosh.calgaryhacks.Student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kourosh.calgaryhacks.Session;
import kourosh.calgaryhacks.SessionAdapter;
import kourosh.calgaryhacks.R;

public class StudentCourse extends AppCompatActivity {

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

        //Access database for courses based on  course name

        sessionList= new ArrayList<Session>();
        sessionList.add(new Session(60));


    }



    @Override
    protected void onResume() {
        super.onResume();

        //Update the database for new sessions

        sessionAdapter.update();
        lv.setAdapter(sessionAdapter);

    }
}
