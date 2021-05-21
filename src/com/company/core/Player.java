package com.company.core;

import java.util.ArrayList;

public abstract class Player extends Character{
    ArrayList<Item> backpack;

    public  Player (String name, int might, int agility, int intelligence, ArrayList<Item> backpack)
    {
        super(name,might,agility,intelligence);
        this.backpack = backpack;
    }

    public ArrayList<Item> getBackpack() {
        return backpack;
    }

    public void setBackpack(ArrayList<Item> backpack) {
        this.backpack = backpack;
    }
}
