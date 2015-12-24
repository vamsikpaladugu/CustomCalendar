package com.vamsi.mycalendar.CustomCalendarView.Helpers;

/**
 * Created by Vamsi Darling on 12/24/2015.
 */
public class Badge {

    int count,day,month;

    public Badge(){

    }

    public Badge(int count,int day,int month){
        this.count = count;
        this.day = day;
        this.month = month;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
