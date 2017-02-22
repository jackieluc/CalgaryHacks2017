package kourosh.calgaryhacks.Prof;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kourosh.calgaryhacks.R;

public class CourseAdding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);


    }


    public void addCourse(View view){

        //Add the course to the database and return


        finish();
    }

}
