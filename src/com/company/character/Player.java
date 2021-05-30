package com.company.character;

import com.company.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Character {
    List<Item> backpack;

    public  Player (String name, int might, int agility, int intelligence, List<Item> backpack)
    {
        super(name,might,agility,intelligence);
        this.backpack = backpack;
    }

    public List<Item> getBackpack() {
        return backpack;
    }

    public void setBackpack(List<Item> backpack) {
        this.backpack = backpack;
    }
}
