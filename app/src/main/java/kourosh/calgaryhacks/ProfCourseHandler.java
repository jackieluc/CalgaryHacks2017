package kourosh.calgaryhacks;

import android.util.Log;
import android.widget.Toast;

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

        courseList = new ArrayList<Course>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

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

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });


        Log.d("pch" , "outside " + courseList.size());
        return courseList;
    }

    private void setArrayList(ArrayList<Course> arrayList)
    {
        if(arrayList.size() != 0)
        {
            courseList = new ArrayList(arrayList);
        }
    }
    public void addCourse(String courseID, String instructorName, String courseName)
    {

        Course course = new Course(instructorName, courseName);
        mDatabase.child(courseID).setValue(course);
    }
}
