package com.company.character;

import com.company.items.Armor;
import com.company.items.Item;
import com.company.items.Weapon;
import com.company.rooms.Turn;
import com.company.utils.Rules;

import java.util.ArrayList;

public class Rogue extends Player{

    private boolean isAiming;

    public Rogue (String name, int might, int agility, int intelligence, ArrayList<Item> backpack)
    {
        super(name, might, agility, intelligence, backpack);
        this.isAiming = false; //Al igual que en Warrior no va a comenzar escondido el personaje
    }


    public boolean isHidden() {
        return isAiming;
    }

    public void setHidden(boolean hidden) {
        isAiming = hidden;
    }

    public Turn sneakAttack(Character target)
    {
        if (Rules.getRandomNumber(20)+this.getAgility()>target.getArmor() || this.isAiming==true)
        {
            int damage = (Rules.getRandomNumber(6)+this.getAgility())*2;
            target.setHitPoints(target.getHitPoints()-damage);
            this.setEnergy(this.getEnergy()-25);
            return new Turn(0,this, target, "sneak attacked ", damage);
        } else{
            return new Turn(0, this, target, "missed ", 0);
        }
    }

    public void aim()
    {
        this.setHidden(true); //falta establecer el beneficio de esconderse
    }

    @Override
    public int getArmor() {
        return 0+this.getAgility();
    }

    @Override
    public Turn makeAttack(Character target) {
        if (Rules.getRandomNumber(20)+this.getAgility()>target.getArmor() || this.isAiming==true)
        {
            int damage = Rules.getRandomNumber(6)+this.getAgility();
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(0,this, target, "attacked ", damage);
        } else{
            return new Turn(0, this, target, "missed ", 0);
        }
    }
}
