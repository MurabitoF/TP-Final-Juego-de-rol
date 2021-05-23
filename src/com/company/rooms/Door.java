package com.company.rooms;

public class Door {
    private String direction;
    private Room nextRoom;
    private Room previousRoom;
    private boolean isLocked;
    private String symbol;

    public Door(String direction, Room nextRoom, Room previousRoom, boolean isLocked, String symbol) {
        this.direction = direction;
        this.nextRoom = nextRoom;
        this.previousRoom = previousRoom;
        this.isLocked = isLocked;
        this.symbol = symbol;
    }
}
