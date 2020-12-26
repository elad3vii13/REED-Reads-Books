package com.example.androidenglishreadingtimer;

import android.widget.Chronometer;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Result {

    private Date date;
    private Double chronmeter;

    public Result() {
        this.date = Calendar.getInstance().getTime();
        this.chronmeter= 0.0;
    }

    public Result(Double chronmeter) {
        this.date = Calendar.getInstance().getTime();
        this.chronmeter = chronmeter;
    }

    public Result(Date date, Double chronmeter) {
        this.date = date;
        this.chronmeter = chronmeter;
    }

    public Date getDate() {
        return date;
    }

    public Double getChronmeter() {
        return chronmeter;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setChronmeter(Double chronmeter) {
        this.chronmeter = chronmeter;
    }
}