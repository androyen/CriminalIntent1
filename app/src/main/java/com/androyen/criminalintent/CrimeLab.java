package com.androyen.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by rnguyen on 11/1/14.
 */

//Singleton. Data will exist in memory as long as the application stays in memory regardless of what happens to activities and fragments
public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    //Singletons use a private constructor
    private CrimeLab(Context appContext) {
        mAppContext = appContext;

        //Send list of crimes
        mCrimes = new ArrayList<Crime>();

        //Populating 100 crimes
        for (int i = 0; i < 100; i++) {

            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            //Set every other even crime to Solved
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }


    }

    //Getter for Singleton
    public static CrimeLab get(Context c) {
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }

        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {

        //Loop through ArrayList of crimes to check the ID
        for (Crime c: mCrimes) {

            //If ID matches crime in ArrayList, return the crime
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
