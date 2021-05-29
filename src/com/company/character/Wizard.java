package com.company.character;

import com.company.items.Armor;
import com.company.items.Item;
import com.company.items.Weapon;
import com.company.rooms.Turn;
import com.company.utils.Rules;

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
        return 0+this.getMight();
    }

    @Override
    public Turn makeAttack(Character target) {
        if (Rules.getRandomNumber(20)+this.getIntelligence()>target.getArmor())
        {
            int damage = Rules.getRandomNumber(6)+this.getIntelligence();
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(0,this, target, "attacked ", damage);
        } else{
            return new Turn(0, this, target, "missed ", 0);
        }
    }

    @Override
    public Turn castSpell(Character target, Spell spell) {
        if (Rules.getRandomNumber(20)+this.getIntelligence() > Rules.getRandomNumber(20)+ target.getIntelligence())
        {
            this.setEnergy(this.getEnergy()-spell.getEnergyCost());
            target.setHitPoints(target.getHitPoints()-spell.getDamage());
            return new Turn (0, this, target, "Cast: " + spell.getName(), spell.getDamage());
        }else {
            return new Turn (0, this, target, "Missed a spell", 0);
        }
    }
}
