package com.company.utils;

import com.company.character.*;
import com.company.items.Armor;
import com.company.items.HealingPotion;
import com.company.items.Item;
import com.company.items.Weapon;

public abstract class Tools {

    public static final String ERROR_MESSAGE = "Insert a valid option";

    //agregar lista de items y lista de spells
    public static final Spell[] SPELL_LIST = {new Spell("Magic Missile", 10, 4), new Spell("Fire Bolt", 10,4), new Spell("Acid Orb", 15,6), new Spell("Shocking Grasp", 15,6), new Spell("Necrotic Ray", 25, 8), new Spell("Ray of Frost", 25, 8), new Spell("Radiant Flame", 30, 10)};

    public static final Item[] BASIC_MARTIAL_BACKPACK = {new Armor("Studded Leather", 2), new Weapon("Short Sword", 1,1,6), new HealingPotion("Healing Potion",3,"Small",5)};
    public static final Item[] BASIC_WIZARD_BACKPACK = {new Armor("Leather", 1), new Weapon("Dagger", 1,1,4), new HealingPotion("Healing Potion",3,"Small",5)};
    public static final Spell[] INITIAL_SPELLBOOK = {SPELL_LIST[0], SPELL_LIST[2]};

    public static int getRandomNumber(int limit) {
        return (int) Math.floor(Math.random() * limit + 1);
    }

}