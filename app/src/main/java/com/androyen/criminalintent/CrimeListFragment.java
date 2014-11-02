package com.androyen.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;

/**
 * Created by rnguyen on 11/1/14.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set title of Activity hosting this fragment
        getActivity().setTitle(R.string.crimes_title);

        //Get the singleton for the list of crimes
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

    }

}
