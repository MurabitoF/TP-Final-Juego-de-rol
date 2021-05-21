package com.mygdx.game.core;

public class Turn {
    private int turnNumber;
    private Character character;
    private String action;
    private int resultOfAction;

    public Turn (int turnNumber, Character character, String action, int resultOfAction)
    {
        this.turnNumber = turnNumber;
        this.character = character;
        this.action = action;
        this.resultOfAction = resultOfAction;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getResultOfAction() {
        return resultOfAction;
    }

    public void setResultOfAction(int resultOfAction) {
        this.resultOfAction = resultOfAction;
    }
}
