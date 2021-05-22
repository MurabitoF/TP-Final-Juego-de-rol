package com.company.character;

import com.company.items.Item;

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
    public void makeAttack(Character target) {

    }

    @Override
    public void doDamage(Character target) {

    }
}
