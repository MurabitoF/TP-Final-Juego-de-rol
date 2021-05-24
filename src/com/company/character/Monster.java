package com.company.character;

import com.company.rooms.Turn;
import com.company.utils.Rules;

public class Monster extends Enemy{

    public Monster (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence);
    }

    public void multiAttack(Character target)
    {
        int numOfAttacks = Rules.getRandomNumber(3) + 1;
        for (int i = 0; i < numOfAttacks; i++){
            makeAttack(target);
        }
    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public void makeAction(Character taget) {
        int action = Rules.getRandomNumber(100);

        if (action <= 65){
            makeAttack(taget);
        }else
        {
            multiAttack(taget);
        }
    }

    @Override
    public Turn makeAttack(Character target) {
        if(Rules.getRandomNumber(20) >= target.getArmor()){
            int damage = Rules.getRandomNumber(6) + this.getAgility();
            target.setHitPoints(target.getHitPoints() - damage + this.getAgility());
            return new Turn(0,this, target, "attack", damage);
        }else{
            return new Turn(0,this, target, "miss attack", 0);
        }
    }
}
