package com.suchasplus.CriminalIntent;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.UUID;

/**
 * Created by suchasplus on 14-10-15.
 * Copyleft by suchasplus.com
 */
public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;

    private Button mDateButton;

    private CheckBox mSolvedCheckBox;

    public final static String EXTRA_CRIME_ID = "com.suchasplus.com.CrimeFragment.EXTRA_CRIME_ID";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

        String msg = "mCrime is ok-------------------------------------------------------------------------------------------------------------------";
        if(mCrime == null) {
            msg = "mCrime is null======================================================================================================================";
        }
        Log.e(EXTRA_CRIME_ID,  msg);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, parent, false);
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
                //getActivity().setTitle("Crime Title: " + s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This too
            }

        });

        mDateButton = (Button) v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDateFormatted());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
                //Toast.makeText(getActivity(), ("checkStatus:" + isChecked), Toast.LENGTH_SHORT ).show();
                String time = (DateFormat.format("E d, yyyy", mCrime.getDate())).toString();
                Toast.makeText(getActivity(), time, Toast.LENGTH_SHORT).show();


            }
        });

        mTitleField.setText(mCrime.getTitle());
        mSolvedCheckBox.setChecked(mCrime.isSolved());


        return v;
    }


    public static CrimeFragment newInstance ( UUID crimeId ) {
        Bundle args = new Bundle();

        args.putSerializable(EXTRA_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
