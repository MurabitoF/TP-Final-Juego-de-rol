package com.company.items;

public class Key extends Item{
    private String symbol;

    public Key(String name, String symbol) {
        super(name, "Key");
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
        return this.getName() + "\n\tSymbol: " + this.getSymbol();
    }
}
