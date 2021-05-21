package com.company.core;

import java.util.ArrayList;

public class Wizard extends Player implements IMagic{
    private ArrayList<Spell> spellBook;

    public Wizard (String name, int might, int agility, int intelligence, ArrayList<Item> backpack, ArrayList<Spell> spellBook)
    {
        super(name, might, agility, intelligence, backpack);
        this.spellBook = spellBook;
    }

    @Override
    public void makeAttack(Character target) {

    }

    @Override
    public void doDamage(Character target) {

    }

    @Override
    public void castSpell(Character target, Spell spell) {

    }
}
