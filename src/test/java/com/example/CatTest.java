package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CatTest {
    public Feline feline = new Feline();
    public Cat cat = new Cat(feline);

    @Test
    public void getSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        int c = 0;
        List<String> food = cat.getFood();
        List<String> foodExpected = new ArrayList<>();
        foodExpected.add("Животные");
        foodExpected.add("Птицы");
        foodExpected.add("Рыба");

        for (String f : foodExpected) {
            assertEquals(food.get(c), f);
            c++;
        }
    }
}