package com.company.rooms;

import com.company.character.Enemy;
import com.company.character.Player;
import com.company.character.Rogue;
import com.company.character.Warrior;
import com.company.utils.Menu;
import com.company.utils.Tools;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
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

    public boolean isOver(){ //Se fija si la lista de enemigos esta vacia, en ese caso devuelve verdadero
        if (player.getHitPoints()<=0)
        {
            return true;
        }else
        {
            return enemies.isEmpty();
        }

    }

    public void beginCombat(){
        Iterator<Enemy> enemyIterator = this.enemies.iterator();
        while (!isOver()) {
            while(enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();
                turns.add(playerAction()); //agregar mostrar turno tras acción
                if (enemy.getHitPoints() <= 0) {
                    System.out.println(enemy.getName() + " ha muerto.");
                    enemyIterator.remove();
                    deleteEnemy(enemy);
                } else {
                    turns.add(enemy.makeAction(player));
                }
            }
        }
    }

    private void deleteEnemy(Enemy enemy){
        enemies.remove(enemy);
    }

    private Turn playerAction(){
        if(player instanceof Warrior){
            return Menu.warriorCombatMenu(this);
        }else if(player instanceof Rogue){
            return Menu.rogueCombatMenu(this);
        }else {
            return Menu.wizardCombatMenu(this);
        }
    }

    /*private List<Character> rollInitiative()
    {
        List<Character> initiative = new ArrayList<>();
        initiative.add(0,this.player);
        for (Enemy enemy : this.enemies)
        {
            for(Character init : initiative)
            {
                if (init.getAgility>enemy.getAgility())
                {
                        initiative.add(enemy);
                } else
                {
                    initiative.add(initiative.indexOf(init), enemy);
                }
            }

        }
    }*/  //{monstruo(7), jugador(6), Soldado(6)}

}
