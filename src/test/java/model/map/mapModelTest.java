package model.map;

import model.Position;
import model.entities.PlayerModel;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class mapModelTest {

    @Test
    public void checkReadMap() {
        String relativePathname = "src/main/java/model/map/chunks.csv";
        MapModel mp = new MapModel(40, 20, Mockito.mock(PlayerModel.class), 1, relativePathname);
        mp.readMap();
        assertEquals(1, mp.getChunk().getId());

    }

    @Test (expected = Exception.class)
    public void checkMapFileRead() {
        String relativePathname = "/src/main/java/model/map/chunks.csv";
        MapModel mp = new MapModel(40, 20, Mockito.mock(PlayerModel.class), 1, relativePathname);
        mp.readMap();

        assertEquals(1, mp.getChunk().getId());
    }
}
