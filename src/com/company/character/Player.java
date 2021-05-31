package com.company.character;

import com.company.items.Armor;
import com.company.items.Item;
import com.company.items.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Character {
    List<Item> backpack;
    Weapon equippedWeapon;
    Armor equippedArmor;
    int exp;


    public  Player (String name, int might, int agility, int intelligence, List<Item> backpack)
    {
        super(name,might,agility,intelligence);
        this.backpack = backpack;
        this.equippedArmor = new Armor("Sin armadura", 0, 0);
        this.equippedWeapon = new Weapon("Desarmado", 0, 0, 1, 2);
        this.exp = 0;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    private void equipItem(Item item) {
        if (item !=null && item instanceof Armor) {
            backpack.add(this.getEquippedArmor());
            this.setEquippedArmor((Armor)item);
            backpack.remove(item);
        } else {
            if (item !=null && item instanceof Weapon)
            {
                backpack.add(this.getEquippedWeapon());
                this.setEquippedWeapon((Weapon)item);
                backpack.remove(item);
            }
        }
    }

    public void pickupLoot(Item loot) {
        this.backpack.add(loot);
    }

    public Item searchBackpack(int id) {
        return backpack.get(id);
    }


    public void openBackpack() {
        for (Item item : backpack)
        {
            System.out.println(backpack.indexOf(item)+1 + ". " + item.toString());
        }
    }

}
