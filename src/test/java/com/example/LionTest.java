package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class LionTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Feline feline;
    Lion lion;

    @Test
    public void getKittens() throws Exception {
        try {
            Mockito.when(feline.getKittens()).thenReturn(1);
        } catch (Exception e) {
            Lion lion = new Lion("Самец", feline);

            assertEquals(1, feline.getKittens());
        }
    }
    @Test
    public void unsupportedSex() throws Exception {
        try {
            Exception e = assertThrows(Exception.class, () ->
                    new Lion("Мужик", feline));
            assertEquals("Используйте допустимые значения пола животного - Самец или Самка", e.getMessage());
        } catch (Exception e) {
            Lion lion = new Lion("Самец", feline);
            assertNotEquals("Используйте допустимые значения пола животного - Самец или Самка", e.getMessage());
        }
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(lion.getFood(feline), feline.getFood("Хищник"));
    }
}