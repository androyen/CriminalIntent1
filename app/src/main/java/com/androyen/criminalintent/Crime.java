package com.androyen.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rnguyen on 11/1/14.
 */
public class Crime {

    //Model layer

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        //Generate unique identifier for Crime
        mId = UUID.randomUUID();

        //Create new Date  Sets date to the current time created
        mDate = new Date();
    }

    //Getter and setter
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

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    //Overriding toString() to display more useful data in CrimeListFragment listView
    @Override
    public String toString() {
        return mTitle;
    }


}
