package com.company.character;

import com.company.items.Armor;
import com.company.items.Item;
import com.company.items.Weapon;
import com.company.rooms.Turn;
import com.company.utils.Rules;
import com.sun.javafx.css.Rule;

import java.util.ArrayList;

public class Wizard extends Player implements IMagic{
    private ArrayList<Spell> spellBook;

    public Wizard (String name, int might, int agility, int intelligence, ArrayList<Item> backpack, ArrayList<Spell> spellBook)
    {
        super(name, might, agility, intelligence, backpack);
        this.spellBook = spellBook;
    }

    public Turn recoverEnergy()
    {
        if (this.getEnergy()<=this.getEnergy()-this.getIntelligence()*2+1)
        {
            this.setEnergy(this.getIntelligence()*2);
            return new Turn(this, this, "Recovered energy", this.getIntelligence()*2);
        }else
        {
            this.setEnergy(setInitialEnergy());
            return new Turn(this, this, "Maxed out energy", this.getEnergy());
        }
    }

    public void learnSpell (Spell spell)
    {
        this.spellBook.add(spell);
    }

    @Override
    public int getArmor() {
        return 2+this.getMight() + this.getEquippedArmor().getArmorBonus();
    }

    @Override
    public Turn makeAttack(Character target) {
        if (Rules.getRandomNumber(20)+this.getIntelligence()+getEquippedWeapon().getAttackBonus()>=target.getArmor())
        {
            int damage = Rules.getRandomNumber(6)+this.getIntelligence();
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(this, target, "attacked ", damage);
        } else{
            return new Turn(this, target, "missed ", 0);
        }
    }

    @Override
    public Turn castSpell(Character target, Spell spell) {
        if (this.getEnergy()>=10 && Rules.getRandomNumber(20)+this.getIntelligence() > Rules.getRandomNumber(20)+ target.getIntelligence())
        {
            this.setEnergy(this.getEnergy()-spell.getEnergyCost());
            target.setHitPoints(target.getHitPoints()-spell.getDamage());
            return new Turn (this, target, "Cast: " + spell.getName(), spell.getDamage());
        }else {
            return new Turn (this, target, "Missed a spell", 0);
        }
    }
}
