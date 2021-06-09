package com.company.character;

import com.company.items.*;
import com.company.rooms.Turn;
import com.company.utils.Tools;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Character {
    List<Item> backpack;
    Weapon equippedWeapon;
    Armor equippedArmor;


    public  Player (String name, int might, int agility, int intelligence, List<Item> backpack)
    {
        super(name,might,agility,intelligence);
        this.backpack = backpack;
        this.equippedArmor = new Armor("Unarmored", 0);
        this.equippedWeapon = new Weapon("Unarmed", 0, 1, 2);
    }

    public List<Item> getBackpack() {
        return backpack;
    }

    public void setBackpack(List<Item> backpack) {
        this.backpack = backpack;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public Turn useItem(Item item, Enemy target) {
        if (item instanceof Armor) {
            this.equipArmor((Armor)item);
            return new Turn(this,this,"Equipped: " + item.getName(), 0);
        } else if (item instanceof Weapon)
            {
                this.equipWeapon((Weapon)item);
                return new Turn(this,this,"Equipped: " + item.getName(), 0);
            } else
            {
                if (item instanceof Scroll)
                {
                    return this.useScroll((Scroll) item, target);
                }
                return this.useConsumible((Consumible) item);
            }
        }

    public void pickupLoot(Item loot) {
        this.backpack.add(loot);
    }

    public Item searchBackpack(int id) {
        return backpack.get(id);
    }

    private void equipArmor(Armor armor)
    {
        backpack.add(this.getEquippedArmor());
        this.setEquippedArmor(armor);
        backpack.remove(armor);
    }

    private void equipWeapon(Weapon weapon)
    {
        backpack.add(this.getEquippedWeapon());
        this.setEquippedWeapon(weapon);
        backpack.remove(weapon);
    }

    private Turn useConsumible(Consumible potion)
    {
        if (potion instanceof HealingPotion)
        {
            if (this.getHitPoints()<= this.getHitPoints()-((HealingPotion) potion).getHealingAmount())
            {
                this.setHitPoints(((HealingPotion) potion).getHealingAmount());
                this.updateUses(potion);
                return new Turn(this,this,"Drinked:" + potion.getName(), ((HealingPotion) potion).getHealingAmount());
            } else
            {
                this.setHitPoints(this.setInitialHp());
                this.updateUses(potion);
                return new Turn(this,this,"Drinked:" + potion.getName(), ((HealingPotion) potion).getHealingAmount());
            }
        } else
        {
            if (this.getEnergy()<=this.getEnergy()-((EnergyPotion)potion).getEnergyAmount())
            {
                this.setEnergy(((EnergyPotion) potion).getEnergyAmount());
                this.updateUses(potion);
                return new Turn(this,this,"Drinked:" + potion.getName(), ((EnergyPotion) potion).getEnergyAmount());

            } else
            {
                this.setEnergy(this.setInitialEnergy());
                this.updateUses(potion);
                return new Turn(this,this,"Drinked:" + potion.getName(), ((EnergyPotion) potion).getEnergyAmount());
            }
        }
    }

    private Turn useScroll (Scroll scroll, Enemy target)
    {
        if (Tools.getRandomNumber(20)+this.getIntelligence() > Tools.getRandomNumber(20)+ target.getIntelligence())
        {
            target.setHitPoints(target.getHitPoints()-scroll.getSpell().getDamage());
            updateUses(scroll);
            return new Turn (this, target, "Used a scroll of: " + scroll.getSpell().getName(), scroll.getSpell().getDamage());
        }else {
            return new Turn (this, target, "Failed to use a scroll", 0);
        }
    }

    public void updateUses (Consumible consumible)
    {
        consumible.setUses(consumible.getUses()-1);
        if (consumible.getUses() == 0)
        {
            this.backpack.remove(consumible);
        }
    }

}
