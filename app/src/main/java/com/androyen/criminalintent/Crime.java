package com.androyen.criminalintent;

import java.util.UUID;

/**
 * Created by rnguyen on 11/1/14.
 */
public class Crime {

    //Model layer

    private UUID mId;
    private String mTitle;

    public Crime() {
        //Generate unique identifier for Crime
        mId = UUID.randomUUID();
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

}
