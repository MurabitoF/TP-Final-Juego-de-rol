package com.company.character;

import com.company.items.Armor;
import com.company.items.Item;
import com.company.items.Weapon;
import com.company.rooms.Turn;
import com.company.utils.Tools;


import java.util.ArrayList;
import java.util.List;

public class Wizard extends Player implements IMagic{
    private List<Spell> spellBook;

    public Wizard (String name, int might, int agility, int intelligence, List<Item> backpack, List<Spell> spellBook)
    {
        super(name, might, agility, intelligence, backpack);
        this.spellBook = spellBook;
    }

    public List<Spell> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(List<Spell> spellBook) {
        this.spellBook = spellBook;
    }

    public Turn recoverEnergy(){
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
        return 5+this.getAgility() + this.getEquippedArmor().getArmorBonus();
    }

    @Override
    public Turn makeAttack(Character target) {
        if (Tools.getRandomNumber(20)+this.getAgility()+getEquippedWeapon().getAttackBonus()>=target.getArmor())
        {
            int damage = Tools.getRandomNumber(this.getEquippedWeapon().getDamageDice())+this.getMight();
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(this, target, "attacked ", damage);
        } else{
            return new Turn(this, target, "missed ", 0);
        }
    }

    @Override
    public Turn castSpell(Character target, Spell spell) {
        if (this.getEnergy()>=10 && Tools.getRandomNumber(20)+this.getIntelligence() > Tools.getRandomNumber(20)+ target.getIntelligence())
        {
            this.setEnergy(this.getEnergy()-spell.getEnergyCost());
            target.setHitPoints(target.getHitPoints()-spell.getDamage());
            return new Turn (this, target, "Cast: " + spell.getName(), spell.getDamage());
        }else {
            return new Turn (this, target, "Missed a spell", 0);
        }
    }
}
