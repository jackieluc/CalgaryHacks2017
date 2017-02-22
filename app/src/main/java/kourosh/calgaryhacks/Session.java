package kourosh.calgaryhacks;

import java.util.ArrayList;

/**
 * Created by Nasir on 2017-02-22.
 */

public class Session {
    public String CourseName;
    public String Date;
    public String ProfID;

    public String Rating;
    //public ArrayList<Question> questionList;

    public Session(String Date, String ProfID, String CourseName, String Rating)
    {
        this.Date = Date;
        this.ProfID = ProfID;
        this.CourseName = CourseName;
        this.Rating = Rating;
        //this.questionList = questionList;

    }


    public Session()
    {

    }
    public void calculateRating()
    {

    }
}
