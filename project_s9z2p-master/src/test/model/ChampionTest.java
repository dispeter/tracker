package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class ChampionTest {
    private Champion testChampion;

    @BeforeEach
    void runBefore() {
        testChampion = new Champion("Ahri");
    }



    @Test
    void testConstructor() {
        assertEquals("Ahri", testChampion.getName());
    }

    @Test
    void teststringAddTrait() {
        testChampion.addTrait("Syndicate");
        assertEquals("Syndicate", testChampion.getTrait());
    }

    @Test
    void testaddAttribute() {
        testChampion.addAttribute("Arcanist");
        assertEquals("Arcanist", testChampion.getAttribute());
    }

    @Test
    void testaddItems() {
        testChampion.addItems("Jeweled Gauntlet", "Infinity Edge", "Blue Buff");
        assertEquals("Jeweled Gauntlet Infinity Edge Blue Buff", testChampion.getItems());
    }
    @Test
    void testaddCost() {
        testChampion.addCost(2);
        assertEquals(2, testChampion.getCost());
    }






    @Test
     void testToString() {
        testChampion.addTrait("Syndicate");
        testChampion.addAttribute("Arcanist");
        testChampion.addItems("Jeweled Gauntlet", "Infinity Edge", "Blue Buff");
        testChampion.addCost(2);
        assertEquals("Ahri has the trait Syndicate and the attribute Arcanist with the items: Jeweled Gauntlet, Infinity Edge, Blue Buff with the cost " + 2, testChampion.toString());
     }









    
}