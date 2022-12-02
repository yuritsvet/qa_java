package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class FelineTest {
    public Feline feline = new Feline();
    @Test
    public void getFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void getKittens() {
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }
}