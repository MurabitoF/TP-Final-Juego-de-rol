package com.company.items;

import com.company.character.Spell;

public class Scroll extends Consumible{
    Spell spell;

    public Scroll (String name, int id, Spell spell)
    {
        super(name, id, 1);
        this.spell = spell;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }
}
