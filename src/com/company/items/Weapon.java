package com.company.items;

public class Weapon extends Item{
    private int damageDice;
    private int attackBonus;
    private int damageBonus;

    public Weapon (String name, int attackBonus, int damageBonus, int damageDice)
    {
        super(name, "Weapon");
        this.damageDice = damageDice;
        this.attackBonus = attackBonus;
        this.damageBonus = damageBonus;
    }

    public int getDamageDice() {
        return damageDice;
    }

    public void setDamageDice(int damageDice) {
        this.damageDice = damageDice;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public void setDamageBonus(int damageBonus) {
        this.damageBonus = damageBonus;
    }

    @Override
    public String toString()
    {
        return "Weapon: " + this.getName() + "\n\tDamage dice: 1d" + this.getDamageDice() + "\n\tAttack bonus: " + this.getAttackBonus() + "\n\tDamage bonus: " + this.getDamageBonus();
    }
}
