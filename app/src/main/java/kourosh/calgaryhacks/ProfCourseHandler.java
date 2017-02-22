package kourosh.calgaryhacks;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Nasir on 2017-02-21.
 */

public class ProfCourseHandler {

    private DatabaseReference mDatabase;
    private ValueEventListener mPostListener;
    FirebaseDatabase database;
    private ArrayList<Course> courseList;


    public ProfCourseHandler()
    {
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Courses");

        courseList = new ArrayList<>();

    }
    public ArrayList<Course> getCourses(String instructorName)
    {

       mDatabase = database.getReference("Courses");
        Query courseQuery = mDatabase.orderByChild("ProfName").equalTo(instructorName);
        courseQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){

                    Course course = singleSnapshot.getValue(Course.class);

                    courseList.add(course);
                    Log.d("Courselist", "" + course.getCourseName());


                }

                // may need to send arrayList to view adapter for courses here!!

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        courseQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Log.d("CourseArrayList", "Hello");

        try{
            Thread.sleep(1000);
        } catch(java.lang.InterruptedException e)
        {


        }
        return courseList;
    }

    public void addCourse(String courseID, String instructorName, String courseName)
    {

        Course course = new Course(instructorName, courseName);
        mDatabase.child(courseID).setValue(course);
    }
}
