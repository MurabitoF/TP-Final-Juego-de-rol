package com.company.items;

public class EnergyPotion extends Consumible{

    private String size;
    private int energyAmount;

    public EnergyPotion(String name, int uses, String size, int energyAmount) {
        super(name, uses);
        this.size = size;
        this.energyAmount = energyAmount;
    }

    @Override
    public void useConsumible() {

    }
}
