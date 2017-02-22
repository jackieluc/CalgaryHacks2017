package kourosh.calgaryhacks.Prof;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import kourosh.calgaryhacks.Classes.Question;
import kourosh.calgaryhacks.R;

/**
 * Created by kourosh on 2017-02-22.
 */

public class SessionDetailedAdapter extends BaseAdapter{
    private ArrayList<Question> questionList;
    private Context context;
    private ArrayList <PieEntry> entries;
    private float rating;
    private PieChart pieChart;
    private ArrayList<Integer> colors;
    private PieDataSet pieDataSet;
    private RatingBar ratingBar;
    private PieData pieData;

    public SessionDetailedAdapter (Context context, ArrayList <PieEntry> entries, float rating,ArrayList<Question> questionList){
        this.questionList = questionList;
        this.context = context;
        this.entries = entries;
        this.rating = rating;
    }


    @Override
    public int getCount() {
        return questionList.size()+2;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        int viewtype = getItemViewType(i);

        View rowView = null;
        if (viewtype == 0){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.session_row_piechart,viewGroup,false);

            pieChart = (PieChart) rowView.findViewById(R.id.pieChart);
            initalizegraph();

        }

        else if (viewtype == 1){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.session_row_rating,viewGroup,false);
            ratingBar = (RatingBar) rowView.findViewById(R.id.rating);
            ratingBar.setRating(rating);
        }

        else if (viewtype == 2){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.session_row_question,viewGroup,false);
            i = i -2;

            TextView questionBody = (TextView) rowView.findViewById(R.id.question_body);
            questionBody.setText(questionList.get(i).body);

            TextView scoreView = (TextView) rowView.findViewById(R.id.question_score);
            scoreView.setText("0");

        }
        return rowView;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }
        else if (position == 1){
            return 1;
        }else{
            return 2;
        }
    }

    private void initalizegraph(){
        pieChart.setDescription(null);
        pieChart.setRotationEnabled(false);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setHoleRadius(0);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.getLegend().setEnabled(false);
        pieChart.setHighlightPerTapEnabled(false);

        pieDataSet = new PieDataSet(entries,"Composition");

        pieDataSet.setSliceSpace(0);
        pieDataSet.setValueTextSize(12);

        colors = new ArrayList<>();
        colors.add(Color.MAGENTA);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        pieDataSet.setColors(colors);

        pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.invalidate();


    }

    public void update(ArrayList <PieEntry> entries, float rating,ArrayList<Question> questionList){
        //Update graph data
        this.entries = entries;
        this.rating = rating;
        this.questionList = questionList;

        notifyDataSetChanged();
    }
}
