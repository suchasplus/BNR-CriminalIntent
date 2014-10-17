package com.suchasplus.CriminalIntent;

import android.app.Fragment;
import android.os.Bundle;

import java.util.UUID;

/**
 * Created by suchasplus on 14-10-16.
 * Copyleft by suchasplus.com
 */
public class CrimeListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
