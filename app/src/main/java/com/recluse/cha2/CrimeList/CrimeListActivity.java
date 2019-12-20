package com.recluse.cha2.CrimeList;

import android.support.v4.app.Fragment;

import com.recluse.cha2.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}

