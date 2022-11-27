package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean haveMane;

    public LionTest(String sex, boolean haveMane) {
        this.sex = sex;
        this.haveMane = haveMane;
    }

    @Parameterized.Parameters(name = "Гендер: {0}, Ожидаем: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Самка", true},
                {"18", true},
                {"Самец", " "}
        };
    }

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
            Lion lion = new Lion(sex, feline);
            assertEquals(1, feline.getKittens());
        }
    }

    @Test
    public void doesHaveMane() throws Exception {
        try {
            Mockito.when(lion.doesHaveMane()).thenReturn(true); //lion.doesHaveMane();
        } catch (Exception e) {
            Lion lion = new Lion(sex, feline);
            assertNotEquals(haveMane, true);
            e.getMessage();
        }
    }

    @Test
    public void UnsupportedSex() throws Exception {
        try {
            Exception e = assertThrows(Exception.class, () ->
                    new Lion(sex, feline));
            assertEquals("Используйте допустимые значения пола животного - Самец или Самка", e.getMessage());
        } catch (Exception e) {
            Lion lion = new Lion(sex, feline);
            assertNotEquals("Используйте допустимые значения пола животного - Самец или Самка", e.getMessage());
        }
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(lion.getFood(), feline.getFood("Хищник"));
    }
}