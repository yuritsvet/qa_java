package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() throws Exception {
        return getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood(Feline feline) throws Exception {
        //Feline feline = new Feline();
        return feline.getFood("Хищник");
    }
}