package com.company.rooms;

import com.company.character.Character;

public class Turn {
    private int turnNumber;
    private Character source;
    private Character target;
    private String action;
    private int resultOfAction;

    public Turn (int turnNumber, Character source, Character target,String action, int resultOfAction)
    {
        this.turnNumber = turnNumber;
        this.source = source;
        this.source = target;
        this.action = action;
        this.resultOfAction = resultOfAction;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public Character getSource() {
        return source;
    }

    public void setSource(Character source) {
        this.source = source;
    }

    public Character getTarget() {
        return target;
    }

    public void setTarget(Character target) {
        this.target = target;
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
