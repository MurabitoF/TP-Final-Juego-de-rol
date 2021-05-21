package com.company.core;

public class Armor extends Item {
    private int armor;

    public Armor (String name, int armor)
    {
        super(name);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
