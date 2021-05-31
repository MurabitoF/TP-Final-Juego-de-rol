package com.company.utils;

import com.company.character.*;
import com.company.items.Item;
import com.company.rooms.Combat;
import com.company.rooms.Door;
import com.company.rooms.Room;
import com.company.rooms.Turn;

import java.util.Arrays;
import java.util.Scanner;

public class Tools {

    public static final Item[] BASIC_WARRIOR_BACKPACK = {};
    public static final Item[] BASIC_ROGUE_BACKPACK = {};
    public static final Item[] BASIC_WIZARD_BACKPACK = {};
    public static final Spell[] INITIAL_SPELLBOOK = {};

    public static int getRandomNumber(int limit){
        return (int)Math.floor(Math.random()*limit + 1);
    }

    public static void clearScreen() {
        for(int i = 0; i <= 50; i++){
            System.out.println();
        }
    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. New Game!");
            System.out.println("2. Continue");
            System.out.println("0. Exit");
            System.out.println();

            System.out.print(">>> ");
            option = input.nextInt();

            switch (option){
                case 1:
                    characterSelectMenu();
                    break;
                case 2:
                    //load function
                    break;
                case 0:
                    System.exit(0);
            }
        }while (option != 0);
    }


    public static void characterSelectMenu(){
        Scanner input = new Scanner(System.in);
        int option;
        String name;

        //clearScreen();
        try {
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

                System.out.print(">>> ");
                option = input.nextInt();
                input.nextLine();
            }while (option <1 || option > 3);

            System.out.print("Insert a name for the character: ");
            name = input.nextLine();

            System.out.println("Texto de inicio del dungeon ");

            switch (option){
                case 1:
                    new Warrior(name, 10, 6, 4, Arrays.asList(Tools.BASIC_WARRIOR_BACKPACK));
                    break;
                case  2:
                    new Rogue(name, 4, 10, 6, Arrays.asList(Tools.BASIC_ROGUE_BACKPACK));
                    break;

                case 3:
                    new Wizard(name, 3, 7, 10, Arrays.asList(Tools.BASIC_WIZARD_BACKPACK), Arrays.asList(Tools.INITIAL_SPELLBOOK));
                    break;
            }
        }catch (Exception e){
            System.out.println("Insert a valid option");
            characterSelectMenu();
        }
    }

    public static void roomMenu(Room room){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("1. Take look in the room");
        System.out.println("2. Use a item of the backpack");
        if (!room.getCombat().isOver()){
            System.out.println("3. Get in combat");
        }else {
            System.out.println("3. Take loot");
            System.out.println("4. Exit the room");
        }
        System.out.println("0. Pause Menu");

        System.out.print(">>> ");
        option = input.nextInt();

        switch (option){
            case 1:
                System.out.println(room.getDescription());
                break;
            case 2:
                //buscar en la mochila
                break;
            case 3:
                //esto no va aca va en el combate, aca va la funcion que inicia el combate
                if (!room.getCombat().isOver()){
                    if(room.getPlayer() instanceof Warrior){
                        warriorCombatMenu(room.getCombat());
                    }else if(room.getPlayer() instanceof Rogue){
                        rogueCombatMenu(room.getCombat());
                    }else {
                        wizardCombatMenu(room.getCombat());
                    }
                }else{
                    //funcion agarrar loot
                }
                break;
            case 4:
                if (room.getCombat().isOver()){
                    Door selectDoor = selectDoorMenu(room);
                    room.openDoor(selectDoor);
                    roomMenu(selectDoor.getNextRoom());
                }
                break;
            case  0:
                pauseMenu();
                break;
        }
    }

    public static Turn warriorCombatMenu(Combat combat){
        Scanner input = new Scanner(System.in);
        int option;
        Enemy target;

        System.out.println("1. Make an attack");
        System.out.println("2. Use an item");
        System.out.println("3. Reckless attack");
        System.out.println("4. RAGEEEE!!!");
        System.out.println("0. Pause Menu");
        System.out.println();
        System.out.print(">>>");
        option = input.nextInt();

        switch (option){
            case 1:
                target = showEnemies(combat);
                return combat.getPlayer().makeAttack(target);
                break;
            case 2:
                //use item
                break;
            case 3:
                target = showEnemies(combat);
                //return ((Warrior)combat.getPlayer()).cleaveAttack(target);
                break;
            case 4:
                //return ((Warrior)combat.getPlayer()).rage();
                break;
            case 0:
                pauseMenu();
                break;
        }
    }

    public static Turn rogueCombatMenu(Combat combat){
        Scanner input = new Scanner(System.in);
        int option;
        Enemy target;

        System.out.println("1. Make an attack");
        System.out.println("2. Use an item");
        System.out.println("3. Aim the next attack");
        System.out.println("4. Sneak attack");
        System.out.println("0. Pause Menu");
        System.out.println();
        System.out.print(">>>");
        option = input.nextInt();

        switch (option){
            case 1:
                target = showEnemies(combat);
                return combat.getPlayer().makeAttack(target);
            break;
            case 2:
                //use item
                break;
            case 3:
                //return ((Rogue)combat.getPlayer()).hide();
                break;
            case 4:
                target = showEnemies(combat);
                //return ((Rogue)combat.getPlayer()).sneakAttack(target);
                break;
            case 0:
                pauseMenu();
                break;
        }
    }

    public static Turn wizardCombatMenu(Combat combat){
        Scanner input = new Scanner(System.in);
        int option;
        Enemy target;

        System.out.println("1. Make an attack");
        System.out.println("2. Use an item");
        System.out.println("3. Recover Energy");
        System.out.println("4. Cast Spell");
        System.out.println("0. Pause Menu");
        System.out.println();
        System.out.print(">>>");
        option = input.nextInt();

        switch (option){
            case 1:
                target = showEnemies(combat);
                return combat.getPlayer().makeAttack(target);
            break;
            case 2:
                //use item
                break;
            case 3:

                //return ((Wizard)combat.getPlayer()).recoverEnergy;
                break;
            case 4:
                target = showEnemies(combat);
                Spell selectSpell = selectSpellMenu((Wizard)combat.getPlayer());
                //return ((Wizard)combat.getPlayer()).castSpell(target, selectedSpell);
                break;
            case 0:
                pauseMenu();
                break;
        }
    }

    public static Enemy showEnemies(Combat combat){
        Scanner input = new Scanner(System.in);
        int option;

        for (int i = 0; i<combat.getEnemies().size(); i++){
            System.out.println("[" + i + "]" + " " + combat.getEnemies().get(i).getName());
        }
        System.out.println();
        System.out.print(">>> ");
        option = input.nextInt();

        return combat.getEnemies().get(option);
    }

    public static Spell selectSpellMenu(Wizard player){
        Scanner input = new Scanner(System.in);
        int option;

        for (int i = 0; i<player.getSpellBook().size(); i++){
            System.out.println("[" + i + "]" + " " + player.getSpellBook().get(i).getName());
        }
        System.out.println();
        System.out.print(">>> ");
        option = input.nextInt();

        return player.getSpellBook().get(option);
    }

    public static Door selectDoorMenu(Room room){
        Scanner input = new Scanner(System.in);
        int option;

        for (int i = 0; i<room.getDoors().size(); i++){
            System.out.println("[" + i + "]" + " " + room.getDoors().get(i).getDirection());
        }
        System.out.println();
        System.out.print(">>> ");
        option = input.nextInt();

        return room.getDoors().get(option);
    }

    public static void pauseMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Save game");
            System.out.println("2. Back to game");
            System.out.println("3. Exit");

            System.out.print(">>> ");
            option = input.nextInt();

            switch (option){
                case 1:
                    //save game
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }while (option != 2);
    }
}
