package model;

import model.MapModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapModelTest {
    private MapModel mp;

    @Before
    public void checkReadMap() {
        String relativePathname = "src/main/java/model/chunks.csv";
        mp = new MapModel(40, 20, 1, relativePathname);
    }

    @Test
    public void checkSuccessfulMove(){
        mp.moveEast();
        assertEquals(3, mp.getId());
    }

    @Test
    public void checkFailedMove(){
        mp.moveSouth();
        assertEquals(1, mp.getId());
        mp.moveNorth();
        assertEquals(1, mp.getId());
        mp.moveWest();
        assertEquals(1, mp.getId());
    }
}
