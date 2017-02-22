package kourosh.calgaryhacks.Prof;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import kourosh.calgaryhacks.Question;
import kourosh.calgaryhacks.R;

public class ProfSession extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_session);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Summary");



        SessionDetailedAdapter adapter = new SessionDetailedAdapter(this,getDataSet(),3.5f,getQuestions());
        lv = (ListView) findViewById(R.id.detailedSessionListview);
        lv.setAdapter(adapter);

        notifyUser();

        adapter.update(getDataSet2(),4.99f,getQuestions());

    }


    private ArrayList<Question> getQuestions(){
        //get data from database

        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add( new Question());
        questions.add( new Question());
        questions.add( new Question());
        questions.add( new Question());
        return questions;

    }
    private ArrayList<PieEntry> getDataSet() {
        //get data from database
        ArrayList <PieEntry> entries = new ArrayList<>();


        entries.add(new PieEntry(25.3f,"I Hate you"));
        entries.add(new PieEntry(80.3f,"I love you"));

        return entries;
    }

    private ArrayList<PieEntry> getDataSet2() {
        //get data from database
        ArrayList <PieEntry> entries = new ArrayList<>();


        entries.add(new PieEntry(25.3f,"I Hate you"));
        entries.add(new PieEntry(80.3f,"I love you"));

        entries.add(new PieEntry(25.3f,"Too fast"));
        entries.add(new PieEntry(80.3f,"Too slow"));

        return entries;
    }



    private void notifyUser(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Attention");
        builder.setContentText("50% of students are having trouble with the lecture");
        builder.setTicker("THis is a ticker");
        builder.setAutoCancel(true);
        builder.setNumber(1);
        builder.setSmallIcon(R.drawable.exclamationmark);
        builder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(),R.drawable.exclamationmark));

        builder.setVibrate(new long[]{1000,1000,1000,1000,1000,1000});

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1234,notification);
    }
}
