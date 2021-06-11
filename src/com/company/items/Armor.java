package com.company.items;

public class Armor extends Item {
    private int armorBonus;

    public Armor (String name, int armor)
    {
        super(name, "Armor");
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
        return "\n\tArmor: " + this.getName() + "\n\tArmor bonus: " + this.getArmorBonus();
    }
}
