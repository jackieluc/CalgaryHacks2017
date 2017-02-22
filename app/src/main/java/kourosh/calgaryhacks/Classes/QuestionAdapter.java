package kourosh.calgaryhacks.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import kourosh.calgaryhacks.R;

/**
 * Created by Jackie Luc on 2017-02-22.
 */

public class QuestionAdapter extends BaseAdapter {

    private ArrayList<Question> questionList;
    private Context context;
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public QuestionAdapter (Context context, ArrayList<Question> questionList){
        this.questionList = questionList;
        this.context = context;
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

        final ImageView iv = (ImageView) rowView.findViewById(R.id.upvoteButton);
        final TextView scoreView = (TextView) rowView.findViewById(R.id.question_score);
        scoreView.setText(String.valueOf(questionList.get(i).score));

        final DatabaseReference dbScore = database.child("Questions").child((questionList.get(i).id)).child("score");

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Question question = questionList.get(i);

                int score = question.score;

                if (!question.isClicked) {
                    question.isClicked = true;
                    scoreView.setText(String.valueOf(++score));
                }
                else if (question.isClicked){
                    question.isClicked = false;
                    scoreView.setText(String.valueOf(--score));
                }

                questionList.get(i).score = score;
                dbScore.setValue(score);
                Collections.sort(questionList, new Comparator<Question>() {
                    @Override
                    public int compare(Question a, Question b) {
                        return b.score - a.score;
                    }
                });
                notifyDataSetChanged();
            }
        });

        return rowView;
    }
}
