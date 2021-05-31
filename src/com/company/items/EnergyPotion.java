package com.company.items;

public class EnergyPotion extends Consumible{

    private String size;
    private int energyAmount;

    public EnergyPotion(String name, int id, int uses, String size, int energyAmount) {
        super(name, id, uses);
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
    public int useConsumible() {
        return energyAmount;
    }

    @Override
    public String toString()
    {
        return " " + this.getName() + "\nUsos: " + this.getUses() + "\nTamaño: " + this.getSize() + "\nCantidad de energía: " + this.getEnergyAmount();
    }
}
