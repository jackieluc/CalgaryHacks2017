package kourosh.calgaryhacks.Prof;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kourosh on 2017-02-21.
 */

public class Session {
    protected Timer timer = new Timer();
    protected TimerTask turnoff = new TimerTask(){
        public void run(){
            live = false;

            //turnoff live mode for database
        }
    };

    protected Boolean live;
    protected Date day;


    public Session(int length){
        day = new Date();
        live = true;
        timer.schedule(turnoff,length*60*1000);

        //send data to database

    }


}
