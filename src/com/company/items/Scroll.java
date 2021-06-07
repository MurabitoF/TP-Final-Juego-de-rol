package com.company.items;

import com.company.character.Spell;

public class Scroll extends Consumible{
    Spell spell;

    public Scroll (String name, Spell spell)
    {
        super(name, 1, "Scroll");
        this.spell = spell;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }
}
