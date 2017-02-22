package kourosh.calgaryhacks.StudentLiveUI;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import kourosh.calgaryhacks.Classes.Question;
import kourosh.calgaryhacks.Classes.QuestionAdapter;
import kourosh.calgaryhacks.R;

public class StudentLiveActivity extends AppCompatActivity {

    // list of questions
    private ArrayList<Question> questionList = new ArrayList<>();
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference("Questions");
    private QuestionAdapter questionAdapter;
    private ArrayList<Boolean> isClicked = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_live);

        setFABListeners();
        setListViewAdapter();

        for(int i = 0; i < questionList.size(); i++)
            isClicked.add(false);
    }

    private void setFABListeners() {
        // resources:
        // https://github.com/futuresimple/android-floating-action-button/blob/master/sample/src/main/res/layout/activity_main.xml

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);

        final FloatingActionButton askQuestion = (FloatingActionButton) findViewById(R.id.ask_question);
        askQuestion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(view.getContext());
                View promptsView = li.inflate(R.layout.ask_question_box, null);

                AlertDialog.Builder aDB = new AlertDialog.Builder(view.getContext());
                aDB.setView(promptsView);

                final View pv = promptsView;
                final View ogV = view;

                aDB
                        .setCancelable(false)
                        .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })

                        .setNegativeButton("Ask", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Add course

                                EditText v = (EditText) pv.findViewById(R.id.ask_box_body);
                                String txt = v.getText().toString();
                                Question newQuestion = new Question(Integer.toString(new Random().nextInt(10000)), "anonymous", txt, false);
                                questionList.add(newQuestion);
                                isClicked.add(false);

                                database.child(newQuestion.id).setValue(newQuestion);
                                questionAdapter.notifyDataSetChanged();

//                                findViewById(R.id.ask_box_sender);
                                onResume();
                            }
                        });


                AlertDialog aD = aDB.create();
                aD.show();
            }
        });

        final FloatingActionButton submitInquiry = (FloatingActionButton) findViewById(R.id.submit_inquiry);
        submitInquiry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                submitInquiry.setTitle("Action B clicked");
            }
        });

        final FloatingActionButton actionEnable = (FloatingActionButton) findViewById(R.id.action_enable);
        actionEnable.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                menuMultipleActions.setEnabled(!menuMultipleActions.isEnabled());
            }
        });
    }

    public void setListViewAdapter() {
        questionAdapter = new QuestionAdapter(this, questionList);
        ListView lv = (ListView) findViewById(R.id.student_live_ui_list);
        lv.setAdapter(questionAdapter);
    }
}
