package kourosh.calgaryhacks.Student;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kourosh.calgaryhacks.Course;
import kourosh.calgaryhacks.CourseAdapter;
import kourosh.calgaryhacks.Prof.ProfCourse;
import kourosh.calgaryhacks.R;

public class StudentMain extends AppCompatActivity {
    private ArrayList<Course> courseList;
    private String profEmail;
    private ListView lv;
    private CourseAdapter courseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getCourseList();

        courseAdapter = new CourseAdapter(this,courseList);
        lv = (ListView) findViewById(R.id.MainListview);
        lv.setAdapter(courseAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(),StudentCourse.class);
                intent.putExtra("ID",courseList.get(i).getID());
                intent.putExtra("Name",courseList.get(i).getName());
                startActivity(intent);
            }
        });

    }

    private void getCourseList(){

        //Access database for courses based on student's email

        courseList= new ArrayList<Course>();
        courseList.add(new Course(232,"Swager","Macneil"));
        courseList.add(new Course(22332,"Swag3212er","Macneil"));
        courseList.add(new Course(23432,"Swage1212r","Macneil"));
        courseList.add(new Course(232322,"Swage121r","Macneil"));


    }



    public void openCourseEnrolling(View view){
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.enrol_course, null);

        AlertDialog.Builder aDB = new AlertDialog.Builder(this);
        aDB.setView(promptsView);


        aDB
                .setCancelable(false)
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })

                .setNegativeButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Add course
                        findViewById(R.id.professor);
                        findViewById(R.id.courseName);
                        onResume();
                    }
                });


        AlertDialog aD = aDB.create();
        aD.show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Update the database
        courseList.add(new Course(123,"2ewrwfa","Afadssaf"));
        courseAdapter.update();
        lv.setAdapter(courseAdapter);

    }
}
