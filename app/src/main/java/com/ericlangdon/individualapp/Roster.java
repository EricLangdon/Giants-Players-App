package com.ericlangdon.individualapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Roster {
    private static Roster roster;

    private List<Player> players;

    public static Roster get(Context context) {
        if (roster == null) {
            roster = new Roster(context);
        }
        return roster;
    }

    private Roster (Context context) {
        players = new ArrayList<>();

        //Hardcoded values for now
        for (int i = 0; i < 100; i ++) {
            Player p = new Player();
            p.setNum(i);
            p.setfName("Hardcoded");
            p.setlName("Value");

            players.add(p);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(UUID id) {
        for (Player p : players) {
            if (p.getID().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
