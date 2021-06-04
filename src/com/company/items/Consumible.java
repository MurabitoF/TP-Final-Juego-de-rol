package com.company.items;

public abstract class Consumible extends Item {
    private int uses;

    public Consumible(String name, int id, int uses) {
        super(name, id);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
