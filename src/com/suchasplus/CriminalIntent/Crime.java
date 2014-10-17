package com.suchasplus.CriminalIntent;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by suchasplus on 14-10-15.
 * Copyleft by suchasplus.com
 */
public class Crime {

    private UUID mId;

    private String mTitle;

    private Date mDate;

    private boolean mSolved;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
          return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getDateFormatted() {
        return DateFormat.format("yyyyMMdd H:i:s", mDate).toString();
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String toString() {
        return mTitle;
    }
}
