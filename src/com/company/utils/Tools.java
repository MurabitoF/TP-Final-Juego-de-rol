package com.company.utils;

import com.company.character.*;
import com.company.items.*;
import com.company.rooms.Door;
import com.company.rooms.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.company.items.Armor;
import com.company.items.HealingPotion;
import com.company.items.Item;
import com.company.items.Weapon;


public abstract class Tools {

    public static final String INPUT_ERROR = "Insert a valid option";

    public static final String SAVE_FILE = "src/com/company/saves/save.json";
    public static final String INITIAL_MAP_FILE = "src/com/company/saves/initialMap.json";

    public static final Spell[] SPELL_LIST = {new Spell("Magic Missile", 10, 4),
            new Spell("Fire Bolt", 10,4),
            new Spell("Acid Orb", 15,6),
            new Spell("Shocking Grasp", 15,6),
            new Spell("Necrotic Ray", 25, 8),
            new Spell("Ray of Frost", 25, 8),
            new Spell("Radiant Flame", 30, 10)};

    public static final Item[] BASIC_MARTIAL_BACKPACK = {new Armor("Studded Leather", 2), new Weapon("Short Sword", 1,1,6), new HealingPotion("Healing Potion",3,"Small",5)};
    public static final Item[] BASIC_WIZARD_BACKPACK = {new Armor("Leather", 1), new Weapon("Dagger", 1,1,4), new HealingPotion("Healing Potion",3,"Small",5)};
    public static final Spell[] INITIAL_SPELLBOOK = {SPELL_LIST[0], SPELL_LIST[2]};

    public static List<Room> map = new ArrayList<>();

    public static int getRandomNumber(int limit) {
        return (int) Math.floor(Math.random() * limit + 1);
    }

    public static void saveGame(String filePath) {
        File saveFile = new File(filePath);

        try {
            GsonBuilder builder = new GsonBuilder().serializeNulls().setPrettyPrinting();
            new GraphAdapterBuilder().addType(Room.class).registerOn(builder);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saveFile));
            Gson gson = builder.create();
            bufferedWriter.write(gson.toJson(map));
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Error while saving the file");
        }
    }

    public static List<Room> loadGame(String filePath){
        File loadFile = new File(filePath);
        List<Room> loadMap = new ArrayList<>();

        if(loadFile.exists()){
            try{
                RuntimeTypeAdapterFactory<Player> playerFactory = RuntimeTypeAdapterFactory
                        .of(Player.class, "type", true)
                        .registerSubtype(Warrior.class, "Warrior")
                        .registerSubtype(Rogue.class, "Rogue")
                        .registerSubtype(Wizard.class, "Wizard");

                RuntimeTypeAdapterFactory<Item> itemFactory = RuntimeTypeAdapterFactory
                        .of(Item.class, "type", true)
                        .registerSubtype(Weapon.class, "Weapon")
                        .registerSubtype(Armor.class, "Armor")
                        .registerSubtype(Key.class, "Key")
                        .registerSubtype(HealingPotion.class,"HealingPotion")
                        .registerSubtype(EnergyPotion.class, "EnergyPotion")
                        .registerSubtype(Scroll.class, "Scroll");

                RuntimeTypeAdapterFactory<Enemy> enemyFactory = RuntimeTypeAdapterFactory
                        .of(Enemy.class, "type", true)
                        .registerSubtype(Soldier.class, "Soldier")
                        .registerSubtype(Monster.class, "Monster")
                        .registerSubtype(Mage.class, "Mage");


                GsonBuilder builder = new GsonBuilder().setPrettyPrinting()
                        .registerTypeAdapterFactory(playerFactory)
                        .registerTypeAdapterFactory(itemFactory)
                        .registerTypeAdapterFactory(enemyFactory);

                new GraphAdapterBuilder().addType(Room.class).registerOn(builder);

                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                Gson gson = builder.create();

                loadMap = gson.fromJson(bufferedReader, new TypeToken<List<Room>>() {}.getType());
                bufferedReader.close();
            }catch (IOException e){
                System.out.println("Error while loading the file");
            }
        }
        return loadMap;
    }

    public static Room findPlayer() {
        for (Room room : map) {
            if(room.getPlayer() != null){
                return room;
            }
        }
        return null;
    }

}