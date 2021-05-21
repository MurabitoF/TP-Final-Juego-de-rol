package com.company.core;

import java.util.ArrayList;

public class Combat {
    private Player player;
    private Enemy enemy;
    private ArrayList<Turn> turns;

    public Combat (Player player, Enemy enemy)
    {
        this.player = player;
        this.enemy = enemy;
        this.turns = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public ArrayList<Turn> getTurns() {
        return turns;
    }

    public void setTurns(ArrayList<Turn> turns) {
        this.turns = turns;
    }

}
