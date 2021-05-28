package com.company.character;

import com.company.rooms.Turn;

public abstract class Enemy extends Character {

    public Enemy (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence);
    }

    public abstract Turn makeAction(Character target);
}
