package persistence;

import model.Champion;
import model.ChampionList;
import model.Event;
import model.EventLog;
import org.json.JSONObject;


import java.io.*;

// Represents a writer that writes JSON representation of workroom to file
//Citation: Model based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonWriter.java
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of championlist to file
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    public void write(ChampionList ch) {
        JSONObject json = ch.listToJson();
        saveToFile(json.toString(TAB));
        EventLog.getInstance().logEvent(new Event("Saved Champion to Championlist.json"));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    //Citation: Class based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java
    private void saveToFile(String json) {
        writer.print(json);
    }
}