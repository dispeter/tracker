
package persistence;

import model.Champion;
import model.ChampionList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
//Citation: JsonWriter Test based on https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/test/persistence/JsonWriterTest.java

import static org.junit.jupiter.api.Assertions.*;
public class JsonWriterTest extends JsonTest{
    @Test
    void testWriterInvalidFile() {
        try {
            ChampionList ch= new ChampionList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }
    
    @Test
    void testWriterEmptyWorkroom() {
        try {
            ChampionList ch= new ChampionList();
            JsonWriter writer = new JsonWriter("./data/testEmptyChampList.json");
            writer.open();
            writer.write(ch);
            writer.close();
            JsonReader reader = new JsonReader("./data/testEmptyChampList.json");
            ch= reader.read();
            assertEquals(0, ch.listToJson().getJSONArray("Champ_name").length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            ChampionList ch= new ChampionList();
            ch.addNamelist("ahri");
            ch.addAttributelist("Syndicate");
            ch.addCostList(4);
            ch.addItem1list("IE");
            ch.addItem2list("JG");
            ch.addItem3list("BB");
            ch.addTraitlist("Arcanist");
            JsonWriter writer = new JsonWriter("./data/testChampListGeneral.json");
            writer.open();
            writer.write(ch);
            writer.close();

            JsonReader reader = new JsonReader("./data/testChampListGeneral.json");
            ChampionList cl = reader.read();
            assertEquals("ahri", cl.getName(0));
            assertEquals(4, cl.getCost(0));
            assertEquals("IE", cl.getItem1(0));
            assertEquals("JG", cl.getItem2(0));
            assertEquals("BB", cl.getItem3(0));
            assertEquals("Syndicate", cl.getAttri(0));
            assertEquals("Arcanist", cl.getTrait(0));


            checkChamp("Ahri", new Champion("Ahri"));
            checkChamp("Draven", new Champion("Draven"));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }



}
