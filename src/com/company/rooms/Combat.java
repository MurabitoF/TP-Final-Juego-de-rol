package com.company.rooms;

import com.company.character.Enemy;
import com.company.character.Player;

import java.util.ArrayList;
import java.util.List;

public class Combat {
    private Player player;
    private List<Enemy> enemies;
    private List<Turn> turns;

    public Combat (Player player, List<Enemy> enemies, List<Turn> turns)
    {
        this.player = player;
        this.enemies = enemies;
        this.turns = turns;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemy() {
        return enemies;
    }

    public void setEnemy(List<Enemy> enemy) {
        this.enemies = enemy;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public boolean isOver(){ //Se fija si la lista de enemigos esta vacia, en ese caso devuelve verdadero
        return enemies.isEmpty();
    }

    public void beginCombat(){
        while (isOver() == false) {
            for (Enemy enemy : enemies) {
                turns.add(player.makeAttack(enemy)); // Temporal. Acá debería ir el menu de acciones del jugador
                if (enemy.getHitPoints() <= 0) {
                    deleteEnemy(enemy);
                } else {
                    enemy.makeAction(player);
                }
            }
        }
    }

    private void deleteEnemy(Enemy enemy){
        enemies.remove(enemy);
    }

}
