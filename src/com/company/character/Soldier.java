package com.company.character;

import com.company.rooms.Turn;
import com.company.utils.Rules;
import com.sun.javafx.css.Rule;

public class Soldier extends Enemy{

    private int armorBonus;

    public  Soldier (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence);
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
        this.armorBonus = 5 + Rules.getRandomNumber(5);
        this.setEnergy(this.getEnergy() - 10);
        return new Turn(this, this, "defensive posture", this.armorBonus);
    }

    @Override
    public int getArmor() {
        return 5 + this.armorBonus + this.getMight();
    }

    @Override
    public Turn makeAction(Character target) {
        int action = Rules.getRandomNumber(100);
        this.armorBonus = 0;

        if (action <= 70 || this.getEnergy() < 10){
            return makeAttack(target);
        }else
        {
            return defensivePosture();
        }
    }

    @Override
    public Turn makeAttack(Character target) {
        if(Rules.getRandomNumber(20) >= target.getArmor()){
            int damage = Rules.getRandomNumber(12) + this.getMight();
            target.setHitPoints(target.getHitPoints() - damage);
            return new Turn(this, target, "attacked", damage);
        }else{
            return new Turn(this, target, "miss attack", 0);
        }
    }
}
