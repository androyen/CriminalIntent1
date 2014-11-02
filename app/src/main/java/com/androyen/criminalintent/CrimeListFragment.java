package com.androyen.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

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
//        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);

    }

    //Implements onListItemClick to respond to selection of ListView
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

//        Crime c = (Crime)(getListAdapter()).getItem(position);
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        Log.d(TAG, c.getTitle() + " was clicked");
    }

    //Create adapter subclass to display custom list item in list_item_crime.xml
    private class CrimeAdapter extends ArrayAdapter<Crime> {

        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        //Recycle and reuse ListViews
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //If no view, inflate one
            if (convertView == null) {
                //Using the custom list item xml for the view
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }

            //configure the view for this crime. Using the custom list item.xml
            Crime c = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());
            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString());
            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            //Return view to ListView
            return convertView;
        }
    }

}
