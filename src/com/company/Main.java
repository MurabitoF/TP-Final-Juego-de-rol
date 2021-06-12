package com.company;

import com.company.character.Enemy;
import com.company.character.Mage;
import com.company.character.Monster;
import com.company.character.Soldier;
import com.company.items.*;
import com.company.rooms.Combat;
import com.company.rooms.Door;
import com.company.rooms.Room;
import com.company.utils.Menu;
import com.company.utils.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu.mainMenu();
        /*Soldier soldier = new Soldier("Soldier", 5, 3, 2);
        Mage mage = new Mage("Mage", 4, 3, 5, Arrays.asList(Tools.INITIAL_SPELLBOOK));
        Monster monster = new Monster("Monster", 4, 5, 2);
        Monster boss = new Monster("BBEG", 7, 5, 4);

        EnergyPotion energyPotionSmall = new EnergyPotion("Energy potion", 3, "Small", 10);
        Scroll scrollNecroticRay = new Scroll("Scroll of Necrotic Ray", Tools.SPELL_LIST[4]);
        Armor armor = new Armor("Hide armor", 3);
        Weapon warAxe = new Weapon("War Axe", 2, 2, 10);
        HealingPotion bigHealigPotion = new HealingPotion("Potion of healing", 5, "Big", 15);
        Scroll scrollRadiantFlame = new Scroll("Scroll of Radiant Flame", Tools.SPELL_LIST[6]);

        Key keySquare = new Key("Square key", "Square");
        Key keyTriangle = new Key("Triangle key", "Triangle");
        Key keyCircle = new Key("Circle key", "Circle");

        List<Enemy> enemies1 = new ArrayList<>();
        enemies1.add(soldier);
        List<Enemy> enemies2 = new ArrayList<>();
        enemies2.add(mage);
        List<Enemy> enemies3 = new ArrayList<>();
        enemies3.add(monster);
        List<Enemy> enemies4 = new ArrayList<>();
        enemies4.add(soldier);
        enemies4.add(mage);
        List<Enemy> enemies5 = new ArrayList<>();
        enemies5.add(soldier);
        enemies5.add(soldier);
        List<Enemy> enemies7 = new ArrayList<>();
        enemies7.add(soldier);
        enemies7.add(mage);
        enemies7.add(mage);
        List<Enemy> enemies8 = new ArrayList<>();
        enemies8.add(mage);
        enemies8.add(mage);
        List<Enemy> enemies10 = new ArrayList<>();
        enemies10.add(boss);

        Combat combat1 = new Combat(null, enemies1);
        Combat combat2 = new Combat(null, enemies2);
        Combat combat3 = new Combat(null, enemies3);
        Combat combat4 = new Combat(null, enemies4);
        Combat combat5 = new Combat(null, enemies5);
        Combat combat6 = new Combat(null, enemies3);
        Combat combat7 = new Combat(null, enemies7);
        Combat combat8 = new Combat(null, enemies8);
        Combat combat9 = new Combat(null, enemies4);
        Combat combat10 = new Combat(null, enemies10);

        Room room1 = new Room(1, "", energyPotionSmall, null, combat1);
        Room room2 = new Room(2, "", scrollNecroticRay, null, combat2);
        Room room3 = new Room(3, "", keySquare, null, combat3);
        Room room4 = new Room(4, "", armor, null, combat4);
        Room room5 = new Room(5, "", warAxe, null, combat5);
        Room room6 = new Room(6, "", bigHealigPotion, null, combat6);
        Room room7 = new Room(7, "", scrollRadiantFlame, null, combat7);
        Room room8 = new Room(8, "", keyTriangle, null, combat8);
        Room room9 = new Room(9, "",keyCircle, null, combat9);
        Room room10 = new Room(10, "", null, null, combat10);

        //sala1
        Door door1 = new Door("Front", 2, false, "none");
        List<Door> doors1 = new ArrayList<>();
        doors1.add(door1);

        //sala2
        Door door2 = new Door("Front", 4, true, "Square");
        Door door3 = new Door("Left", 3, false, "none");
        Door door4 = new Door("Back", 1, false, "none");
        List<Door> doors2 = new ArrayList<>();
        doors2.add(door2);
        doors2.add(door3);
        doors2.add(door4);

        //sala3
        Door door5 = new Door("Back", 2, false, "none");
        List<Door> doors3 = new ArrayList<>();
        doors3.add(door5);

        //sala4
        Door door6 = new Door("Right", 5, false, "none");
        Door door7 = new Door("Back", 2, false, "none");
        List<Door> doors4 = new ArrayList<>();
        doors4.add(door6);
        doors4.add(door7);

        //sala5
        Door door8 = new Door("Front", 6, false, "none");
        Door door9 = new Door("Back", 4, false, "none");
        List<Door> doors5 = new ArrayList<>();
        doors5.add(door8);
        doors5.add(door9);

        //sala6
        Door door10 = new Door("Front", 7, false, "none");
        Door door11 = new Door("Back", 5, false, "none");
        List<Door> doors6 = new ArrayList<>();
        doors6.add(door10);
        doors6.add(door11);

        //sala7
        Door door12 = new Door("Front", 10, true, "Circle");
        Door door13 = new Door("Right", 9, true, "Triangle");
        Door door14 = new Door("Left", 8, false, "none");
        Door door15 = new Door("Back", 6, false, "none");
        List<Door> doors7 = new ArrayList<>();
        doors7.add(door12);
        doors7.add(door13);
        doors7.add(door14);
        doors7.add(door15);

        //sala 8
        Door door16 = new Door("Back", 7, false, "none");
        List<Door> doors8 = new ArrayList<>();
        doors8.add(door16);

        //sala 9
        Door door17 = new Door("Back", 7, false, "none");
        List<Door> doors9 = new ArrayList<>();
        doors9.add(door17);

        //sala 10
        Door door18 = new Door("Back", 7, false, "none");
        List<Door> doors10 = new ArrayList<>();
        doors10.add(door18);

        room1.setDoors(doors1);
        room2.setDoors(doors2);
        room3.setDoors(doors3);
        room4.setDoors(doors4);
        room5.setDoors(doors5);
        room6.setDoors(doors6);
        room7.setDoors(doors7);
        room8.setDoors(doors8);
        room9.setDoors(doors9);
        room10.setDoors(doors10);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);
        rooms.add(room9);
        rooms.add(room10);

        Tools.map = rooms;

        Tools.saveGame(Tools.INITIAL_MAP_FILE);*/

        /*Tools.map = Tools.loadGame(Tools.SAVE_FILE);

        System.out.println(Tools.findPlayer().getPlayer());*/
    }
}
