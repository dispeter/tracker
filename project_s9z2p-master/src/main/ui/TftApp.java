package ui;

import model.Champion;

import model.ChampionList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//EFFECTS: initializes all the class and scanner variables

public class TftApp {

    private static final String JSON_STORE = "./data/champlist.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    ChampionList chlist = new ChampionList();
    Champion champion;
    Scanner in = new Scanner(System.in);
    int counter = 1;

    int picking;
    boolean champstolist;





    //EFFECTS: initializes the TFT application
    public TftApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runTft();

    }





    //MODIFIES: this
    //EFFECTS: takes the user input and determine the result of it
    private void runTft() {


        boolean loop = true;


        while (loop) {

            showMenu();
            picking = in.nextInt();


            choice(picking);


            if (picking == 6) {
                System.out.println("TftApp has ended");
                loop = false;
            }

        }
    }


    //EFFECTS: Shows the menu to the user as to what to decide
    private void showMenu() {
        System.out.println("Press 1 to add a champion \nPress 2 to print all champs added"
                + "\nPress 3 to sort the champs by cost\nPress 4 to save file"
                + "\nPress 5 to load file\nPress 6 to end the App");
    }

    //EFFECTS: Decides the user input based on the option the user selected
    private void choice(int pick) {
        if (pick == 1) {
            nameChamp();
            nameTrait();
            nameAttribute();
            nameItems();
            nameCost();
            printchamp();
            counter++;
        } else if (pick == 2) {
            printallchamps();
        } else if (pick == 3) {
            sortByCost();
        } else if (pick == 4) {
            saveChamplist();
        }  else if (pick == 5) {
            loadChamplist();
        } else {
            System.out.println("Please try again");
        }
    }

    // EFFECTS: saves the champlist to file
    private void saveChamplist() {
        try {
            jsonWriter.open();
            jsonWriter.write(chlist);
            jsonWriter.close();
            System.out.println("Saved " + chlist.getName(counter - 2) + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: thisSystem.out.println(chlist.getName(0));
    // EFFECTS: loads champslist from file
    private void loadChamplist() {
        try {
            chlist = jsonReader.read();
            System.out.println("Loaded Champion List from " + JSON_STORE);
            counter += 1;
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



    private void sortByCost() {
        for (int i = 0; i < counter;i++) {
            chlist.sortByCost();
        }

        printallchamps();

    }

    // MODIFIES: this
    // EFFECTS: loads the txt and promting the user to add the champion name
    private void nameChamp() {
        System.out.println("Enter the name of the champion you would like to add");
        in.nextLine();
        String championname  = in.nextLine();
        chlist.addNamelist(championname);
        champion = new Champion(championname);
    }

    // MODIFIES: this
    // EFFECTS: loads the txt and promting the user to add the trait name
    private void nameTrait() {
        System.out.println("Enter the trait of the champion you would like to add");
        String traitname  = in.nextLine();
        chlist.addTraitlist(traitname);
        champion.addTrait(traitname);
    }

    // MODIFIES: this
    // EFFECTS: loads the txt and promting the user to add the attribute name
    private void nameAttribute() {
        System.out.println("Enter the Attribute of the champion you would like to add");
        String attributename  = in.nextLine();
        chlist.addAttributelist(attributename);
        champion.addAttribute(attributename);
    }

    // MODIFIES: this
    // EFFECTS: loads the txt and promting the user to add the items name
    private void nameItems() {
        System.out.println("Enter the items of the champion you would like to add");
        String item1  = in.nextLine();
        String item2  = in.nextLine();
        String item3  = in.nextLine();
        champion.addItems(item1,item2,item3);
        chlist.addItem1list(item1);
        chlist.addItem2list(item2);
        chlist.addItem3list(item3);
    }

    // MODIFIES: this
    // EFFECTS: loads the txt and promting the user to add the Cost
    private void nameCost() {
        System.out.println("Enter the Cost of the champion you would like to add");
        Integer cost  = in.nextInt();
        champion.addCost(cost);
        chlist.addCostList(cost);

    }




    // EFFECTS: prints all the champions that are added to the list
    private void printchamp() {
        System.out.println(champion.toString());
    }

    //EFFECTS: Prints all the champs that are in the list and all of their attributes in a clean and concise format and
    // return true for the function if the size of the name list is larger than 0
    // unless if there are no champions in the pool then the function will return false
    public void printallchamps() {
        if (counter >= 0) {

            for (int i = 0; i < chlist.getlength(); i++) {
                System.out.println((chlist.getName(i) + " has the trait " + chlist.getTrait(i)
                        + " and the attribute " + chlist.getAttri(i)
                        + " with the items: " + chlist.getItem1(i) + ", " + chlist.getItem2(i) + ", "
                        + chlist.getItem3(i) + " with the tier " + chlist.getCost(i)));
            }
        } else {
            System.out.println("No champions have been added to the pool");
        }
    }


}

