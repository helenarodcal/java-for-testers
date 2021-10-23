package com.serenitydojo;

import com.serenitydojo.model.Feeder;
import org.junit.Assert;
import org.junit.Test;

public class WhenFeedingTheAnimals {

    @Test
    public void shouldFeedCatsTuna() {
        Feeder feeder = new Feeder();

        String food = feeder.feeds("Cat", false);

        Assert.assertEquals("Tuna", food);
//        System.out.println(food);
    }

    @Test
    public void shouldFeedHamstersCabbage() {
        Feeder feeder = new Feeder();

        String food = feeder.feeds("Hamster", false);

        Assert.assertEquals("Cabbage", food);
//        System.out.println(food);
    }
    @Test
    public void shouldFeedDogsMeat() {
        Feeder feeder = new Feeder();

        String food = feeder.feeds("Dog",false);

        Assert.assertEquals("Meat", food);
//        System.out.println(food);
    }

    @Test
    public void shouldPremiumCatsPremiumFood() {
        Feeder feeder = new Feeder();

        String food = feeder.feeds("Cat", true);

        Assert.assertEquals("Salmon", food);
//        System.out.println(food);
    }
}
