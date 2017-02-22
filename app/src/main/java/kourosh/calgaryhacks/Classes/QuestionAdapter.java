package kourosh.calgaryhacks.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import kourosh.calgaryhacks.R;

/**
 * Created by Jackie Luc on 2017-02-22.
 */

public class QuestionAdapter extends BaseAdapter {

    private ArrayList<Question> questionList;
    Context context;

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

        ImageButton ib = (ImageButton) rowView.findViewById(R.id.upvoteButton);
        final TextView scoreView = (TextView) rowView.findViewById(R.id.question_score);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int score = questionList.get(i).score;

                scoreView.setText(String.valueOf(++score));

                // store score in db / question
                 questionList.get(i).upVote();
            }
        });

        return rowView;
    }
}
