package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class LionTest {

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testDoesMaleHaveMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesFemaleHaveMane() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeException() {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Male");
            lion.doesHaveMane();
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}

