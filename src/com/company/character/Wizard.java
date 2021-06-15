package com.company.character;

import com.company.items.Item;
import com.company.rooms.Turn;
import com.company.utils.Tools;


import java.util.List;

public class Wizard extends Player implements IMagic{
    private List<Spell> spellBook;

    public Wizard (String name, int might, int agility, int intelligence, List<Item> backpack, List<Spell> spellBook)
    {
        super(name, might, agility, intelligence, "Wizard", backpack);
        this.spellBook = spellBook;
    }

    public List<Spell> getSpellBook() {
        return spellBook;
    }

    public void setSpellBook(List<Spell> spellBook) {
        this.spellBook = spellBook;
    }

    public Turn recoverEnergy(){
            if (this.setMaxEnergy()>=this.getEnergy() + this.getIntelligence()*2)
            {
                this.setEnergy(this.getEnergy() + this.getIntelligence()*2);
                return new Turn(this, this, "Recovered energy", this.getIntelligence()*2);
            }else
            {
                this.setEnergy(setMaxEnergy());
                return new Turn(this, this, "Maxed out energy", this.getEnergy());
            }
        }

    public void learnSpell (Spell spell)
    {
        this.spellBook.add(spell);
    }

    @Override
    public int getArmor() {
        return 5 + this.getAgility() + this.getEquippedArmor().getArmorBonus();
    }

    @Override
    public Turn makeAttack(Character target) {

        if (Tools.getRandomNumber(20) + this.getAgility() + getEquippedWeapon().getAttackBonus() >= target.getArmor())
        {
            int damage = Tools.getRandomNumber(this.getEquippedWeapon().getDamageDice()) + this.getMight();
            target.setHitPoints(target.getHitPoints() - damage);
            return new Turn(this, target, " attacked ", damage);
        } else{
            return new Turn(this, target, " missed ", 0);
        }
    }

    @Override
    public Turn castSpell(Character target, Spell spell) {
        if (this.getEnergy()>=10 && Tools.getRandomNumber(20)+this.getIntelligence() > Tools.getRandomNumber(20)+ target.getIntelligence())
        {
            this.setEnergy(this.getEnergy()-spell.getEnergyCost());
            target.setHitPoints(target.getHitPoints() - spell.getDamage() - this.getIntelligence());
            return new Turn (this, target, " casted " + spell.getName(), spell.getDamage()+this.getIntelligence());
        }else {
            return new Turn (this, target, " missed a spell ", 0);
        }
    }

    @Override
    public String statePlayerInCombat(){
        String player = this.getName() + "\n";
        player = player + "HP: " + this.getHitPoints() + "\t Energy: " + this.getEnergy() + "\n";
        return player;
    }
}
