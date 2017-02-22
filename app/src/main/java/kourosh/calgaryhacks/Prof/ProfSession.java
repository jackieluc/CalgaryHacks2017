package kourosh.calgaryhacks.Prof;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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



        SessionDetailedAdapter adapter = new SessionDetailedAdapter(this,getDataSet(),3.5f,getQuestions());
        lv = (ListView) findViewById(R.id.detailedSessionListview);
        lv.setAdapter(adapter);

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

}
