package com.ericlangdon.individualapp;

import java.util.UUID;

public class Player {
    //###################### field variables
    private UUID mID;
    private String fName;
    private String lName;
    private String name;
    private int num;

    //###################### Constructor
    public Player() {
        mID = UUID.randomUUID();
        num = -1;
    }

    public Player(String first, String last, int num) {
        fName = first;
        lName = last;
        this.num = num;
    }

    //###################### GETTERS / SETTERS
    public UUID getID() {
        return mID;
    }

    public void setID(UUID mID) {
        this.mID = mID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() { return fName + " " + lName; }
}
