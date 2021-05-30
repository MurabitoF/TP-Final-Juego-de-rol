package com.company.rooms;

import com.company.character.Enemy;
import com.company.character.Player;

import java.util.ArrayList;
import java.util.List;

public class Combat {
    private Player player;
    private List<Enemy> enemies;
    private List<Turn> turns;

    public Combat (Player player, List<Enemy> enemies)
    {
        this.player = player;
        this.enemies = enemies;
        this.turns = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public boolean isOver(){
        return false;//cambiar
    }

}
