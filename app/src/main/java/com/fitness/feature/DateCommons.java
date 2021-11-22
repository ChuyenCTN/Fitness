package com.fitness.feature;

import static java.util.Calendar.getInstance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.fitness.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/*
 * create by Chuyennt
 * */

public class DateCommons {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static String getCurrentYear(SimpleDateFormat dateFormat, String dateTime) {
        try {
            Date date = dateFormat.parse(dateTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return String.valueOf(calendar.get(Calendar.YEAR));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateTime;
    }

    public static String getYesterday(SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return dateFormat.format(calendar.getTime());
    }

    public static String get7DayAgo(SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        return dateFormat.format(calendar.getTime());
    }

    public static String[] getFirstAndLastDayThisWeek(SimpleDateFormat dateFormat) {
        String[] day = new String[2];
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
            calendar.add(Calendar.DAY_OF_WEEK, 1); // Vietnam is Monday.
            String firstDay = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_WEEK, 5);
            String last = dateFormat.format(calendar.getTime());
            day[0] = firstDay;
            day[1] = last;
        } catch (Exception ex) {

        }
        return day;
    }

    public static String getFirstDayofMonthAgo(SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        int max = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, max);
        return dateFormat.format(calendar.getTime());
    }

    public static String getLastDayofMonthAgo(SimpleDateFormat sdf) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, max);
        return sdf.format(calendar.getTime());
    }

    public static String getCurentMonth(SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        int max = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, max);
        return dateFormat.format(calendar.getTime());
    }

    public static String getLastDayofThisMonth(SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        return dateFormat.format(lastDayOfMonth);
    }

    public static String getFirstDayofThisMonth(SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();   // this takes current date
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDay = calendar.getTime();
        return dateFormat.format(firstDay);
    }

    public static String getFirstDayofWeek(SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return dateFormat.format(calendar.getTime());
    }

    public static String getFirstDayofNextWeek(SimpleDateFormat dateFormat) {
        Calendar now = Calendar.getInstance();
        int weekday = now.get(Calendar.DAY_OF_WEEK);
        if (weekday != Calendar.MONDAY) {
            // calculate how much to add
            // the 2 is the difference between Saturday and Monday
            int days = (Calendar.SATURDAY - weekday + 2) % 7;
            now.add(Calendar.DAY_OF_YEAR, days);
        }

        Date date = now.getTime();
        return dateFormat.format(date.getTime());
    }

    public static String getFirstDayofNextMonth(SimpleDateFormat dateFormat) {
        Calendar calendar = getInstance();   // this takes current date
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDay = calendar.getTime();
        return dateFormat.format(firstDay);
    }

    public static String getLastDayofNextMonth(SimpleDateFormat dateFormat) {
        Calendar calendar = getInstance();   // this takes current date
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 2);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        Date firstDay = calendar.getTime();
        return dateFormat.format(firstDay);
    }

    public static String getLastDayofWeek(SimpleDateFormat dateFormat) {
        String lastDay = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        for (int i = 0; i < 7; i++) {
            lastDay = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        return lastDay;
    }

    public static List<String> getList7DayAfter(SimpleDateFormat dateFormat) {
        List<String> days = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        for (int i = 0; i < 6; i++) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
            days.add(dateFormat.format(cal.getTime()));
        }
        return days;
    }

    public static String getLastDayofNextWeek(SimpleDateFormat dateFormat) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.add(Calendar.DATE, 7);
        return (dateFormat.format(c.getTime()));
    }

    public static String[] getDaysCurrentWeek(SimpleDateFormat dateFormat) {
        String[] days = new String[7];
        Calendar now = Calendar.getInstance();
        int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; //add 2 if your week start on monday
        now.add(Calendar.DAY_OF_MONTH, delta);
        for (int i = 0; i < 7; i++) {
            days[i] = dateFormat.format(now.getTime());
            now.add(Calendar.DAY_OF_MONTH, 1);
        }
        return days;
    }

    public static Date getDateFromString(SimpleDateFormat dateFormat, String day) {
        try {
            Date date = dateFormat.parse(day);
            return date;
        } catch (Exception e) {
        }
        return new Date();
    }

    public static String[] getList7DayAfter1(SimpleDateFormat dateFormat, String day) {
        String[] days = new String[7];
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDateFromString(dateFormat, day));
        cal.add(Calendar.DAY_OF_YEAR, 0);
        for (int i = 0; i < 7; i++) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
            days[i] = dateFormat.format(cal.getTime());
//            Log.d("zxcvbnm,.", days[i]);
        }
        return days;
    }

    public static String[] get60Days(boolean type, SimpleDateFormat dateFormat) {
        String[] days = new String[60];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getDateFromString(dateFormat, dateFormat.format(Calendar.getInstance().getTime())));
        if (type) {
            calendar.add(Calendar.DAY_OF_YEAR, 0);
        } else {
            calendar.add(Calendar.DAY_OF_YEAR, -31);
        }
        for (int i = 0; i < 60; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            days[i] = (dateFormat.format(calendar.getTime()));
        }
        return days;
    }

    @SuppressLint("StringFormatMatches")
    public static String getAgeFromBirthDayString(String birthday, SimpleDateFormat dateFormat, Context context) {
        String age = "";
        try {
            Date date = dateFormat.parse(birthday);
            Date now = new Date();
            age = String.valueOf(now.getYear() - date.getYear());
            return age + "years";
//            return age + context.getResources().getString(R.string.txt_age);txt_age
        } catch (Exception e) {
            e.printStackTrace();
        }
        return age;
    }

    public static String getCurrentDate(SimpleDateFormat dateFormat) {
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void getDayOfMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfTheMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfTheMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate squareCalendarMonthDayStart = firstDayOfTheMonth
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate squareCalendarMonthDayEnd = lastDayOfTheMonth
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        List<LocalDate> totalDates = new ArrayList<>();
        while (!squareCalendarMonthDayStart.isAfter(squareCalendarMonthDayEnd)) {
            totalDates.add(squareCalendarMonthDayStart);
            squareCalendarMonthDayStart = squareCalendarMonthDayStart.plusDays(1);
        }

        totalDates.forEach(System.out::println);
    }

}
