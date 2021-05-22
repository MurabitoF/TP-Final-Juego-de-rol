package com.company.items;

public class HealingPotion extends Consumible {

    private String size;
    private int energyAmount;

    public HealingPotion(String name, int uses, String size, int energyAmount) {
        super(name, uses);
        this.size = size;
        this.energyAmount = energyAmount;
    }

    @Override
    public void useConsumible() {

    }
}
