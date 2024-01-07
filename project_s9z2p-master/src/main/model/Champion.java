package model;



//represents a champion with its attributes
public class Champion {
    private String name;
    private String trait;
    private String attribute;
    private String item1;
    private String item2;
    private String item3;
    private Integer cost;

    //Creates a new champion with the name
    public Champion(String champname) {
        this.name = champname;

    }

    //MODIFIES: this
    //EFFECTS: assign the trait attribute to the variable trait
    public String addTrait(String trait) {
        this.trait = trait;
        return trait;
    }

    //MODIFIES: this
    //EFFECTS: assign the attribute attribute to the variable attribute
    public String addAttribute(String attribute) {
        this.attribute = attribute;
        return attribute;
    }

    //MODIFIES: this
    //EFFECTS: assign the cost attribute to the variable cost
    public Integer addCost(Integer cost) {
        this.cost = cost;
        return cost;
    }

    //MODIFIES: this
    //EFFECTS: assign the items attribute to the variable item1,item2,item3
    public String addItems(String item1, String item2, String item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        return item1 + " " + item2 + " " + item3;
    }

    //EFFECTS: gets the cost of the Champion
    public Integer getCost() {
        return cost;
    }

    //EFFECTS: gets the items of the Champion
    public String getItems() {
        return item1 + " " + item2 + " " + item3;
    }

    //EFFECTS: gets the name of the Champion
    public String getName() {
        return name;
    }

    //EFFECTS: gets the trait of the Champion
    public String getTrait() {
        return trait;
    }

    //EFFECTS: gets the attribute of the Champion
    public String getAttribute() {
        return attribute;
    }

    // EFFECTS: Converts all the variables into a nice sentence/string
    public String toString() {
        return name + " has the trait " + trait + " and the attribute " + attribute
             + " with the items: " + item1 + ", " + item2 + ", " + item3 + " with the cost "
                + cost;

    }









}
