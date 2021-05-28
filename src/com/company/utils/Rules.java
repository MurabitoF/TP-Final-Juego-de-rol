package com.company.utils;

public class Rules {

    public static int getRandomNumber(int limit){
        return (int)Math.floor(Math.random()*limit + 1);
    }

}
