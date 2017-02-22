package kourosh.calgaryhacks.Classes;


public class Question {

    public String id;
    public String sender;
    public String body;
    public int score;
    public Boolean isClicked;

    public Question() {
        this.id = Double.toString(Math.random());
        this.sender = "anonymous";
        this.body = "This is a random question";
        this.score = 0;
        this.isClicked = false;
    }

    public Question(String id, String sender, String body, Boolean isClicked) {
        this.id = id;
        this.sender = sender;
        this.body = body;
        this.score = 0;
        this.isClicked = isClicked;
    }

    public Question(String body){
        this.body = body;
        this.id = Double.toString(Math.random());
        this.sender = "anonymous";
        this.score = 0;
        this.isClicked = false;
    }

    public void upVote() {
        score++;
    }

    public void askQuestion(String question) {
        this.body = question;
    }

    public void changeSender(String sender) {
        this.sender = sender;
    }
}
