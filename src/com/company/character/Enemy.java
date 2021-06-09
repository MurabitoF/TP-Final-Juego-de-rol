package com.company.character;

import com.company.rooms.Turn;

public abstract class Enemy extends Character {

    String type;

    public Enemy (String name, int might, int agility, int intelligence, String type)
    {
        super(name, might, agility, intelligence);
        this.type = type;
    }

    public abstract Turn makeAction(Character target);
}
