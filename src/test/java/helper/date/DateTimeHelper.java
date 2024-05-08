package helper.date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateTimeHelper {
    final static Logger log = LogManager.getLogger(DateTimeHelper.class);

    public static String getCurrentDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
        Calendar cal = Calendar.getInstance();
        return "" + dateFormat.format(cal.getTime());
    }

    public static String getCurrentDate() {
        return getCurrentDateTime().substring(0, 11);
    }

}
