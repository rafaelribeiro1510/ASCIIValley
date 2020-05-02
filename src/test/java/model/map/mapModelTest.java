package model.map;

import model.MapModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class mapModelTest {

    @Test
    public void checkReadMap() {
        String relativePathname = "src/main/java/model/map/chunks.csv";
        MapModel mp = new MapModel(40, 20, 1, relativePathname);
        mp.readMap(relativePathname);
        // assertEquals(1, mp.getChunk().getId());

    }

    @Test (expected = Exception.class)
    public void checkMapFileRead() {
        String relativePathname = "/src/main/java/model/map/chunks.csv";
        MapModel mp = new MapModel(40, 20, 1, relativePathname);
        mp.readMap(relativePathname);

        assertEquals(1, mp.thisChunk().getId());
    }
}
