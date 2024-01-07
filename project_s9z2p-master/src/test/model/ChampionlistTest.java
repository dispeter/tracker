package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

//Testing all the methods in the championlist class
public class ChampionlistTest {
    private ChampionList cl;

    @BeforeEach
    void runBefore() {
        cl = new ChampionList();
    }

    @Test
    void testAddNameList() {
        cl.addNamelist("Reksai");
        assertEquals("Reksai", cl.namelist.get(0));
    }

    @Test
    void testAddTraitList() {
        cl.addTraitlist("Bruiser");
        assertEquals("Bruiser", cl.traitlist.get(0));
    }

    @Test
    void testAddAttributelist() {
        cl.addAttributelist("Striker");
        assertEquals("Striker", cl.attributelist.get(0));
    }

    @Test
    void testAddItem1list() {
        cl.addItem1list("Bramble Vest");
        assertEquals("Bramble Vest", cl.item1list.get(0));
    }

    @Test
    void testAddItem2list() {
        cl.addItem2list("Dragon Claw");
        assertEquals("Dragon Claw", cl.item2list.get(0));
    }

    @Test
    void testAddItem3list() {
        cl.addItem3list("War mog");
        assertEquals("War mog", cl.item3list.get(0));
    }
    @Test
    void testAddTierList() {
        cl.addCostList(4);
        assertEquals(4, cl.costlist.get(0));
    }

    @Test
    void testMultipleValues() {
        cl.addNamelist("Zeri");
        cl.addNamelist("Irelia");
        assertEquals("Zeri", cl.namelist.get(0));
        assertEquals("Irelia", cl.namelist.get(1));
    }

    @Test
    void testGetName() {
        cl.addNamelist("Ahri");
        assertEquals("Ahri", cl.getName(0));
    }

    @Test
    void testGetAttri() {
        cl.addAttributelist("Syndicate");
        assertEquals("Syndicate", cl.getAttri(0));
    }

    @Test
    void testGetTrait() {
        cl.addTraitlist("Arcanist");
        assertEquals("Arcanist", cl.getTrait(0));
    }

    @Test
    void testGetItem1() {
        cl.addItem1list("IE");
        assertEquals("IE", cl.getItem1(0));
    }

    @Test
    void testGetItem2() {
        cl.addItem2list("JG");
        assertEquals("JG", cl.getItem2(0));
    }

    @Test
    void testGetItem3() {
        cl.addItem3list("BB");
        assertEquals("BB", cl.getItem3(0));
    }

    @Test
    void testGetCost() {
        cl.addCostList(4);
        assertEquals(4, cl.getCost(0));
    }


    @Test
    void testGetLength() {
        cl.addNamelist("ahri");
        cl.addAttributelist("syndicate");
        cl.addTraitlist("Arcanist");
        cl.addItem1list("IE");
        cl.addItem2list("JG");
        cl.addItem3list("BB");
        cl.addCostList(4);
        assertEquals(1,cl.getlength());
    }

    @Test
    void testSort() {
        cl.addNamelist("ahri");
        cl.addNamelist("draven");
        cl.addAttributelist("syndicate");
        cl.addAttributelist("challenger");
        cl.addTraitlist("Arcanist");
        cl.addTraitlist("debonair");
        cl.addItem1list("IE");
        cl.addItem1list("IE");
        cl.addItem2list("JG");
        cl.addItem2list("BT");
        cl.addItem3list("BB");
        cl.addItem3list("LW");
        cl.addCostList(2);
        cl.addCostList(4);
        ArrayList<Integer> ai = new ArrayList<>();
        ai.add(4);
        ai.add(2);
        cl.sortByCost();
        assertEquals(ai,cl.costlist);


    }

    @Test
    void testCantSort() {
        cl.addNamelist("ahri");
        cl.addNamelist("draven");
        cl.addAttributelist("syndicate");
        cl.addAttributelist("challenger");
        cl.addTraitlist("Arcanist");
        cl.addTraitlist("debonair");
        cl.addItem1list("IE");
        cl.addItem1list("IE");
        cl.addItem2list("JG");
        cl.addItem2list("BT");
        cl.addItem3list("BB");
        cl.addItem3list("LW");
        cl.addCostList(4);
        cl.addCostList(2);
        ArrayList<Integer> ai = new ArrayList<>();
        ai.add(4);
        ai.add(2);
        cl.sortByCost();
        assertEquals(ai,cl.costlist);


    }







}
