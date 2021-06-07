package com.company.utils;

import com.company.character.*;
import com.company.items.*;
import com.company.rooms.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Tools {

    public static final String INPUT_ERROR = "Insert a valid option";

    public static final String SAVE_FILE = "src/com/company/save.json";
    public static final String INITIAL_MAP_FILE = "src/com/company/initialMap.json";

    public static final Item[] BASIC_WARRIOR_BACKPACK = {};
    public static final Item[] BASIC_ROGUE_BACKPACK = {};
    public static final Item[] BASIC_WIZARD_BACKPACK = {};
    public static final Spell[] INITIAL_SPELLBOOK = {};

    public static List<Room> map = new ArrayList<>();

    public static int getRandomNumber(int limit) {
        return (int) Math.floor(Math.random() * limit + 1);
    }

    public static void saveGame(String filePath) {
        File saveFile = new File(filePath);

        try {
            GsonBuilder builder = new GsonBuilder().serializeNulls().setPrettyPrinting();
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
                        .of(Player.class, "type")
                        .registerSubtype(Warrior.class, "Warrior")
                        .registerSubtype(Rogue.class, "Rogue")
                        .registerSubtype(Wizard.class, "Wizard");

                RuntimeTypeAdapterFactory<Item> itemFactory = RuntimeTypeAdapterFactory
                        .of(Item.class, "type")
                        .registerSubtype(Weapon.class, "Weapon")
                        .registerSubtype(Armor.class, "Armor")
                        .registerSubtype(Key.class, "Key")
                        .registerSubtype(HealingPotion.class,"HealingPotion")
                        .registerSubtype(EnergyPotion.class, "EnergyPotion")
                        .registerSubtype(Scroll.class, "Scroll");

                RuntimeTypeAdapterFactory<Enemy> enemyFactory = RuntimeTypeAdapterFactory
                        .of(Enemy.class, "type")
                        .registerSubtype(Soldier.class, "Soldier")
                        .registerSubtype(Monster.class, "Monster")
                        .registerSubtype(Mage.class, "Mage");


                GsonBuilder builder = new GsonBuilder().setPrettyPrinting()
                        .registerTypeAdapterFactory(playerFactory)
                        .registerTypeAdapterFactory(itemFactory)
                        .registerTypeAdapterFactory(enemyFactory);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(loadFile));
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