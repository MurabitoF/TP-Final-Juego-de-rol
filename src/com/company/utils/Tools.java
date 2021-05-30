package com.company.utils;

import com.company.character.Rogue;
import com.company.character.Spell;
import com.company.character.Warrior;
import com.company.character.Wizard;
import com.company.items.Item;
import com.company.rooms.Room;

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
                System.out.println("\t|=================|\t\t|=================|\t\t|==================|");
                System.out.println("\t|    1.Warrior    |\t\t|     2.Rogue     |\t\t|    3.Wizard      |");
                System.out.println("\t|=================|\t\t|=================|\t\t|==================|");
                System.out.println("\t|    Abilities    |\t\t|    Abilities    |\t\t|     Abilities    |");
                System.out.println("\t|       Rage      |\t\t|       Aim       |\t\t|    Spellcasting  |");
                System.out.println("\t|  Cleave Attack  |\t\t|   Sneak Attack  |\t\t|   Regain Energy  |");
                System.out.println("\t|=================|\t\t|=================|\t\t|==================|");
                System.out.println("\t|      Stats      |\t\t|      Stats      |\t\t|      Stats       |");
                System.out.println("\t|    Might: 10    |\t\t|     Might: 4    |\t\t|     Might: 3     |");
                System.out.println("\t|    Agility: 6   |\t\t|   Agility: 10   |\t\t|    Agility: 7    |");
                System.out.println("\t| Intelligence: 4 |\t\t| Intelligence: 6 |\t\t| Intelligence: 10 |");
                System.out.println("\t|=================|\t\t|=================|\t\t|==================|");
                System.out.println();

                System.out.print(">>> ");
                option = input.nextInt();
                input.nextLine();
            }while (option <1 || option > 3);

            System.out.print("Insert a name for the character: ");
            name = input.nextLine();

            switch (option){
                case 1:
                    new Warrior(name, 10, 6, 4, Arrays.asList(Tools.BASIC_WARRIOR_BACKPACK));
                    break;
                case  2:
                    new Rogue(name, 4, 10, 6, Arrays.asList(Tools.BASIC_ROGUE_BACKPACK));
                    break;

                case 3:
                    new Wizard(name, 10, 6, 4, Arrays.asList(Tools.BASIC_WIZARD_BACKPACK), Arrays.asList(Tools.INITIAL_SPELLBOOK));
                    break;
            }
        }catch (Exception e){
            System.out.println("Insert a valid option");
            characterSelectMenu();
        }
    }

    public static void roomMenu(Room room){

    }
}
