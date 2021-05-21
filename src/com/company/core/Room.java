package com.company.core;

import java.util.ArrayList;

public class Room {
    String name;
    Item loot;
    Player player;
    Combat combat;

    public Room (String name, Item loot, Player player, Combat combat)
    {
        this.name = name;
        this.loot = loot;
        this.player = player;
        this.combat = combat;
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
}
