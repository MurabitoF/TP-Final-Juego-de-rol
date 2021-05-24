package com.company.character;

import com.company.items.Item;
import com.company.rooms.Turn;

import java.util.ArrayList;

public class Wizard extends Player implements IMagic{
    private ArrayList<Spell> spellBook;

    public Wizard (String name, int might, int agility, int intelligence, ArrayList<Item> backpack, ArrayList<Spell> spellBook)
    {
        super(name, might, agility, intelligence, backpack);
        this.spellBook = spellBook;
    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public Turn makeAttack(Character target) {
        return null;
    }

    @Override
    public Turn castSpell(Character target, Spell spell) {
        return null;
    }
}
