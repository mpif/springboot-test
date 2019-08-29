package hello.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: mpif
 * @date: 2019-08-29 10:01
 */
public class DateUtils {

    private static final String PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    private static final String PATTERN_YYYYMMDDHHMMSS_SSS = "yyyy-MM-dd HH:mm:ss,SSS";
    private static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";

    private static final ThreadLocal<DateFormat> yyyyMMddHHmmssDateFormat= new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(PATTERN_YYYYMMDDHHMMSS);
        }
    };

    public static Date parseYYYYMMDDHHMMSS(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDDHHMMSS);
        return sdf.parse(dateStr);
    }

    public static String formatYYYYMMDDHHMMSS(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDDHHMMSS);
        return sdf.format(date);
    }

}
