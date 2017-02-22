package kourosh.calgaryhacks.Prof;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import kourosh.calgaryhacks.Course;
import kourosh.calgaryhacks.CourseAdapter;
import kourosh.calgaryhacks.R;

public class ProfMain extends AppCompatActivity {
    private ArrayList<Course> courseList;
    private String profEmail;
    private ListView lv;
    private CourseAdapter courseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getCourseList();
        profEmail = "sunnychan@gmail.com";
        courseAdapter = new CourseAdapter(this,courseList);
        lv = (ListView) findViewById(R.id.MainListview);

        lv.setAdapter(courseAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(),ProfCourse.class);
                intent.putExtra("ID",courseList.get(i).getID());
                intent.putExtra("Name",courseList.get(i).getName());
                startActivity(intent);
            }
        });


    }

    private void getCourseList(){

        //Access database for courses based on prof's email

        courseList= new ArrayList<Course>();
        courseList.add(new Course(232,"CPSC 471","SunnyChan"));
        courseList.add(new Course(233,"CPSC 123","Sunny Chan"));
        courseList.add(new Course(234,"CPSC 101","Sunny Chan"));
        courseList.add(new Course(235,"CPSC 481","Sunny Chan"));


    }



    public void openCourseAdding(View view){
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.add_course, null);

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



                        EditText ed1 = (EditText) promptsView.findViewById(R.id.professor);
                        ed1.setText(profEmail);
                        EditText ed2 = (EditText) promptsView.findViewById(R.id.courseName);
                        courseList.add(new Course(236, ed2.getText().toString(),ed1.getText().toString()));
                        courseAdapter.notifyDataSetChanged();
                        onResume();
                    }
                });


        AlertDialog aD = aDB.create();
        aD.show();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        //Update the database
//        courseList.add(new Course(123,"2ewrwfa","Afadssaf"));
//        courseAdapter.update();
//        lv.setAdapter(courseAdapter);
//
//    }
}
