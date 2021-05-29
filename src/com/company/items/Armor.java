package com.company.items;

public class Armor extends Item {
    private int armor;

    public Armor (String name, int id, int armor)
    {
        super(name, id);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString()
    {
        return " Armadura: " + this.getName() + "\nBonus de armadura: " + this.getArmor();
    }
}
