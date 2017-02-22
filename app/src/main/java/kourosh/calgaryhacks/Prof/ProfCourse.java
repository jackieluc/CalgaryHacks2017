package kourosh.calgaryhacks.Prof;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

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
        String name = getIntent().getStringExtra("Name");
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);

        String id = getIntent().getStringExtra("ID");
        getSessionList(id);

        sessionAdapter = new SessionAdapter(this,sessionList);
        lv = (ListView) findViewById(R.id.profCourseListview);
        lv.setAdapter(sessionAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(),ProfSession.class);
//                intent.putExtra("Day",sessionList.get(i).day);
                startActivity(intent);
            }
        });
    }


    private void getSessionList(String id){

        //Access database for courses based on prof's email

        sessionList= new ArrayList<Session>();
        sessionList.add(new Session(60));


    }



    public void addSession(View view){
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.add_session, null);

        AlertDialog.Builder aDB = new AlertDialog.Builder(this);
        aDB.setView(promptsView);
        EditText ed = (EditText) promptsView.findViewById(R.id.date);
        ed.setText((new Date()).toString());



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


                        promptsView.findViewById(R.id.duration);
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

        sessionAdapter.update();
        lv.setAdapter(sessionAdapter);

    }
}
