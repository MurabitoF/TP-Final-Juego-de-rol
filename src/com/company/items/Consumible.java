package com.company.items;

public abstract class Consumible extends Item {
    private int uses;

    public Consumible(String name, int uses, String type) {
        super(name, type);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
