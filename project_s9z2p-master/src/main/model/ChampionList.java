package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
//represents the class of championlist which contains all the list of the attributes of a champion

public class ChampionList {
    //creating arraylists that is used to store all the attributes of the champion
    ArrayList<String> namelist = new ArrayList<>();
    ArrayList<String> traitlist = new ArrayList<>();
    ArrayList<String> attributelist = new ArrayList<>();
    ArrayList<String> item1list = new ArrayList<>();
    ArrayList<String> item2list = new ArrayList<>();
    ArrayList<String> item3list = new ArrayList<>();
    ArrayList<Integer> costlist = new ArrayList<>();

    //MODIFIES: all the list
    //EFFECTS: swapping all the elements in the list so it is in order
    private void sortThisHelper(int x, int z) {
        int smallest = costlist.get(x);
        String nametemp = namelist.get(x);
        namelist.set(x,namelist.get(z));
        namelist.set(z,nametemp);
        String traittemp = traitlist.get(x);
        traitlist.set(x,traitlist.get(z));
        traitlist.set(z,traittemp);
        String attritemp = attributelist.get(x);
        attributelist.set(x,attributelist.get(z));
        attributelist.set(z,attritemp);
        String item1temp = item1list.get(x);
        item1list.set(x,item1list.get(z));
        item1list.set(z,item1temp);
        String item2temp = item2list.get(x);
        item2list.set(x,item2list.get(z));
        item2list.set(z,item2list.get(x));
        String item3temp = item3list.get(x);
        item3list.set(x,item3list.get(z));
        item3list.set(z,item3temp);
        costlist.set(x, costlist.get(z));
        costlist.set(z,smallest);
    }

    //MODIFIES: all the list in this class
    //EFFECTS: sorts the lists according to the cost
    public void sortByCost() {
        EventLog.getInstance().logEvent(new Event("Sorted Champion to Championlist"));
        for (int x = 0; x < costlist.size() - 1; x++) {
            int z  = x;
            for (int y = x + 1; y < costlist.size(); y++) {
                if (costlist.get(x) < costlist.get(y)) {
                    z = y;
                }
            }
            sortThisHelper(x,z);

        }
    }

    //MODIFIES: namelist
    //EFFECTS: adds the name attribute to the arraylist namelist
    public void addNamelist(String name) {
        namelist.add(name);
        EventLog.getInstance().logEvent(new Event("Added Champion to Championlist"));
    }

    //MODIFIES: traitlist
    //EFFECTS: adds the trait attribute to the arraylist traitlist
    public void addTraitlist(String trait) {
        traitlist.add(trait);
    }

    //MODIFIES: attributelist
    //EFFECTS: adds the atttribute attribute to the arraylist attributelist
    public void addAttributelist(String attribute) {
        attributelist.add(attribute);
    }

    //MODIFIES: item1list
    //EFFECTS: adds the item1 attribute to the arraylist item1list
    public void addItem1list(String item) {
        item1list.add(item);
    }

    //MODIFIES: item2list
    //EFFECTS: adds the item2 attribute to the arraylist item2list
    public void addItem2list(String item) {
        item2list.add(item);
    }

    //MODIFIES: item3list
    //EFFECTS: adds the item3 attribute to the arraylist item3list
    public void addItem3list(String item) {
        item3list.add(item);
    }

    //MODIFIES: costlist
    //EFFECTS: adds the costlist attribute to the arraylist costlist
    public void addCostList(Integer cost) {
        costlist.add(cost);
    }

    //EFFECTS: returns the name
    public String getName(int i) {
        return namelist.get(i);
    }

    public Integer getlength() {
        return namelist.size();
    }

    //EFFECTS: returns the trait
    public String getTrait(int i) {
        return traitlist.get(i);
    }

    //EFFECTS: returns the attribute
    public String getAttri(int i) {
        return attributelist.get(i);
    }

    //EFFECTS: returns item1
    public String getItem1(int i) {
        return item1list.get(i);
    }

    //EFFECTS: returns item2
    public String getItem2(int i) {
        return item2list.get(i);
    }

    //EFFECTS: returns item3
    public String getItem3(int i) {
        return item3list.get(i);
    }

    //EFFECTS: returns tier
    public Integer getCost(int i) {
        return costlist.get(i);
    }


    JSONArray jsonnamearray = new JSONArray();
    JSONArray jsontraitarray = new JSONArray();
    JSONArray jsonattriarray = new JSONArray();
    JSONArray jsonitem1array = new JSONArray();
    JSONArray jsonitem2array = new JSONArray();
    JSONArray jsonitem3array = new JSONArray();
    JSONArray jsoncostarray = new JSONArray();

    // EFFECTS: returns things in this championlist as a JSON array
    public JSONObject listToJson() {
        for (int i = 0; i < namelist.size(); i++) {
            jsonnamearray.put(namelist.get(i));
            jsontraitarray.put(traitlist.get(i));
            jsonattriarray.put(attributelist.get(i));
            jsonitem1array.put(item1list.get(i));
            jsonitem2array.put(item2list.get(i));
            jsonitem3array.put(item3list.get(i));
            jsoncostarray.put(costlist.get(i));
        }
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("Champ_name", jsonnamearray);
        jsonobj.put("Champ_trait", jsontraitarray);
        jsonobj.put("Champ_atttribute", jsonattriarray);
        jsonobj.put("Champ_item1", jsonitem1array);
        jsonobj.put("Champ_item2", jsonitem2array);
        jsonobj.put("Champ_item3", jsonitem3array);
        jsonobj.put("Champ_cost", jsoncostarray);
        return jsonobj;
    }

    public void printEvent() {
        for (Event e:EventLog.getInstance()) {
            System.out.println(e);
        }

    }





}
