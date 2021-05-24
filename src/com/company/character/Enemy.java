package com.company.character;

public abstract class Enemy extends Character {

    public Enemy (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence);
    }

    public abstract void makeAction(Character target);
}
