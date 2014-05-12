package com.esinav.utility;

/**
 * Created by myavuz on 26.04.2014.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtility {

    public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

    public static String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();
        return dateFormat.format(date);
    }


}