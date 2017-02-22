package kourosh.calgaryhacks.Prof;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kourosh.calgaryhacks.R;

public class ProfMain extends AppCompatActivity {
    private ArrayList<Course> courseList;
    private String profEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        getCourseList();

        CourseAdapter courseAdapter = new CourseAdapter(this,courseList);
        ListView lv = (ListView) findViewById(R.id.profMainListview);
        lv.setAdapter(courseAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(view.getContext(),ProfCourse.class);
//                intent.putExtra("ID",courseList.get(i).id);
//                startActivity(intent);
            }
        });

    }

    private void getCourseList(){

        //Access database for courses based on prof's email

        courseList= new ArrayList<Course>();
        courseList.add(new Course(232,"Swager","Macneil"));
        courseList.add(new Course(22332,"Swag3212er","Macneil"));
        courseList.add(new Course(23432,"Swage1212r","Macneil"));
        courseList.add(new Course(232322,"Swage121r","Macneil"));


    }



    public void addCourse(View view){
        startActivity(new Intent(this,addCourse.class));

    }


}
