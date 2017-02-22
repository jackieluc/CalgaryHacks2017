package kourosh.calgaryhacks.studentliveui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import android.view.View.OnClickListener;

import kourosh.calgaryhacks.R;

public class StudentLiveActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_live);

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

}
