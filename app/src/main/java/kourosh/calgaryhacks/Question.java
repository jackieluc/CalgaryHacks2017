package kourosh.calgaryhacks;

/**
 * Created by kourosh on 2017-02-22.
 */

public class Question {
    public String id;
    public String sender;
    public String body;
    public int score;

    public Question() {
        this.id = Double.toString(Math.random());
        this.sender = "anonymous";
        this.body = "This is a question";
        this.score = 0;
    }

    public Question(String id, String sender, String body) {
        this.id = id;
        this.sender = sender;
        this.body = body;
        this.score = 0;
        // send to database
    }



    public void askQuestion(String question) {
        this.body = question;
    }

    public void changeSender(String sender) {
        this.sender = sender;
    }
}
