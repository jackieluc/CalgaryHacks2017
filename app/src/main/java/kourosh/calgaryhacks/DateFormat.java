package kourosh.calgaryhacks;

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
}
