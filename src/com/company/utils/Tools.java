package com.company.utils;

import com.company.character.*;
import com.company.items.Item;

public class Tools {

    public static final String ERROR_MESSAGE = "Insert a valid option";

    public static final Item[] BASIC_WARRIOR_BACKPACK = {};
    public static final Item[] BASIC_ROGUE_BACKPACK = {};
    public static final Item[] BASIC_WIZARD_BACKPACK = {};
    public static final Spell[] INITIAL_SPELLBOOK = {};

    public static int getRandomNumber(int limit) {
        return (int) Math.floor(Math.random() * limit + 1);
    }

}