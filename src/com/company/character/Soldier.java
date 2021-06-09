package com.company.character;

import com.company.rooms.Turn;
import com.company.utils.Tools;

public class Soldier extends Enemy{

    private int armorBonus;

    public  Soldier (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence, "Soldier");
        this.armorBonus = 0;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public Turn defensivePosture()
    {
        this.armorBonus = 5 + Tools.getRandomNumber(5);
        this.setEnergy(this.getEnergy() - 10);
        return new Turn(this, this, "defensive posture", this.armorBonus);
    }

    @Override
    public int getArmor() {
        return 5 + this.armorBonus + this.getMight();
    }

    @Override
    public Turn makeAction(Character target) {
        int action = Tools.getRandomNumber(100);
        this.armorBonus = 0;

        if (action <= 70 || this.getEnergy() < 10){
            return makeAttack(target);
        }else{
            return defensivePosture();
        }
    }

    @Override
    public Turn makeAttack(Character target) {
        if(Tools.getRandomNumber(20) >= target.getArmor()){
            int damage = Tools.getRandomNumber(8) + this.getMight();
            target.setHitPoints(target.getHitPoints() - damage);
            return new Turn(this, target, "attacked", damage);
        }else{
            return new Turn(this, target, "miss attack", 0);
        }
    }
}
