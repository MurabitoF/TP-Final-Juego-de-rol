package com.company.character;

public class Spell {
    private String name;
    private int energyCost;
    private int damage;

    public Spell (String name, int energyCost, int damage)
    {
        this.name = name;
        this.energyCost = energyCost;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
