package kourosh.calgaryhacks.StudentLiveUI;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kourosh.calgaryhacks.Classes.Question;
import kourosh.calgaryhacks.Classes.QuestionAdapter;
import kourosh.calgaryhacks.R;

public class StudentLiveActivity extends AppCompatActivity {

    // list of questions
    private ArrayList<Question> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_live);

        // note: this is dummy code to populate list view
        getQuestions();

        setFABListeners();
        setListViewAdapter();
    }

    private void setFABListeners() {
        // resources:
        // https://github.com/futuresimple/android-floating-action-button/blob/master/sample/src/main/res/layout/activity_main.xml

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);

        final FloatingActionButton askQuestion = (FloatingActionButton) findViewById(R.id.ask_question);
        askQuestion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                askQuestion.setTitle("Action A clicked");
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
        QuestionAdapter questionAdapter = new QuestionAdapter(this, questionList);
        ListView lv = (ListView) findViewById(R.id.student_live_ui_list);
        lv.setAdapter(questionAdapter);
    }

    private void getQuestions(){

        questionList.add(new Question("1","Swager","Macneil"));
        questionList.add(new Question("12","Swag3212er","Macneil"));
        questionList.add(new Question("123","Swage1212r","Macneil"));
        questionList.add(new Question("1234","Swage121r","Macneil"));
    }

}
