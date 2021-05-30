package com.company.rooms;

public class Door {
    private String direction;
    private Room nextRoom;
    private boolean isLocked;
    private String symbol;

    public Door(String direction, Room nextRoom, boolean isLocked, String symbol) {
        this.direction = direction;
        this.nextRoom = nextRoom;
        this.isLocked = isLocked;
        this.symbol = symbol;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
