package com.company.utils;

import com.company.character.*;
import com.company.items.*;
import com.company.rooms.Combat;
import com.company.rooms.Door;
import com.company.rooms.Room;
import com.company.rooms.Turn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {

    public static void waitForKeyboardInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("....");
        input.nextLine();
    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        int option = -1;
        do {
            System.out.println("1. New Game!");
            System.out.println("2. Continue");
            System.out.println("0. Exit");

            try{
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }

        }while (option < 0 || option > 2);

        switch (option){
            case 1:
                characterSelectMenu();
                break;
            case 2:
                Tools.map = Tools.loadGame(Tools.SAVE_FILE);
                if(Tools.map.isEmpty()){
                    System.out.println("There is no saved game");
                }else{
                    Room playerRoom = Tools.findPlayer();
                    if(playerRoom != null){
                        roomMenu(playerRoom);
                    }else {
                        System.out.println("There's a problem with the saving file");
                    }
                }
                break;
            case 0:
                System.exit(0);
        }
    }

    public static void characterSelectMenu(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        String name;

        Tools.map = Tools.loadGame(Tools.INITIAL_MAP_FILE);

        do {
            System.out.println("\t|===================|\t\t|=================|\t\t|==================|");
            System.out.println("\t|     1.Warrior     |\t\t|     2.Rogue     |\t\t|    3.Wizard      |");
            System.out.println("\t|===================|\t\t|=================|\t\t|==================|");
            System.out.println("\t|     Abilities     |\t\t|    Abilities    |\t\t|     Abilities    |");
            System.out.println("\t|        Rage       |\t\t|       Aim       |\t\t|    Spellcasting  |");
            System.out.println("\t|  Reckless Attack  |\t\t|   Sneak Attack  |\t\t|   Regain Energy  |");
            System.out.println("\t|===================|\t\t|=================|\t\t|==================|");
            System.out.println("\t|       Stats       |\t\t|      Stats      |\t\t|      Stats       |");
            System.out.println("\t|     Might: 10     |\t\t|     Might: 4    |\t\t|     Might: 3     |");
            System.out.println("\t|     Agility: 6    |\t\t|   Agility: 10   |\t\t|    Agility: 7    |");
            System.out.println("\t|  Intelligence: 4  |\t\t| Intelligence: 6 |\t\t| Intelligence: 10 |");
            System.out.println("\t|===================|\t\t|=================|\t\t|==================|");
            System.out.println();

            try {
                System.out.print(">>> ");
                option = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }

        }while (option <1 || option > 3);

        System.out.print("Insert a name for the character: ");
        name = input.nextLine();

        System.out.println("\nYou have finally reached it.The Hidden Dungeon of the Java Isles." +
                "\nAs the legend says, in it there is a scroll with the ultimate secret," +
                "\nand this journey only purpose is to obtain it and gain it's knowledge."+
                "\nYou open the first door, made of stone and metal. But with the right words" +
                "\nit moves as if it was made of the lightlest wood." +
                "\nYou descend through the lightless stairs until you reach the first room...");

        switch (option){
            case 1:
                Warrior warrior = new Warrior(name, 10, 6, 4, new ArrayList<>(Arrays.asList(Tools.BASIC_MARTIAL_BACKPACK)));
                warrior.useItem(warrior.getBackpack().get(0),null);
                warrior.useItem(warrior.getBackpack().get(0),null);
                Tools.map.get(0).setPlayer(warrior);
                Tools.saveGame(Tools.SAVE_FILE);
                roomMenu(Tools.map.get(0));
                break;
            case  2:
                Rogue rogue = new Rogue(name, 4, 10, 6, new ArrayList<>(Arrays.asList(Tools.BASIC_MARTIAL_BACKPACK)));
                rogue.useItem(rogue.getBackpack().get(0),null);
                rogue.useItem(rogue.getBackpack().get(0),null);
                Tools.map.get(0).setPlayer(rogue);
                Tools.saveGame(Tools.SAVE_FILE);
                roomMenu(Tools.map.get(0));
                break;
            case 3:
                Wizard wizard = new Wizard(name, 3, 7, 10, new ArrayList<>(Arrays.asList(Tools.BASIC_WIZARD_BACKPACK)), new ArrayList<>(Arrays.asList(Tools.INITIAL_SPELLBOOK)));
                wizard.useItem(wizard.getBackpack().get(0),null);
                wizard.useItem(wizard.getBackpack().get(0),null);
                Tools.map.get(0).setPlayer(wizard);
                Tools.saveGame(Tools.SAVE_FILE);
                roomMenu(Tools.map.get(0));
                break;
        }
    }

    public static void roomMenu(Room room){
        Scanner input = new Scanner(System.in);
        Item selectItem;
        int option = -1;

        room.getCombat().setPlayer(room.getPlayer());
        System.out.println("\n" + room.getDescription());

        while(true) {
            System.out.println("\n" + room.getPlayer().statePlayer());
            System.out.println("1. Take look in the room");
            System.out.println("2. Use a item of the backpack");
            if (!room.getCombat().isOver()){
                System.out.println("3. Get in combat");
            }else {
                if(room.getId() != 10){
                    System.out.println("3. Take loot");
                    System.out.println("4. Exit the room");
                }else{
                    System.out.println("3. Enter in the last room");
                }
            }
            if(room.getPlayer() instanceof Wizard){
                System.out.println("5. Learn spell");
            }
            System.out.println("0. Pause Menu");

            try {
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (Exception e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }

            switch (option){
                case 1:
                    System.out.println(room.getDescription());
                    break;
                case 2:
                     selectItem = selectItem(room.getPlayer());
                    if(selectItem instanceof Weapon || selectItem instanceof Armor || selectItem instanceof HealingPotion || selectItem instanceof EnergyPotion){
                        room.getPlayer().useItem(selectItem,null);
                    }
                    break;
                case 3:
                    if (!room.getCombat().isOver()){
                        room.getCombat().beginCombat();
                        room.setPlayer(room.getCombat().getPlayer());
                        if(room.getPlayer().getHitPoints() <= 0){
                            deadScreen();
                        }
                    }else{
                        if(room.getId() != 10){
                            if(room.getLoot() != null){
                                room.getPlayer().pickupLoot(room.getLoot());
                                System.out.println(room.getPlayer().getName() + " has picked up a " + room.getLoot().getName());
                                room.setLoot(null);
                                waitForKeyboardInput();
                            }else{
                                System.out.println("There's nothing to pick up");
                            }
                        }else{
                            winScreen();
                        }
                    }
                    break;
                case 4:
                    if (room.getCombat().isOver()){
                        Door selectDoor = selectDoorMenu(room);
                        openDoor(selectDoor, room);
                    }
                    break;
                case 5:
                    if(room.getPlayer() instanceof Wizard){
                        selectItem = selectItem(room.getPlayer());
                        if (!(selectItem instanceof Scroll)){
                            if (selectItem != null){
                                System.out.println("You must choose a scroll");
                            }
                        }else{
                            ((Wizard)room.getPlayer()).learnSpell(((Scroll) selectItem).getSpell());
                            room.getPlayer().updateUses((Consumible) selectItem);
                        }
                    }
                    break;
                case  0:
                    pauseMenu();
                    break;
            }
        }
    }

    public static Turn warriorCombatMenu(Combat combat){
        Scanner input = new Scanner(System.in);
        int option = -1;
        Enemy target = null;
        Turn turn = null;

        do {
            System.out.println("1. Make an attack");
            System.out.println("2. Use an item");
            System.out.println("3. Reckless attack");
            System.out.println("4. RAGEEEE!!!");
            System.out.println("0. Pause Menu");

            try{
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }

            if (option == 0){
                pauseMenu();
            }else if(option == 3 && combat.getPlayer().getEnergy() < 10){
                System.out.println(combat.getPlayer().getName() + " doesn't have enough energy to make a reckless attack");
                option = -1;
            }

            switch (option){
                case 1:
                    target = showEnemies(combat);
                    turn = combat.getPlayer().makeAttack(target);
                    break;
                case 2:
                    if(combat.getPlayer().checkConsumibles()){
                        Item selectItem = selectItem(combat.getPlayer());
                        while (!(selectItem instanceof Consumible)){
                            System.out.println("You can't use this item now");
                            selectItem = selectItem(combat.getPlayer());
                        }
                        if (selectItem instanceof Scroll){
                            target = showEnemies(combat);
                        }
                        turn = combat.getPlayer().useItem(selectItem, target);
                    }else{
                        System.out.print("You don't have any consumible on the backpack");
                        waitForKeyboardInput();
                    }
                    break;
                case 3:
                    target = showEnemies(combat);
                    turn = ((Warrior)combat.getPlayer()).recklessAttack(target);
                    break;
                case 4:
                    turn = ((Warrior)combat.getPlayer()).rage();
                    break;
                default:
                    turn = null;
            }
            if (turn == null){
                option = -1;
            }
        }while (option < 1 || option > 4);


        return turn;
    }

    public static Turn rogueCombatMenu(Combat combat){
        Scanner input = new Scanner(System.in);
        int option = -1;
        Enemy target = null;
        Turn turn = null;

        do {
            System.out.println("1. Make an attack");
            System.out.println("2. Use an item");
            System.out.println("3. Aim the next attack");
            System.out.println("4. Sneak attack");
            System.out.println("0. Pause Menu");

            try{
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }

            if(option == 0){
                pauseMenu();
            }else if(option == 4 && combat.getPlayer().getEnergy() < 25){
                System.out.println(combat.getPlayer().getName() + " doesn't have enough energy to make a sneak attack");
                option = -1;
            }
            switch (option){
                case 1:
                    target = showEnemies(combat);
                    turn = combat.getPlayer().makeAttack(target);
                    break;
                case 2:
                    if(combat.getPlayer().checkConsumibles()){
                        Item selectItem = selectItem(combat.getPlayer());
                        while (!(selectItem instanceof Consumible)){
                            System.out.println("You can't use this item now");
                            selectItem = selectItem(combat.getPlayer());
                        }
                        if (selectItem instanceof Scroll){
                            target = showEnemies(combat);
                        }
                        turn = combat.getPlayer().useItem(selectItem, target);
                    }else{
                        System.out.print("You don't have any consumible on the backpack");
                        waitForKeyboardInput();
                    }
                    break;
                case 3:
                    turn = ((Rogue)combat.getPlayer()).aim();
                    break;
                case 4:
                    target = showEnemies(combat);
                    turn = ((Rogue)combat.getPlayer()).sneakAttack(target);
                    break;
                default:
                    turn = null;
            }
            if (turn == null){
                option = -1;
            }
        }while(option < 1 || option > 4);
        return turn;
    }

    public static Turn wizardCombatMenu(Combat combat){
        Scanner input = new Scanner(System.in);
        int option = -1;
        Enemy target = null;
        Turn turn = null;

        do {
            System.out.println("1. Make an attack");
            System.out.println("2. Use an item");
            System.out.println("3. Recover Energy");
            System.out.println("4. Cast Spell");
            System.out.println("0. Pause Menu");

            try{
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }
            if(option == 0){
                pauseMenu();
            }else if(option == 4 && combat.getPlayer().getEnergy() < 10){
                System.out.println(combat.getPlayer().getName() + " doesn't have enough energy to cast an spell");
                option = -1;
            }

            switch (option){
                case 1:
                    target = showEnemies(combat);
                    turn = combat.getPlayer().makeAttack(target);
                    break;
                case 2:
                    if(combat.getPlayer().checkConsumibles()){
                        Item selectItem = selectItem(combat.getPlayer());
                        while (!(selectItem instanceof Consumible)){
                            System.out.println("You can't use this item now");
                            selectItem = selectItem(combat.getPlayer());
                        }
                        if (selectItem instanceof Scroll){
                            target = showEnemies(combat);
                        }
                        turn = combat.getPlayer().useItem(selectItem, target);
                    }else{
                        System.out.print("You don't have any consumible on the backpack");
                        waitForKeyboardInput();
                    }
                    break;
                case 3:
                    turn = ((Wizard)combat.getPlayer()).recoverEnergy();
                    break;
                case 4:
                    target = showEnemies(combat);
                    Spell selectSpell = selectSpellMenu((Wizard)combat.getPlayer());
                    turn = ((Wizard)combat.getPlayer()).castSpell(target, selectSpell);
                    break;
                default:
                    turn = null;
            }
            if(turn == null){
                option = -1;
            }
        }while (option < 1 || option > 4);

        return turn;
    }

    public static Enemy showEnemies(Combat combat){
        Scanner input = new Scanner(System.in);
        int option = -1;

        for (int i = 0; i<combat.getEnemies().size(); i++){
            if(combat.getEnemies().get(i).getHitPoints() >= 0){
                System.out.println("[" + i + "]" + " " + combat.getEnemies().get(i).getName());
            }
        }

        do {
            try {
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }
        }while (option < 0 || option > combat.getEnemies().size());

        return combat.getEnemies().get(option);
    }

    public static Spell selectSpellMenu(Wizard player){
        Scanner input = new Scanner(System.in);
        int option = -1;

        for (int i = 0; i < player.getSpellBook().size(); i++){
            System.out.println("[" + i + "]" + " " + player.getSpellBook().get(i).getName());
        }

        do {
            try {
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }
        }while (option < 0 || option > player.getSpellBook().size());

        return player.getSpellBook().get(option);
    }

    public static Door selectDoorMenu(Room room){
        Scanner input = new Scanner(System.in);
        int option = -1;

        for (int i = 0; i < room.getDoors().size(); i++){
            System.out.println("[" + i + "]" + " " + room.getDoors().get(i).getDirection());
        }

        do {
            try {
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }
        }while (option < 0 || option > room.getDoors().size());

        return room.getDoors().get(option);
    }

    public static Item selectItem(Player player){
        Scanner input = new Scanner(System.in);
        int option = -1;

        for (int i = 0; i < player.getBackpack().size(); i++){
            System.out.println("[" + i + "] " + player.getBackpack().get(i));
        }

        System.out.println("[" + player.getBackpack().size() + "] Back to menu");

        do {
            try {
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }
        }while (option < 0 || option > player.getBackpack().size());

        if(option < player.getBackpack().size()) {
            return player.getBackpack().get(option);
        }else{
            return null;
        }
    }

    public static void pauseMenu(){
        Scanner input = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("1. Save game");
            System.out.println("2. Back to game");
            System.out.println("3. Exit");

            try{
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }

            switch (option){
                case 1:
                    Tools.saveGame(Tools.SAVE_FILE);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }while (option != 2);
    }

    public static void openDoor(Door door, Room room){
        Scanner input = new Scanner(System.in);
        int option = -1;

        System.out.println("You're standing in front of the " + door.getDirection() + " door");

        do{
            System.out.println("1. Open door");
            if(door.isLocked()){
                System.out.println("2. Use a key");
            }
            System.out.println("3. Back to room");

            try{
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }

            switch (option){
                case 1:
                    if(door.isLocked()){
                        System.out.println("The door has a inscription: \"privado es privado\"");
                        System.out.println("You tink it says the door is locked, you should use a key to open it");
                        waitForKeyboardInput();
                    }else{
                        room.openDoor(door);
                        Room nextRoom = Tools.findRoomById(door.getNextRoomId());
                        roomMenu(nextRoom);
                    }
                    break;
                case 2:
                   if(door.isLocked()){
                       Item key = selectItem(room.getPlayer());
                       if (key instanceof Key && ((Key) key).getSymbol().equals(door.getSymbol())){
                           door.setLocked(false);
                       }else {
                           System.out.println("You can't use this on the door");
                           waitForKeyboardInput();
                       }
                   }
                    break;
            }
        }while(option != 3);
    }

    public static void deadScreen(){
        Scanner input = new Scanner(System.in);
        int option = -1;
        System.out.println("You are dead!");
        waitForKeyboardInput();
        do {
            System.out.println("1. Load game");
            System.out.println("2. Exit game");

            try {
                System.out.println();
                System.out.print(">>> ");
                option = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println(Tools.INPUT_ERROR);
                input.nextLine();
            }
        }while (option < 1 || option > 2);

        switch (option){
            case 1:
                Tools.loadGame(Tools.SAVE_FILE);
                Room playerRoom = Tools.findPlayer();
                if(playerRoom != null){
                    roomMenu(playerRoom);
                }else {
                    System.out.println("There's a problem with the saving file");
                }
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

    public static void winScreen(){
        System.out.print("You enter the last room and see a pedestal in the center of the room");
        waitForKeyboardInput();
        System.out.println("\n\n");
        System.out.print("when you get closer you can see a parchment on top of it");
        waitForKeyboardInput();
        System.out.println("\n\n");
        System.out.print("as you read it, you realize that it is written in a language you do not understand, says");
        waitForKeyboardInput();
        System.out.println("\n\n");
        System.out.println("\"A donde va el padre va el hijo\"");
        System.exit(0);
    }

}


