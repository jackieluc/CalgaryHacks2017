package kourosh.calgaryhacks;

/**
 * Created by Nasir on 2017-02-22.
 */

public class Question {
    String id;
    String question;
    float score;

    public Question(String id, String question, float score)
    {
        this.id = id;
        this.question = question;
        this.score = score;
    }

    public String getID()
    {
        return id;
    }

    public String getQuestion()
    {
        return question;
    }

    public float getScore()
    {
        return score;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public void setID(String id)
    {
        this.id = id;
    }

    public void setScore(float score)
    {
        this.score = score;
    }
}
