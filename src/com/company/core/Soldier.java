package com.company.core;

public class Soldier extends Enemy{

    public  Soldier (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence);
    }

    public void parry()
    {

    }

    @Override
    public void makeAttack(Character target) {

    }

    @Override
    public void doDamage(Character target) {

    }
}
