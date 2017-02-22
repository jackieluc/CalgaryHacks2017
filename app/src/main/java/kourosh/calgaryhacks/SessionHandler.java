package kourosh.calgaryhacks;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Nasir on 2017-02-22.
 */

public class SessionHandler {

    private DatabaseReference mDatabase;
    FirebaseDatabase database;
    private ArrayList<Session> sessionList;


    public SessionHandler()
    {
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Sessions");
        sessionList = new ArrayList<Session>();
    }

    public void addSession(Session session)
    {
        mDatabase.child(session.Date).setValue(session);
    }

    public ArrayList<Session> getSessions(String courseName, String ProfID)
    {


        Query courseQuery = mDatabase.orderByChild("CourseName").equalTo(courseName);
        courseQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {

                    Session session= singleSnapshot.getValue(Session.class);

                    sessionList.add(session);
                    Log.d("session", "" + singleSnapshot);


                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        try{
            Thread.sleep(1000);
        } catch(java.lang.InterruptedException e)
        {


        }

        return sessionList;

    }





}
