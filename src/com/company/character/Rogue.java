package com.company.character;

import com.company.items.Item;
import com.company.rooms.Turn;

import java.util.ArrayList;

public class Rogue extends Player{

    private boolean isHidden;

    public Rogue (String name, int might, int agility, int intelligence, ArrayList<Item> backpack)
    {
        super(name, might, agility, intelligence, backpack);
        this.isHidden = false; //Al igual que en Warrior no va a comenzar escondido el personaje
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public void sneakAttack()
    {

    }

    public void hide()
    {
        this.setHidden(true); //falta establecer el beneficio de esconderse
    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public Turn makeAttack(Character target) {
        return null;
    }

}
