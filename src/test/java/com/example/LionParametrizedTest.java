package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;
    private final boolean haveMane;

    public LionParametrizedTest(String sex, boolean haveMane) {
        this.sex = sex;
        this.haveMane = haveMane;
    }

    @Parameterized.Parameters(name = "Гендер: {0}, Ожидаем: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Самка", true},
                {"18", true}
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
    public void doesHaveMane() throws Exception {
        try {
            Mockito.when(lion.doesHaveMane()).thenReturn(true);
        } catch (Exception e) {
            Lion lion = new Lion(sex, feline);
            assertNotEquals(haveMane, false);
            e.getMessage();
            e.printStackTrace();
        }
    }
}
