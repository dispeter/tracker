package persistence;

import model.Champion;
import model.ChampionList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Event;
import model.EventLog;
import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
//Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
public class JsonReader {
    private String source;

    // EFFECTS: creates a json reader to read from source file
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads championlist from file and returns it;
    // throws IOException if an error occurs reading data from file
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    public ChampionList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseChampionlist(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses champlist from JSON object and returns it
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    private ChampionList parseChampionlist(JSONObject jsonObject) {
        ChampionList cl = new ChampionList();
        ChampionList champl = addChamps(jsonObject);

        return champl;
    }

    // MODIFIES: ch
    // EFFECTS: parses jsonarray from JSON object and adds them to championlist
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    private ChampionList addChamps(JSONObject jsonObject) {
        EventLog.getInstance().logEvent(new Event("Loaded Champion to Championlist.json"));
        JSONArray champ = jsonObject.getJSONArray("Champ_name");
        JSONArray trait = jsonObject.getJSONArray("Champ_trait");
        JSONArray attri = jsonObject.getJSONArray("Champ_atttribute");
        JSONArray item1 = jsonObject.getJSONArray("Champ_item1");
        JSONArray item2 = jsonObject.getJSONArray("Champ_item2");
        JSONArray item3 = jsonObject.getJSONArray("Champ_item3");
        JSONArray cost = jsonObject.getJSONArray("Champ_cost");
        ChampionList ch = new ChampionList();
        for (int i = 0; i < champ.length(); i++) {
            ch.addNamelist(champ.getString(i));
            ch.addTraitlist(trait.getString(i));
            ch.addItem3list(item3.getString(i));
            ch.addAttributelist(attri.getString(i));
            ch.addCostList(cost.getInt(i));
            ch.addItem2list(item2.getString(i));
            ch.addItem1list(item1.getString(i));

        }
//        System.out.println(ch.getName(2));
        return ch;

    }
    //make a helper to initiaite the champion and load the information correctly


}
