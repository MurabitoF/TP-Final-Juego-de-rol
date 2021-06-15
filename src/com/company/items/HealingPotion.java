package com.company.items;

public class HealingPotion extends Consumible {

    private String size;
    private int healingAmount;

    public HealingPotion(String name, int uses, String size, int healingAmount) {
        super(name, uses, "HealingPotion");
        this.size = size;
        this.healingAmount = healingAmount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int energyAmount) {
        this.healingAmount = energyAmount;
    }

    @Override
    public String toString()
    {
        return this.getName() + "\n\tUses: " + this.getUses() + "\n\tSize: " + this.getSize() + "\n\tAmount of healing: " + this.getHealingAmount();
    }
}
