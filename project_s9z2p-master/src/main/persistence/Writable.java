package persistence;

import org.json.JSONObject;
//this function returns any file as JSON object
//This function was based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/Writable.java

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}