package com.mygdx.game.core;

public class Consumible extends Item{
    String type;

    public Consumible (String name, String type)
    {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
