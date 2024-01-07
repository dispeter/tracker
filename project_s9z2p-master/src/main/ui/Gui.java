package ui;

import model.Champion;
import model.ChampionList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;

//This is the class and all the elements of the gui is located inside this class
public class Gui extends JFrame implements ActionListener {
    ChampionList chlist = new ChampionList();
    private static final String JSON_STORE = "./data/champlist.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    Champion champion;
    JFrame frame;
    JPanel panel;
    JButton addchampion;
    JButton printchampion;
    JButton sortchampion;
    JButton savechampion;
    JButton loadchampion;
    JButton exit;
    JButton rank;

    JTextArea print;
    JTextField tfname;
    JTextField tftrait;
    JTextField tfattri;
    JTextField tfitem1;
    JTextField tfitem2;
    JTextField tfitem3;
    JTextField tfcost;
    JLabel image;
    int counter = 0;


    //MODIFIES: jsonWriter,jsonReader
    //This is the constructor of the class and initializes the background and also the jsonWriter and jsonReader
    public Gui() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        createBackground();

    }

    //MODIFIES: frame,panel
    //EFFECTS: this method sets the frame with the boxlayout and sets the size of the frame.
    //This was insipred by
    //https://youtu.be/5o3fMLPY7qY
    public void createBackground() {
        frame = new JFrame();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelButtons();
        frame.setTitle("TFT App");
        frame.pack();
        frame.setVisible(true);
    }


    //MODIFIES: addchampion,printchampion,sortchampion,savechampion,exit,loadchampion,rank,panel
    //EFFECTS: this method adds an action listener to each one of the buttons and sets the text of each button
    // also add each of the button to the panel
    public void labelButtons() {
        addchampion = new JButton("Add your champion to the Champion List");
        printchampion = new JButton("Print out all the Champion in the Champion List");
        sortchampion = new JButton("Sort the champion by their cost");
        savechampion = new JButton("Save Championlistfile");
        loadchampion = new JButton("Load Championlistfile");
        rank = new JButton("Click to show a picture of the Tft Ranking System");
        exit = new JButton("Exit TftApp");
        print = new JTextArea();
        image = new JLabel();
        panel.add(addchampion);
        panel.add(printchampion);
        panel.add(sortchampion);
        panel.add(savechampion);
        panel.add(loadchampion);
        panel.add(rank);
        panel.add(exit);

        image.setVisible(false);
        print.setVisible(false);

        addAllLabels();

    }

    //MODIFIES: addchampion,printchampion,sortchampion,savechampion,exit,loadchampion,rank,panel
    //EFFECTS: this method  on the gui and addes action listeners to each button
    // and also add all the textfields to the panel
    public void addAllLabels() {
        addchampion.addActionListener(this);
        printchampion.addActionListener(this);
        sortchampion.addActionListener(this);
        savechampion.addActionListener(this);
        loadchampion.addActionListener(this);
        exit.addActionListener(this);
        rank.addActionListener(this);
        addAllLabelsHelper();
        panel.add(tfname);
        panel.add(tftrait);
        panel.add(tfattri);
        panel.add(tfitem1);
        panel.add(tfitem2);
        panel.add(tfitem3);
        panel.add(tfcost);
        panel.add(print);
        panel.add(image);
    }

    //MODIFIES: tfname,tfattri,tftrait,tfitem1,tfitem2,tfitem3,tfcost
    //EFFECTS: this method creates all the textfield and add an action listener to each one of them and set
    // their visibility as false so it only appears when the button is pressed
    public void addAllLabelsHelper() {
        tfname = new JTextField(100);
        tftrait = new JTextField(100);
        tfattri = new JTextField(100);
        tfitem1 = new JTextField(100);
        tfitem2 = new JTextField(100);
        tfitem3 = new JTextField(100);
        tfcost = new JTextField(100);
        tfname.addActionListener(this);
        tftrait.addActionListener(this);
        tfattri.addActionListener(this);
        tfitem1.addActionListener(this);
        tfitem2.addActionListener(this);
        tfitem3.addActionListener(this);
        tfcost.addActionListener(this);
        tfname.setVisible(false);
        tftrait.setVisible(false);
        tfattri.setVisible(false);
        tfitem1.setVisible(false);
        tfitem2.setVisible(false);
        tfitem3.setVisible(false);
        tfcost.setVisible(false);
    }

    //EFFECTS: this method calls on all the textfield required to complete the creation of a champion
    public void addChamps() {
        addChampionName();
        addChampionTrait();
        addChampionAttri();
        addChampionItem1();
        addChampionItem2();
        addChampionItem3();
        addChampionCost();

    }

    //MODIFIES: tfname
    //EFFECTS: this method changes the text of the textfield and is ready for the input of the user
    public void addChampionName() {
        tfname.setText("Enter your champion name");
        tfname.setVisible(true);

    }

    //MODIFIES: tftrait
    //EFFECTS: this method changes the text of the textfield and is ready for the input of the user
    public void addChampionTrait() {
        tftrait.setText("Enter your champion trait");
        tftrait.setVisible(true);

    }

    //MODIFIES: tfattri
    //EFFECTS: this method changes the text of the textfield and is ready for the input of the user
    public void addChampionAttri() {
        tfattri.setText("Enter your champion attribute");
        tfattri.setVisible(true);

    }

    //MODIFIES: tfitem1
    //EFFECTS: this method changes the text of the textfield and is ready for the input of the user
    public void addChampionItem1() {
        tfitem1.setText("Enter your champion item 1");
        tfitem1.setVisible(true);

    }

    //MODIFIES: tfitem2
    //EFFECTS: this method changes the text of the textfield and is ready for the input of the user
    public void addChampionItem2() {
        tfitem2.setText("Enter your champion item 2");
        tfitem2.setVisible(true);

    }

    //MODIFIES: tfitem3
    //EFFECTS: this method changes the text of the textfield and is ready for the input of the user
    public void addChampionItem3() {
        tfitem3.setText("Enter your champion item 3");
        tfitem3.setVisible(true);

    }

    //MODIFIES: tfcost
    //EFFECTS: this method changes the text of the textfield and is ready for the input of the user
    public void addChampionCost() {
        tfcost.setText("Enter your champion cost");
        tfcost.setVisible(true);
    }


    //EFFECTS: this method prints out all the champion that are in the class of ChampionList
    public void printAllChamps() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < chlist.getlength();i++) {
            sb.append((chlist.getName(i) + " has the trait " + chlist.getTrait(i)
                    + " and the attribute " + chlist.getAttri(i)
                    + " with the items: " + chlist.getItem1(i) + ", " + chlist.getItem2(i) + ", "
                    + chlist.getItem3(i) + " with the tier " + chlist.getCost(i) + "\n"));

        }
        print.setText(sb.toString());
    }

    //MODIFIES: chlist.sortByCost
    //EFFECTS: this method orders the champions in the champion list by the order of their cost in ascending order
    public void sortAllChamps() {
        chlist.sortByCost();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < chlist.getlength();i++) {
            sb.append((chlist.getName(i) + " has the trait " + chlist.getTrait(i)
                    + " and the attribute " + chlist.getAttri(i)
                    + " with the items: " + chlist.getItem1(i) + ", " + chlist.getItem2(i) + ", "
                    + chlist.getItem3(i) + " with the tier " + chlist.getCost(i) + "\n"));

        }
        print.setText(sb.toString());

    }



    //EFFECTS: this method contains all the actions performed by the buttons
    // when pressed such as collecting data or displaying images or texts;
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addchampion) {
            image.setVisible(false);
            print.setVisible(false);
            addChamps();
        } else if (e.getSource() == tfname) {
            String value = tfname.getText();
            chlist.addNamelist(value);
            tfname.setVisible(false);
        } else if (e.getSource() == tftrait) {
            String value = tftrait.getText();
            chlist.addTraitlist(value);
            tftrait.setVisible(false);
        } else if (e.getSource() == tfattri) {
            String value = tfattri.getText();
            chlist.addAttributelist(value);
            tfattri.setVisible(false);
        } else if (e.getSource() == tfitem1) {
            String value = tfitem1.getText();
            chlist.addItem1list(value);
            tfitem1.setVisible(false);
        } else if (e.getSource() == tfitem2) {
            String value = tfitem2.getText();
            chlist.addItem2list(value);
            tfitem2.setVisible(false);
        } else if (e.getSource() == tfitem3) {
            String value = tfitem3.getText();
            chlist.addItem3list(value);
            tfitem3.setVisible(false);
        } else if (e.getSource() == tfcost) {
            String value = tfcost.getText();
            Integer temp = Integer.parseInt(value);
            chlist.addCostList(temp);
            tfcost.setVisible(false);
            print.setVisible(true);
            print.setText(chlist.getName(0) + " has been correctly added to ChampionList class");
            counter += 1;
        } else if (e.getSource() == printchampion) {
            print.setVisible(true);
            image.setVisible(false);
            printAllChamps();
        } else if (e.getSource() == exit) {
            chlist.printEvent();
            System.exit(0);
        } else if (e.getSource() == savechampion) {
            print.setVisible(false);
            image.setVisible(false);
            try {
                jsonWriter.open();
                jsonWriter.write(chlist);
                jsonWriter.close();
            } catch (FileNotFoundException ex) {
                print.setText("Cant Find File");
            }

        } else if (e.getSource() == loadchampion) {
            print.setVisible(false);
            image.setVisible(false);
            try {
                chlist = jsonReader.read();
                System.out.println("Loaded Champion List from " + JSON_STORE);
                printAllChamps();
            } catch (IOException ex) {
                print.setText("Cant Find File");
            }

        } else if (e.getSource() == rank) {
            //This was insipred by
            //URL: https://www.tabnine.com/code/java/methods/java.awt.Image/getScaledInstance
            ImageIcon icon = new ImageIcon("./data/tftrank.jpeg");
            //This image was taken from
            //URL: https://sport.onet.pl/esportmania/league-of-legends/lol-wszystkie-rangi-w-league-of-legends-od-najnizszej-do-najwyzszej/pfwn767
            Image resize = icon.getImage();
            Image resizedimg = resize.getScaledInstance(400,400,java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedimg);
            image.setIcon(icon);
            image.setVisible(true);
        } else if (e.getSource() == sortchampion) {
            sortAllChamps();
        }


    }
}
