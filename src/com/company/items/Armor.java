package com.company.items;

public class Armor extends Item {
    private int armorBonus;

    public Armor (String name, int id, int armor)
    {
        super(name, id);
        this.armorBonus = armor;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armor) {
        this.armorBonus = armor;
    }

    @Override
    public String toString()
    {
        return " Armadura: " + this.getName() + "\nBonus de armadura: " + this.getArmorBonus();
    }
}
