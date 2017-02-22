package kourosh.calgaryhacks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kourosh on 2017-02-22.
 */

public class DateFormat {

    public static String getDateString(Date date){
        SimpleDateFormat dateFormat =new SimpleDateFormat("MMM dd, yyyy");
        return(dateFormat.format(date));
    }

    public static  Date getDate(String date){
        SimpleDateFormat dateFormat =new SimpleDateFormat("MM dd, yyyy");
        Date datedate = null;
        try {
            datedate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return(datedate);
    }
}
