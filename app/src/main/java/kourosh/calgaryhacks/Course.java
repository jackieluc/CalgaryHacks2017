package kourosh.calgaryhacks;

import java.util.ArrayList;

/**
 * Created by kourosh on 2017-02-21.
 */

public class Course {

    protected String name;
    protected String profname;



    public Course(int id, String name,String profname ){
        this.name = name;
        this.profname = profname;
        //send data to server
    }


    public String getName(){
        return name;
    }

    public String getID(){
        return profname+name;
    }


    public ArrayList<Session> getSessions(){
        //Run query to get all the session info
        //Search all of entries for the class in the database
        return new ArrayList<Session>();

    }
}
