package com.company.items;

public class Key extends Item{
    private String symbol;

    public Key(String name, int id, String symbol) {
        super(name, id);
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString()
    {
        return " " + this.getName() + "\nSimbolo: " + this.getSymbol();
    }
}
