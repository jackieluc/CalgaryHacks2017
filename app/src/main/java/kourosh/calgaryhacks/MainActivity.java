package kourosh.calgaryhacks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayList<Course> randomCourses = new ArrayList<Course>();

        //ProfCourseHandler pch = new ProfCourseHandler();
        SessionHandler sh = new SessionHandler();
        ArrayList<Session> myCourses = sh.getSessions("MATH 200", "blah");

       // ArrayList<Course> myCourses = pch.getCourses("Dr. Jones");

//        while(myCourses.size() == 0)
//        {
//          //  Log.d("null", "nulsdfsadkljfksdjflasdfklsdajfklsdjkl");
//        }

        Log.d("Size", "" + myCourses.size());
        arrayAdapter = new ArrayAdapter(myCourses, this);
        listView.setAdapter(arrayAdapter);
       // Log.d("Size 2", "" + myCourses.size());

       // Toast.makeText(MainActivity.this, "" + myCourses.size(), Toast.LENGTH_LONG);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
