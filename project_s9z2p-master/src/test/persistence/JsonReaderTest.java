package persistence;
import model.Champion;
import model.ChampionList;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

//Citation: JsonReaderTest based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/test/persistence/JsonReaderTest.java
import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ChampionList ch = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testEmptyChampList.json");
        try {
            ChampionList ch = reader.read();
            ChampionList chs = new ChampionList();
            assertEquals(0, ch.listToJson().getJSONArray("Champ_name").length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testChampListGeneral.json");
        try {
            ChampionList ch = reader.read();
            ChampionList chs = new ChampionList();
            assertEquals("ahri", ch.getName(0));
            chs.addNamelist("ahri");
            checkChamp("Ahri", new Champion("Ahri"));
            checkChamp("Draven", new Champion("Draven"));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}