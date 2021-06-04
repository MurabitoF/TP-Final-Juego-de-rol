package com.company.character;

import com.company.rooms.Turn;
import com.company.utils.Tools;

public class Monster extends Enemy{

    public Monster (String name, int might, int agility, int intelligence)
    {
        super(name, might, agility, intelligence);
    }

    public Turn multiAttack(Character target)
    {
        int numOfAttacks = Tools.getRandomNumber(3) + 1;
        this.setEnergy(this.getEnergy() - 20);
        Turn turn = new Turn(this, target, "attaqued " + numOfAttacks + " times", 0);
        for (int i = 0; i < numOfAttacks; i++){
            turn.setResultOfAction(turn.getResultOfAction() + makeAttack(target).getResultOfAction());
        }
        return turn;
    }

    @Override
    public int getArmor() {
        return 7 + this.getAgility();
    }

    @Override
    public Turn makeAction(Character taget) {
        int action = Tools.getRandomNumber(100);

        if (action <= 65 || this.getEnergy() < 20){
            return makeAttack(taget);
        }else
        {
            return multiAttack(taget);
        }
    }

    @Override
    public Turn makeAttack(Character target) {
        if(Tools.getRandomNumber(20) >= target.getArmor()){
            int damage = Tools.getRandomNumber(6) + this.getAgility();
            target.setHitPoints(target.getHitPoints() - damage + this.getAgility());
            return new Turn(this, target, "attacked", damage);
        }else{
            return new Turn(this, target, "miss attack", 0);
        }
    }
}
