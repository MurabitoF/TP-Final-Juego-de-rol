package com.company.character;

import com.company.rooms.Turn;
import com.company.utils.Rules;

import java.util.ArrayList;

public class Mage extends Enemy implements IMagic{

    private ArrayList<Spell> spellBook;

    public Mage(String name, int might, int agility, int intelligence, ArrayList<Spell> spellBook) {
        super(name, might, agility, intelligence);
        this.spellBook = spellBook;
    }

    public ArrayList<Spell> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(ArrayList<Spell> spellBook) {
        this.spellBook = spellBook;
    }

    public Turn drainEnergy(Character target){
        int energyDrained = 10 + Rules.getRandomNumber(10);
        target.setEnergy(target.getEnergy() - energyDrained);
        this.setEnergy(this.getEnergy() + energyDrained);
        return new Turn(this, target, "drained energy", energyDrained);
    }

    @Override
    public int getArmor() {
        return 5 + this.getMight();
    }

    @Override
    public Turn makeAction(Character target) {
        int action = Rules.getRandomNumber(100);

        if (action <= 35 || this.getEnergy() < 10){
            return makeAttack(target);
        }else if (this.getEnergy() <= this.setInitialEnergy() * 0.5){
            return drainEnergy(target);
        }else{
            int spell = Rules.getRandomNumber(this.spellBook.size()) - 1;
            return castSpell(target, this.spellBook.get(spell));
        }
    }

    @Override
    public Turn makeAttack(Character target) {
        if(Rules.getRandomNumber(20) >= target.getArmor()){
            int damage = Rules.getRandomNumber(4) + this.getMight();
            target.setHitPoints(target.getHitPoints() - damage);
            return new Turn(this, target, "attacked", damage);
        }else{
            return new Turn(this, target, "missed attack", 0);
        }
    }

    @Override
    public Turn castSpell(Character target, Spell spell) {
        if(Rules.getRandomNumber(20) >= target.getIntelligence()){
            this.setEnergy(this.getEnergy() - spell.getEnergyCost());
            target.setHitPoints(target.getHitPoints() - spell.getDamage());
            return new Turn(this, target, "Cast: " + spell.getName(), spell.getDamage());
        }else{
            return new Turn(this, target, "miss a spell", 0);
        }
    }
}
