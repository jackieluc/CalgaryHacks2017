package kourosh.calgaryhacks.Classes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import kourosh.calgaryhacks.R;
import kourosh.calgaryhacks.StudentLiveUI.StudentLiveActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by Jackie Luc on 2017-02-22.
 */

public class QuestionAdapter extends BaseAdapter {

    private ArrayList<Question> questionList;
    private Context context;
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private ArrayList<Boolean> isClicked = new ArrayList<Boolean>();

    public QuestionAdapter (Context context, ArrayList<Question> questionList){
        this.questionList = questionList;
        this.context = context;

        for(int i = 0; i < questionList.size(); i++)
            isClicked.add(false);
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public Object getItem(int i) {
        return questionList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.question_row_layout,viewGroup,false);

        TextView questionBody = (TextView) rowView.findViewById(R.id.question_body);
        questionBody.setText(questionList.get(i).body);

        ImageView iv = (ImageView) rowView.findViewById(R.id.upvoteButton);
        final TextView scoreView = (TextView) rowView.findViewById(R.id.question_score);

        final DatabaseReference dbScore = database.child("Questions").child((questionList.get(i).id)).child("score");

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int score = questionList.get(i).score;

                if (!isClicked.get(i)) {
                    isClicked.set(i, true);
                    scoreView.setText(String.valueOf(++score));
                }
                else if (isClicked.get(i)){
                    isClicked.set(i, false);
                    scoreView.setText(String.valueOf(--score));
                }

                questionList.get(i).score = score;
                dbScore.setValue(score);
            }
        });

        // Read from the database
        dbScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Long value = dataSnapshot.getValue(Long.class);
                Toast.makeText(context, "Value is: " + value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(context, "Failed to read value.", Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }
}
