package persistence;

import model.Champion;
import model.ChampionList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Citation: Test based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/test/persistence/JsonTest.java
public class JsonTest {
    protected void checkChamp(String name, Champion ch) {
        assertEquals(name, ch.getName());
    }
}