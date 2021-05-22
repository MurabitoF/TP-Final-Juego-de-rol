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
}
