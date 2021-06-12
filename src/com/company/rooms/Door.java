package com.company.rooms;

public class Door {
    private String direction;
    private int nextRoomId;
    private boolean isLocked;
    private String symbol;

    public Door(String direction, int nextRoomId, boolean isLocked, String symbol) {
        this.direction = direction;
        this.nextRoomId = nextRoomId;
        this.isLocked = isLocked;
        this.symbol = symbol;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getNextRoomId() {
        return nextRoomId;
    }

    public void setNextRoom(int nextRoomId) {
        this.nextRoomId = nextRoomId;
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
