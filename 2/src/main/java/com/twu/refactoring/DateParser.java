package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    private final String STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE = "%s string is less than %d characters";
    private final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "%s is not an integer";
    private final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "%s cannot be less than %d or more than %d";

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        year = getTime(new Time(0, 4, "Year", 4, 2000, 2012));

        month = getTime(new Time(5, 7, "Month", 2, 1, 12));

        date = getTime(new Time(8, 10, "Date", 2, 1, 31));

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = getTime(new Time(11, 13, "Hour", 2, 0, 23));

            minute = getTime(new Time(14, 16, "Minute", 2, 0, 59));
        }


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getTime(Time time) {
        int timeValue;
        try {
            String timeString = dateAndTimeString.substring(time.getStartIndex(), time.getEndIndex());
            timeValue = Integer.parseInt(timeString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format(STRING_INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE, time.getName(), time.getCharacterCount()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NUMBER_FORMAT_EXCEPTION_MESSAGE, time.getName()));
        }
        if (timeValue < time.getMin() || timeValue > time.getMax())
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE, time.getName(), time.getMin(), time.getMax()));
        return timeValue;
    }
}
