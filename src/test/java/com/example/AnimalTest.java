package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {


    @Parameters
    public static Object[][] BlockOfAnimalTest() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"null", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    private final String animalKind;
    private final List<String> listOfFood;

    public AnimalTest(String animalKind, List<String> listOfFood) {
        this.listOfFood = listOfFood;
        this.animalKind = animalKind;
    }

    @Test
    public void animalTest() {

        try {
            Animal animal = new Animal();
            assertEquals(listOfFood, animal.getFood(animalKind));
        } catch (Exception thrown) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", thrown.getMessage());
        }

    }
}