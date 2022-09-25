package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testDoesMaleHaveMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesFemaleHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeException() {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Male", feline);
            lion.doesHaveMane();
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}

