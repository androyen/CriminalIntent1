package com.androyen.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by rnguyen on 11/1/14.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;
    private static final String TAG = CrimeListFragment.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set title of Activity hosting this fragment
        getActivity().setTitle(R.string.crimes_title);

        //Get the singleton for the list of crimes
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        //ArrayAdapter for the ListView
        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
        setListAdapter(adapter);

    }

    //Implements onListItemClick to respond to selection of ListView
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Crime c = (Crime)(getListAdapter()).getItem(position);
        Log.d(TAG, c.getTitle() + " was clicked");
    }

}
