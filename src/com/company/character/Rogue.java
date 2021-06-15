package com.company.character;

import com.company.items.Item;
import com.company.rooms.Turn;
import com.company.utils.Tools;
import java.util.List;

public class Rogue extends Player{

    private boolean isAiming;

    public Rogue (String name, int might, int agility, int intelligence, List<Item> backpack)
    {
        super(name, might, agility, intelligence, "Rogue", backpack);
        this.isAiming = false;
    }


    public boolean isAiming() {
        return isAiming;
    }

    public void setAiming(boolean aiming) {
        isAiming = aiming;
    }

    public Turn sneakAttack(Character target)
    {
        if (Tools.getRandomNumber(20)+this.getAgility()>target.getArmor() || this.isAiming)
        {
            this.isAiming = false;
            int damage = (Tools.getRandomNumber(this.getEquippedWeapon().getDamageDice())+this.getAgility()) * 2;
            target.setHitPoints(target.getHitPoints() - damage);
            this.setEnergy(this.getEnergy() - 25);
            return new Turn(this, target, "sneak attacked ", damage);
        } else{
            return new Turn(this, target, "missed ", 0);
        }
    }

    public Turn aim()
    {
        this.setAiming(true);
        return new Turn(this, this, "aiming", 0);
    }

    @Override
    public int getArmor() {
        return 5+this.getAgility() + this.getEquippedArmor().getArmorBonus();
    }

    @Override
    public Turn makeAttack(Character target) {
        if (Tools.getRandomNumber(20)+this.getAgility()+getEquippedWeapon().getAttackBonus()>=target.getArmor() || this.isAiming)
        {
            this.isAiming = false;
            int damage = Tools.getRandomNumber(this.getEquippedWeapon().getDamageDice())+this.getAgility()+this.getEquippedWeapon().getDamageBonus();
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(this, target, "attacked ", damage);
        } else{
            return new Turn(this, target, "missed ", 0);
        }
    }

    @Override
    public String statePlayerInCombat(){
        String player = this.getName() + "\n";
        player = player + "HP: " + this.getHitPoints() + "\t Energy: " + this.getEnergy() + "\n";
        if (this.isAiming){
            player = player + "There's aiming the next attack";
        }else {
            player = player + "The next attack is normal";
        }
        return player;
    }
}
