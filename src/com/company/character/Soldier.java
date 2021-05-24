package com.company.character;

import com.company.rooms.Turn;
import com.company.utils.Rules;

public class Soldier extends Enemy{

    private int armorBonus;

    public  Soldier (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence);
        this.armorBonus = 0;
    }

    public void parry()
    {

    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public void makeAction(Character taget) {
        int action = Rules.getRandomNumber(100);

        this.armorBonus = 0;

        if (action <= 70){
            makeAttack(null);
        }else
        {
            parry();
        }
    }

    @Override
    public Turn makeAttack(Character target) {
        if(Rules.getRandomNumber(20) >= target.getArmor()){
            int damage = Rules.getRandomNumber(12) + this.getMight();
            target.setHitPoints(target.getHitPoints() - damage);
            return new Turn(0,this, target, "attack", damage);
        }else{
            return new Turn(0,this, target, "miss attack", 0);
        }
    }
}
