package com.company.character;

import com.company.rooms.Turn;

public abstract class Character {

    private String name;
    private int hitPoints;
    private int energy;
    private int might;
    private int agility;
    private int intelligence;

    public Character (String name, int might, int agility, int intelligence)
    {
        this.name = name;
        this.hitPoints = might * 5;
        this.energy = intelligence * 10;
        this.might = might;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMight() {
        return might;
    }

    public void setMight(int might) {
        this.might = might;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public abstract int getArmor();

    public abstract Turn makeAttack(Character target);

    public int setMaxHp()
    {
        return this.might * 5;
    }

    public int setMaxEnergy()
    {
        return this.intelligence * 10;
    }

}
