package com.ericlangdon.individualapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {

    private static final String EXTRA_PLAYER_ID =
            "com.ericlangdon.individualapp.player_id";

    @Override
    protected Fragment createFrag() {
        UUID id = (UUID) getIntent().getSerializableExtra(EXTRA_PLAYER_ID);
        return PlayerFragment.newInstance(id);
    }

    public static Intent newIntent(Context packageContext, UUID playerId) {
        Intent i = new Intent(packageContext, MainActivity.class);
        i.putExtra(EXTRA_PLAYER_ID, playerId);
        return i;
    }
}
