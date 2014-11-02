package com.androyen.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by rnguyen on 11/1/14.
 */

//Hosted inside CrimeActivity
public class CrimeFragment extends Fragment {

    private Crime mCrime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize crime during creation
        mCrime = new Crime();
    }

}
