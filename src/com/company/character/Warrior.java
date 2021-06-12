package com.company.character;

import com.company.items.Item;
import com.company.rooms.Turn;
import com.company.utils.Tools;
import java.util.List;

public class Warrior extends Player{

    private boolean isRaging;

    public Warrior (String name, int might, int agility, int intelligence, List<Item> backpack)
    {
        super(name, might, agility, intelligence, "Warrior", backpack);
        this.isRaging = false;
    }

    public boolean isRaging() {
        return isRaging;
    }

    public void setRaging(boolean raging) {
        isRaging = raging;
    }

    public Turn recklessAttack(Character target)
    {
        if (Tools.getRandomNumber(20)+this.getMight() + getEquippedWeapon().getAttackBonus()>= target.getArmor() || this.isRaging)
        {
            this.isRaging = false;
            int damage = Tools.getRandomNumber(this.getEquippedWeapon().getDamageDice()) + (this.getMight()*2) +this.getEquippedWeapon().getDamageBonus();
            this.setEnergy(this.getEnergy() - 10);
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(this, target, " reckless attacked ", damage);
        }else
        {
            return new Turn(this, target, " missed against ", 0);
        }
    }

    public Turn rage()
    {
        this.setRaging(true);
        return new Turn(this, this, " raged", 0);
    }

    @Override
    public int getArmor() {
        return 5+this.getMight()+this.getEquippedArmor().getArmorBonus();
    }

    @Override
    public Turn makeAttack(Character target) {
        if (Tools.getRandomNumber(20)+this.getMight()+getEquippedWeapon().getAttackBonus()>=target.getArmor() || this.isRaging)
        {
            this.isRaging = false;
            int damage = Tools.getRandomNumber(this.getEquippedWeapon().getDamageDice())+this.getMight()+this.getEquippedWeapon().getDamageBonus();
            target.setHitPoints(target.getHitPoints()-damage);
            return new Turn(this, target, " attacked ", damage);
        } else{
            return new Turn(this, target, " missed ", 0);
        }
    }

    @Override
    public String statePlayerInCombat(){
        String player = this.getName() + "\n";
        player = player + "HP: " + this.getHitPoints() + "\t Energy: " + this.getEnergy() + "\n";
        if (this.isRaging){
            player = player + this.getName() + " is raging";
        }else {
            player = player + this.getName() + " is calm down";
        }
        return player;
    }
}
