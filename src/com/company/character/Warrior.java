package com.company.character;

import com.company.items.Armor;
import com.company.items.Item;
import com.company.items.Weapon;
import com.company.rooms.Turn;
import com.company.utils.Rules;

import java.util.ArrayList;

public class Warrior extends Player{

    private boolean isRaging;

    public Warrior (String name, int might, int agility, int intelligence, ArrayList<Item> backpack)
    {
        super(name, might, agility, intelligence, backpack);
        this.isRaging = false; //Se lo puede poner por defecto en false porque nunca va a empezar con rage
    }

    public boolean isRaging() {
        return isRaging;
    }

    public void setRaging(boolean raging) {
        isRaging = raging;
    }

    public void cleaveAttack()
    {

    }

    public void rage()
    {
        this.setRaging(true); //agregar beneficio de rage
    }

    @Override
    public int getArmor() {
        return 0+this.getMight();
    }

    @Override
    public Turn makeAttack(Character target) {
        if (Rules.getRandomNumber(20)+this.getMight()>target.getArmor() || this.isRaging==true)
        {
            int damage = Rules.getRandomNumber(6)+this.getMight();
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(0,this, target, "attacked ", damage);
        } else{
            return new Turn(0, this, target, "missed ", 0);
        }
    }


}
