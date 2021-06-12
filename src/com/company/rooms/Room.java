package com.company.rooms;

import com.company.character.Player;
import com.company.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Room {
    private int id;
    private String description;
    private Item loot;
    private Player player;
    private Combat combat;
    private List<Door> doors;

    public Room (int id, String description, Item loot, Player player, Combat combat)
    {
        this.id = id;
        this.description = description;
        this.loot = loot;
        this.player = player;
        this.combat = combat;
        this.doors = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void openDoor(Door choseDoor){
       choseDoor.getNextRoom().setPlayer(this.player);
       this.player = null;
    }

    //hacer toString
}
