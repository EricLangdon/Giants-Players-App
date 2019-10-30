package com.ericlangdon.individualapp;

import androidx.fragment.app.Fragment;

public class PlayerListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFrag() {
        return new PlayerListFragment();
    }
}
