package com.ericlangdon.individualapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.UUID;

public class PlayerFragment extends Fragment {
    private static final String ARG_PLAYER_ID = "player_id";
    private Player playerFrag;
    private EditText editFirstName;
    private EditText editLastName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // UUID playerId = (UUID) getActivity().getIntent().getSerializableExtra(MainActivity.PLAYER_ID);
        UUID playerId = (UUID) getArguments().getSerializable(ARG_PLAYER_ID);
        playerFrag = Roster.get(getActivity()).getPlayer(playerId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player, container, false);


        editFirstName = (EditText) v.findViewById(R.id.player_fName);
        editLastName = (EditText) v.findViewById(R.id.player_lName);

        editFirstName.setText(playerFrag.getfName());
        editFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                playerFrag.setfName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editLastName.setText(playerFrag.getlName());
        editLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                playerFrag.setlName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return v;
    }

    public static PlayerFragment newInstance(UUID playerID) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_PLAYER_ID, playerID);

        PlayerFragment frag = new PlayerFragment();
        frag.setArguments(args);
        return frag;
    }


}
