package com.company.rooms;

import com.company.character.Player;
import com.company.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private Item loot;
    private Player player;
    private Combat combat;
    private List<Door> doors;

    public Room (String name, Item loot, Player player, Combat combat)
    {
        this.name = name;
        this.loot = loot;
        this.player = player;
        this.combat = combat;
        this.doors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getLoot() {
        return loot;
    }

    public void setLoot(Item loot) {
        this.loot = loot;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Combat getCombat() {
        return combat;
    }

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public void openDoor(){

    }
}
