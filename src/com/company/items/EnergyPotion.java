package com.company.items;

public class EnergyPotion extends Consumible{

    private String size;
    private int energyAmount;

    public EnergyPotion(String name, int uses, String size, int energyAmount) {
        super(name, uses, "EnergyPotion");
        this.size = size;
        this.energyAmount = energyAmount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public void setEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
    }

    @Override
    public String toString()
    {
        return this.getName() + "\n\tUses: " + this.getUses() + "\n\tSize: " + this.getSize() + "\n\tAmaount of energy restored: " + this.getEnergyAmount();
    }
}
