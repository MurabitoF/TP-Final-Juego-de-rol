package com.mygdx.game.core;

import java.util.ArrayList;

public class Mage extends Enemy implements IMagic{

    ArrayList<Spell> spellBook;

    public Mage(String name, int might, int agility, int intelligence, ArrayList<Spell> spellBook) {
        super(name, might, agility, intelligence);
        this.spellBook = spellBook;
    }

    public ArrayList<Spell> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(ArrayList<Spell> spellBook) {
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
