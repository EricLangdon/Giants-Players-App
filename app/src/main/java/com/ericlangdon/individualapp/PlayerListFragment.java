package com.ericlangdon.individualapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayerListFragment extends Fragment {

    private RecyclerView playerRecyclerView;
    private PlayerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player_list, container, false);

        playerRecyclerView = v.findViewById(R.id.player_recycler_view);
        playerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        Roster roster = Roster.get(getActivity());
        List<Player> players = roster.getPlayers();
        adapter = new PlayerAdapter(players);
        playerRecyclerView.setAdapter(adapter);
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    private class PlayerHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        private Player p;
        private TextView titlePlayerName;
        private TextView titlePlayerNum;

        public PlayerHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_player, parent, false));

            itemView.setOnClickListener(this);
            titlePlayerName = itemView.findViewById(R.id.player_Title);
            titlePlayerNum = itemView.findViewById(R.id.player_Num);
        }

        public void bind (Player p) {
            this.p = p;
            titlePlayerName.setText(p.getName());
            titlePlayerNum.setText(p.getNum() + " ");
        }

        @Override
        public void onClick(View view) {
            Intent intent = MainActivity.newIntent(getActivity(), p.getID());
            startActivity(intent);
        }
    }

    private class PlayerAdapter extends RecyclerView.Adapter<PlayerHolder> {
        private List<Player> players;

        public PlayerAdapter(List<Player> players) {
            this.players = players;
        }
        //#####################################################################
        @Override
        public PlayerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new PlayerHolder(inflater, parent);
        }
        @Override
        public void onBindViewHolder(PlayerHolder holder, int pos) {
            Player p = players.get(pos);
            holder.bind(p);
        }
        @Override
        public int getItemCount() {
            return players.size();
        }
    }

}
